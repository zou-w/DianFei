package com.example.revisedianfei.ZhifuServer;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.revisedianfei.BeizhuServer.BeizhuData;
import com.example.revisedianfei.BeizhuServer.BeizhuStats;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZhifuListener extends AnalysisEventListener<ZhifuData> {
    private static final Logger log = LoggerFactory.getLogger(ZhifuListener.class);
    private final List<BeizhuData> beizhuDatalist = new ArrayList();

    public void invoke(ZhifuData dianfeiData, AnalysisContext context) {
        boolean hasValidData = false;
        
        if (dianfeiData.getYdbl() != null && dianfeiData.getYdbl() != (double)0.0F) {
            this.beizhuDatalist.add(this.addBeizhuData("移动", dianfeiData.getYdbl(), (double)0.0F, dianfeiData));
            hasValidData = true;
        }

        if (dianfeiData.getDxbl() != null && dianfeiData.getDxbl() != (double)0.0F) {
            this.beizhuDatalist.add(this.addBeizhuData("电信", dianfeiData.getDxbl(), (double)0.0F, dianfeiData));
            hasValidData = true;
        }

        if (dianfeiData.getLtbl() != null && dianfeiData.getLtbl() != (double)0.0F) {
            this.beizhuDatalist.add(this.addBeizhuData("联通", dianfeiData.getLtbl(), (double)0.0F, dianfeiData));
            hasValidData = true;
        }

        // 如果所有比例都为0，添加一条"未知"厂商的记录，确保文件不为空
        if (!hasValidData) {
            this.beizhuDatalist.add(this.addBeizhuData("未知", 1.0, (double)0.0F, dianfeiData));
        }

        // 输出日志，便于调试
        log.info("处理数据: 移动比例={}, 电信比例={}, 联通比例={}", 
                 dianfeiData.getYdbl(), dianfeiData.getDxbl(), dianfeiData.getLtbl());
    }

    public BeizhuData addBeizhuData(String A, Double B, Double C, ZhifuData dianfeiData) {
        BeizhuData data = new BeizhuData();
        data.setFtcs(A);
        data.setQy(dianfeiData.getQy());
        data.setZdmc(dianfeiData.getZdmc());
        data.setTtzdbm(dianfeiData.getTtzdbm());
        data.setHh(dianfeiData.getHh());
        data.setDb(dianfeiData.getDb());
        data.setQd(dianfeiData.getQd());
        data.setZd(dianfeiData.getZd());
        data.setKssj(dianfeiData.getKssj());
        data.setJssj(dianfeiData.getJssj());
        data.setZfsj(dianfeiData.getZfsj());
        data.setZfdl(dianfeiData.getZfdl());
        data.setYdje(dianfeiData.getYdje());
        data.setGdfs(dianfeiData.getGdfs());
        data.setYsdf(dianfeiData.getYsdf());
        data.setFtbl(B);
        data.setFtje(Double.parseDouble(String.format("%.2f", dianfeiData.getYsdf() * B)));
        data.setBz((String)null);
        return data;
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    public BeizhuStats getBeizhuStats() {
        return new BeizhuStats(this.beizhuDatalist);
    }

    public List<BeizhuData> getBeizhuDatalist() {
        return this.beizhuDatalist;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ZhifuListener)) {
            return false;
        } else {
            ZhifuListener other = (ZhifuListener)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$beizhuDatalist = this.getBeizhuDatalist();
                Object other$beizhuDatalist = other.getBeizhuDatalist();
                if (this$beizhuDatalist == null) {
                    if (other$beizhuDatalist != null) {
                        return false;
                    }
                } else if (!this$beizhuDatalist.equals(other$beizhuDatalist)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ZhifuListener;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $beizhuDatalist = this.getBeizhuDatalist();
        result = result * 59 + ($beizhuDatalist == null ? 43 : $beizhuDatalist.hashCode());
        return result;
    }

    public String toString() {
        return "ZhifuListener(beizhuDatalist=" + this.getBeizhuDatalist() + ")";
    }
}
