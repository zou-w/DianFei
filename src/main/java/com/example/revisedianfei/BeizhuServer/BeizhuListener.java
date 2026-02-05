package com.example.revisedianfei.BeizhuServer;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.revisedianfei.HuikuanServer.HuikuanData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 性能优化版BeizhuListener
 *
 * 优化策略：
 * 1. 使用HashMap索引替代双重嵌套循环，将时间复杂度从O(n*m)降至O(n+m)
 * 2. 预处理回款数据，建立多维度索引
 * 3. 减少不必要的对象创建
 */
public class BeizhuListener extends AnalysisEventListener<BeizhuData> {
    private static final Logger log = LoggerFactory.getLogger(BeizhuListener.class);

    private final List<BeizhuData> beizhuDataList = new ArrayList();
    private final List<HuikuanData> huikuanDataList;

    // 优化：使用多级索引加速匹配
    // 结构：供电方式 → 运营商 → (户号/电表) → 回款列表
    private final Map<String, Map<String, Map<String, List<HuikuanData>>>> huikuanIndex = new HashMap();

    private final List<TempBeizhuData1> yishoulist = new ArrayList();
    private final List<TempBeizhuData2> weishoulist = new ArrayList();
    private final List<HuikuanData> yushoulist = new ArrayList();
    private final List<HuikuanData> yiweishoulist = new ArrayList();

    public BeizhuListener(List<HuikuanData> huikuanDataList) {
        this.huikuanDataList = huikuanDataList;
        buildIndex(); // 预处理：构建索引
    }

    /**
     * 构建回款数据索引，O(m)时间复杂度
     * 结构：Map<供电方式, Map<运营商, Map<户号/电表, List<HuikuanData>>>>
     */
    private void buildIndex() {
        log.info("开始构建回款数据索引，回款记录数: {}", huikuanDataList.size());

        for (HuikuanData hk : huikuanDataList) {
            String gdfs = hk.getSfzgd() != null && hk.getSfzgd().equals("是") ? "直供电" : "转供电";
            String yys = hk.getYys() != null ? hk.getYys().trim() : "NULL";

            // 根据供电方式选择匹配键
            String matchKey = "直供电".equals(gdfs) ? hk.getHh() : hk.getDb();
            if (matchKey == null) continue;
            matchKey = matchKey.trim();

            // 构建三级Map
            huikuanIndex.computeIfAbsent(gdfs, k -> new HashMap<>())
                    .computeIfAbsent(yys, k -> new HashMap<>())
                    .computeIfAbsent(matchKey, k -> new ArrayList<>())
                    .add(hk);
        }

        log.info("索引构建完成");
    }

    @Override
    public void invoke(BeizhuData beizhuData, AnalysisContext context) {
        // 标准化数据
        String gdfs = beizhuData.getGdfs() != null ? beizhuData.getGdfs().trim() : "";
        String ftcs = beizhuData.getFtcs() != null ? beizhuData.getFtcs().trim() : "";
        String hh = beizhuData.getHh() != null ? beizhuData.getHh().trim() : "";
        String db = beizhuData.getDb() != null ? beizhuData.getDb().trim() : "";
        Double qd = beizhuData.getQd();
        Double zd = beizhuData.getZd();

        log.info("处理支付数据：供电方式={}, 运营商={}, 户号={}, 电表={}, 起度={}, 止度={}",
                 gdfs, ftcs, hh, db, qd, zd);

        // 从索引中快速查找匹配的回款记录
        Map<String, Map<String, List<HuikuanData>>> gdfsMap = huikuanIndex.get(gdfs);

        if (gdfsMap == null) {
            log.warn("未找到匹配的供电方式: {}", gdfs);
            beizhuData.setBz("未收（度数）");
            processUnpaid(beizhuData);
            return;
        }

        Map<String, List<HuikuanData>> yysMap = gdfsMap.get(ftcs);
        if (yysMap == null) {
            log.warn("未找到匹配的运营商: {} (供电方式: {})", ftcs, gdfs);
            beizhuData.setBz("未收（度数）");
            processUnpaid(beizhuData);
            return;
        }

        // 根据供电方式选择匹配键
        String matchKey = "直供电".equals(gdfs) ? hh : db;
        List<HuikuanData> matchedHuikuans = matchKey != null && !matchKey.isEmpty() ? yysMap.get(matchKey) : null;

        if (matchedHuikuans == null || matchedHuikuans.isEmpty()) {
            log.warn("未找到匹配的户号/电表: {} (供电方式: {}, 运营商: {})", matchKey, gdfs, ftcs);
            beizhuData.setBz("未收（度数）");
            processUnpaid(beizhuData);
            return;
        }

        log.info("找到匹配的回款记录数: {}", matchedHuikuans.size());

        // 处理匹配的回款记录
        processMatchedRecords(beizhuData, matchedHuikuans);

        this.beizhuDataList.add(beizhuData);
        System.out.println("过程中处理数据条数：" + this.beizhuDataList.size());
    }

    /**
     * 处理匹配的回款记录
     */
    private void processMatchedRecords(BeizhuData beizhuData, List<HuikuanData> matchedHuikuans) {
        boolean foundMatch = false;
        
        for (HuikuanData huikuan : matchedHuikuans) {
            if (huikuan.getQsds() == null || huikuan.getJzds() == null) continue;

            double payQd = beizhuData.getQd() != null ? beizhuData.getQd() : 0.0;
            double payZd = beizhuData.getZd() != null ? beizhuData.getZd() : 0.0;
            double hkQsds = huikuan.getQsds();
            double hkJzds = huikuan.getJzds();

            log.info("匹配回款记录：起始度数={}, 截止度数={}", hkQsds, hkJzds);

            // 判断区间重叠 - 使用更精确的匹配逻辑
            boolean hasOverlap = !(payZd <= hkQsds || payQd >= hkJzds);
            
            if (hasOverlap) {
                foundMatch = true;
                
                // 完全匹配
                if (Math.abs(payQd - hkQsds) < 0.01 && Math.abs(payZd - hkJzds) < 0.01) {
                    // 检查比例差异
                    double payFtbl = beizhuData.getFtbl() != null ? beizhuData.getFtbl() : 0.0;
                    double hkFtbl = huikuan.getYdgxbl() != null ? huikuan.getYdgxbl() : 0.0;
                    double ratioDiff = Math.abs(hkFtbl - payFtbl);

                    log.info("完全匹配：支付比例={}, 回款比例={}, 差异={}", payFtbl, hkFtbl, ratioDiff);
                    
                    if (ratioDiff < 0.03) {
                        beizhuData.setBz("本月已收");
                        log.info("标记为：本月已收");
                    } else {
                        beizhuData.setBz("本月已收+未收（比例）");
                        yiweishoulist.add(huikuan);
                        processPartialPaidByRatio(beizhuData, huikuan, hkFtbl);
                        log.info("标记为：本月已收+未收（比例）");
                        return;
                    }
                } 
                // 部分匹配
                else {
                    if (payZd <= hkJzds) {
                        if (payZd < hkJzds) {
                            // 需要拆分回款记录
                            HuikuanData splitHuikuan = createSplitHuikuan(huikuan, payZd);
                            yushoulist.add(splitHuikuan);
                        }

                        if (payQd >= hkQsds) {
                            beizhuData.setBz("本月已收");
                            log.info("标记为：本月已收");
                        } else {
                            beizhuData.setBz("之前已收+本月已收");
                            log.info("标记为：之前已收+本月已收");
                        }
                    } else if (payQd >= hkQsds) {
                        beizhuData.setBz("本月已收+未收（度数）");
                        yiweishoulist.add(huikuan);
                        processPartialPaidByDegree(beizhuData, huikuan, hkJzds);
                        log.info("标记为：本月已收+未收（度数）");
                        return;
                    } else {
                        beizhuData.setBz("之前已收+本月已收+未收（度数）");
                        yiweishoulist.add(huikuan);
                        processPartialPaidByDegree(beizhuData, huikuan, hkJzds);
                        log.info("标记为：之前已收+本月已收+未收（度数）");
                        return;
                    }
                }
                break; // 找到匹配后退出循环
            }
        }

        // 如果没有找到匹配的回款记录
        if (!foundMatch) {
            beizhuData.setBz("未收（度数）");
            log.warn("未找到匹配的回款记录，标记为：未收（度数）");
        }

        // 最终处理：根据备注状态决定分类
        processFinalClassification(beizhuData);
    }

    /**
     * 处理按比例拆分的未收记录
     */
    private void processPartialPaidByRatio(BeizhuData beizhuData, HuikuanData huikuan, double hkFtbl) {
        TempBeizhuData1 paid = createTempBeizhuData1(beizhuData);
        paid.setFtbl(hkFtbl);
        double ysdf = beizhuData.getYsdf() != null ? beizhuData.getYsdf() : 0.0;
        paid.setFtje(ysdf * hkFtbl);
        paid.setBz("本月已收");
        yishoulist.add(paid);

        TempBeizhuData2 unpaid = createTempBeizhuData2(beizhuData);
        double payFtbl = beizhuData.getFtbl() != null ? beizhuData.getFtbl() : 0.0;
        unpaid.setFtbl(payFtbl - hkFtbl);
        unpaid.setFtje(ysdf * (payFtbl - hkFtbl));
        unpaid.setBz("未收（比例）");
        weishoulist.add(unpaid);
    }

    /**
     * 处理按度数拆分的未收记录
     */
    private void processPartialPaidByDegree(BeizhuData beizhuData, HuikuanData huikuan, double splitDegree) {
        // 已收部分
        TempBeizhuData1 paid = createTempBeizhuData1(beizhuData);
        paid.setZd(splitDegree);
        double paidZfdl = paid.getZd() - paid.getQd();
        paid.setZfdl(paidZfdl);

        double totalZfdl = beizhuData.getZfdl() != null ? beizhuData.getZfdl() : 0.0;
        double totalFtje = beizhuData.getFtje() != null ? beizhuData.getFtje() : 0.0;
        paid.setFtje(paidZfdl / totalZfdl * totalFtje);

        if (paid.getQd() < splitDegree) {
            paid.setBz("之前已收+本月已收");
        } else {
            paid.setBz("本月已收");
        }
        yishoulist.add(paid);

        // 未收部分
        TempBeizhuData2 unpaid = createTempBeizhuData2(beizhuData);
        unpaid.setQd(splitDegree);
        unpaid.setZfdl(unpaid.getZd() - unpaid.getQd());
        unpaid.setFtje(unpaid.getZfdl() / totalZfdl * totalFtje);
        unpaid.setBz("未收（度数）");
        weishoulist.add(unpaid);
    }

    /**
     * 处理未收记录
     */
    private void processUnpaid(BeizhuData beizhuData) {
        TempBeizhuData2 unpaid = createTempBeizhuData2(beizhuData);
        weishoulist.add(unpaid);
    }

    /**
     * 最终分类处理
     */
    private void processFinalClassification(BeizhuData beizhuData) {
        String bz = beizhuData.getBz();
        if (bz != null && bz.equals("未收（度数）")) {
            processUnpaid(beizhuData);
        } else if (bz != null && (bz.equals("本月已收") || bz.equals("之前已收") || bz.equals("之前已收+本月已收"))) {
            TempBeizhuData1 paid = createTempBeizhuData1(beizhuData);
            yishoulist.add(paid);
        }
    }

    /**
     * 创建拆分后的回款记录
     */
    private HuikuanData createSplitHuikuan(HuikuanData original, double newQsds) {
        HuikuanData split = new HuikuanData();
        split.setQy(original.getQy());
        split.setYys(original.getYys());
        split.setZdmc(original.getZdmc());
        split.setZzbm(original.getZzbm());
        split.setHh(original.getHh());
        split.setDb(original.getDb());
        split.setYdgxbl(original.getYdgxbl());
        split.setYdgxqk(original.getYdgxqk());
        split.setJfkssj(original.getJfkssj());
        split.setJfjssj(original.getJfjssj());
        split.setZfzje(original.getZfzje());
        split.setDs(original.getDs());
        split.setSfzgd(original.getSfzgd());
        split.setJszq(original.getJszq());

        split.setQsds(newQsds);
        split.setJzds(original.getJzds());
        double dd = original.getJzds() - newQsds;
        split.setDd(dd);

        double originalDd = original.getDd() != null ? original.getDd() : 1.0;
        double originalYjsje = original.getYjsje() != null ? original.getYjsje() : 0.0;
        split.setYjsje(dd / originalDd * originalYjsje);

        return split;
    }

    private TempBeizhuData1 createTempBeizhuData1(BeizhuData src) {
        TempBeizhuData1 dest = new TempBeizhuData1();
        dest.setFtcs(src.getFtcs());
        dest.setQy(src.getQy());
        dest.setZdmc(src.getZdmc());
        dest.setTtzdbm(src.getTtzdbm());
        dest.setHh(src.getHh());
        dest.setDb(src.getDb());
        dest.setQd(src.getQd());
        dest.setZd(src.getZd());
        dest.setKssj(src.getKssj());
        dest.setJssj(src.getJssj());
        dest.setZfsj(src.getZfsj());
        dest.setZfdl(src.getZfdl());
        dest.setYdje(src.getYdje());
        dest.setGdfs(src.getGdfs());
        dest.setYsdf(src.getYsdf());
        dest.setFtbl(src.getFtbl());
        dest.setFtje(src.getFtje());
        dest.setBz(src.getBz());
        return dest;
    }

    private TempBeizhuData2 createTempBeizhuData2(BeizhuData src) {
        TempBeizhuData2 dest = new TempBeizhuData2();
        dest.setFtcs(src.getFtcs());
        dest.setQy(src.getQy());
        dest.setZdmc(src.getZdmc());
        dest.setTtzdbm(src.getTtzdbm());
        dest.setHh(src.getHh());
        dest.setDb(src.getDb());
        dest.setQd(src.getQd());
        dest.setZd(src.getZd());
        dest.setKssj(src.getKssj());
        dest.setJssj(src.getJssj());
        dest.setZfsj(src.getZfsj());
        dest.setZfdl(src.getZfdl());
        dest.setYdje(src.getYdje());
        dest.setGdfs(src.getGdfs());
        dest.setYsdf(src.getYsdf());
        dest.setFtbl(src.getFtbl());
        dest.setFtje(src.getFtje());
        dest.setBz(src.getBz());
        return dest;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据处理完成，总计: {} 条", beizhuDataList.size());
        log.info("已收: {} 条", yishoulist.size());
        log.info("未收: {} 条", weishoulist.size());
        log.info("预收: {} 条", yushoulist.size());
    }

    public BeizhuStats getBeizhuStats() {
        return new BeizhuStats(this.beizhuDataList);
    }

    public List<BeizhuData> getBeizhuDataList() {
        return this.beizhuDataList;
    }

    public List<HuikuanData> getHuikuanDataList() {
        return this.huikuanDataList;
    }

    public List<TempBeizhuData1> getYishoulist() {
        return this.yishoulist;
    }

    public List<TempBeizhuData2> getWeishoulist() {
        return this.weishoulist;
    }

    public List<HuikuanData> getYushoulist() {
        return this.yushoulist;
    }

    public List<HuikuanData> getYiweishoulist() {
        return this.yiweishoulist;
    }
}
