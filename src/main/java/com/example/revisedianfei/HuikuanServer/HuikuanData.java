package com.example.revisedianfei.HuikuanServer;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.revisedianfei.SafeDoubleConverter;

public class HuikuanData {
    @ExcelProperty({"区县"})
    private String qy;
    @ExcelProperty({"运营商"})
    private String yys;
    @ExcelProperty({"站点名称（铁塔）"})
    private String zdmc;
    @ExcelProperty({"站址编码"})
    private String zzbm;
    @ExcelProperty({"户号"})
    private String hh;
    @ExcelProperty({"电表"})
    private String db;
    @ExcelProperty(value = {"用电共享比例"}, converter = SafeDoubleConverter.class)
    private Double ydgxbl;
    @ExcelProperty({"用电共享情况"})
    private String ydgxqk;
    @ExcelProperty({"缴费开始时间"})
    private String jfkssj;
    @ExcelProperty({"缴费结束时间"})
    private String jfjssj;
    @ExcelProperty(value = {"支付总金额"}, converter = SafeDoubleConverter.class)
    private Double zfzje;
    @ExcelProperty(value = {"电度（所有缴费产生电度总数）\n保留1位小数，票据上的度数"}, converter = SafeDoubleConverter.class)
    private Double dd;
    @ExcelProperty(value = {"电损（电量）"}, converter = SafeDoubleConverter.class)
    private Double ds;
    @ExcelProperty(value = {"起始度数\n保留1位小数"}, converter = SafeDoubleConverter.class)
    private Double qsds;
    @ExcelProperty(value = {"截止度数\n保留1位小数"}, converter = SafeDoubleConverter.class)
    private Double jzds;
    @ExcelProperty(value = {"应结算金额\n（价税合计开票金额）\n（公式计算）"}, converter = SafeDoubleConverter.class)
    private Double yjsje;
    @ExcelProperty({"是否直供电（下拉选择）"})
    private String sfzgd;
    @ExcelProperty({"结算账期"})
    private String jszq;

    public String getQy() {
        return this.qy;
    }

    public String getYys() {
        return this.yys;
    }

    public String getZdmc() {
        return this.zdmc;
    }

    public String getZzbm() {
        return this.zzbm;
    }

    public String getHh() {
        return this.hh;
    }

    public String getDb() {
        return this.db;
    }

    public Double getYdgxbl() {
        return this.ydgxbl;
    }

    public String getYdgxqk() {
        return this.ydgxqk;
    }

    public String getJfkssj() {
        return this.jfkssj;
    }

    public String getJfjssj() {
        return this.jfjssj;
    }

    public Double getZfzje() {
        return this.zfzje;
    }

    public Double getDd() {
        return this.dd;
    }

    public Double getDs() {
        return this.ds;
    }

    public Double getQsds() {
        return this.qsds;
    }

    public Double getJzds() {
        return this.jzds;
    }

    public Double getYjsje() {
        return this.yjsje;
    }

    public String getSfzgd() {
        return this.sfzgd;
    }

    public String getJszq() {
        return this.jszq;
    }

    public void setQy(final String qy) {
        this.qy = qy;
    }

    public void setYys(final String yys) {
        this.yys = yys;
    }

    public void setZdmc(final String zdmc) {
        this.zdmc = zdmc;
    }

    public void setZzbm(final String zzbm) {
        this.zzbm = zzbm;
    }

    public void setHh(final String hh) {
        this.hh = hh;
    }

    public void setDb(final String db) {
        this.db = db;
    }

    public void setYdgxbl(final Double ydgxbl) {
        this.ydgxbl = ydgxbl;
    }

    public void setYdgxqk(final String ydgxqk) {
        this.ydgxqk = ydgxqk;
    }

    public void setJfkssj(final String jfkssj) {
        this.jfkssj = jfkssj;
    }

    public void setJfjssj(final String jfjssj) {
        this.jfjssj = jfjssj;
    }

    public void setZfzje(final Double zfzje) {
        this.zfzje = zfzje;
    }

    public void setDd(final Double dd) {
        this.dd = dd;
    }

    public void setDs(final Double ds) {
        this.ds = ds;
    }

    public void setQsds(final Double qsds) {
        this.qsds = qsds;
    }

    public void setJzds(final Double jzds) {
        this.jzds = jzds;
    }

    public void setYjsje(final Double yjsje) {
        this.yjsje = yjsje;
    }

    public void setSfzgd(final String sfzgd) {
        this.sfzgd = sfzgd;
    }

    public void setJszq(final String jszq) {
        this.jszq = jszq;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HuikuanData)) {
            return false;
        } else {
            HuikuanData other = (HuikuanData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$qy = this.getQy();
                Object other$qy = other.getQy();
                if (this$qy == null) {
                    if (other$qy != null) {
                        return false;
                    }
                } else if (!this$qy.equals(other$qy)) {
                    return false;
                }

                Object this$yys = this.getYys();
                Object other$yys = other.getYys();
                if (this$yys == null) {
                    if (other$yys != null) {
                        return false;
                    }
                } else if (!this$yys.equals(other$yys)) {
                    return false;
                }

                Object this$zdmc = this.getZdmc();
                Object other$zdmc = other.getZdmc();
                if (this$zdmc == null) {
                    if (other$zdmc != null) {
                        return false;
                    }
                } else if (!this$zdmc.equals(other$zdmc)) {
                    return false;
                }

                Object this$zzbm = this.getZzbm();
                Object other$zzbm = other.getZzbm();
                if (this$zzbm == null) {
                    if (other$zzbm != null) {
                        return false;
                    }
                } else if (!this$zzbm.equals(other$zzbm)) {
                    return false;
                }

                Object this$hh = this.getHh();
                Object other$hh = other.getHh();
                if (this$hh == null) {
                    if (other$hh != null) {
                        return false;
                    }
                } else if (!this$hh.equals(other$hh)) {
                    return false;
                }

                Object this$db = this.getDb();
                Object other$db = other.getDb();
                if (this$db == null) {
                    if (other$db != null) {
                        return false;
                    }
                } else if (!this$db.equals(other$db)) {
                    return false;
                }

                Object this$ydgxbl = this.getYdgxbl();
                Object other$ydgxbl = other.getYdgxbl();
                if (this$ydgxbl == null) {
                    if (other$ydgxbl != null) {
                        return false;
                    }
                } else if (!this$ydgxbl.equals(other$ydgxbl)) {
                    return false;
                }

                Object this$ydgxqk = this.getYdgxqk();
                Object other$ydgxqk = other.getYdgxqk();
                if (this$ydgxqk == null) {
                    if (other$ydgxqk != null) {
                        return false;
                    }
                } else if (!this$ydgxqk.equals(other$ydgxqk)) {
                    return false;
                }

                Object this$jfkssj = this.getJfkssj();
                Object other$jfkssj = other.getJfkssj();
                if (this$jfkssj == null) {
                    if (other$jfkssj != null) {
                        return false;
                    }
                } else if (!this$jfkssj.equals(other$jfkssj)) {
                    return false;
                }

                Object this$jfjssj = this.getJfjssj();
                Object other$jfjssj = other.getJfjssj();
                if (this$jfjssj == null) {
                    if (other$jfjssj != null) {
                        return false;
                    }
                } else if (!this$jfjssj.equals(other$jfjssj)) {
                    return false;
                }

                Object this$zfzje = this.getZfzje();
                Object other$zfzje = other.getZfzje();
                if (this$zfzje == null) {
                    if (other$zfzje != null) {
                        return false;
                    }
                } else if (!this$zfzje.equals(other$zfzje)) {
                    return false;
                }

                Object this$dd = this.getDd();
                Object other$dd = other.getDd();
                if (this$dd == null) {
                    if (other$dd != null) {
                        return false;
                    }
                } else if (!this$dd.equals(other$dd)) {
                    return false;
                }

                Object this$ds = this.getDs();
                Object other$ds = other.getDs();
                if (this$ds == null) {
                    if (other$ds != null) {
                        return false;
                    }
                } else if (!this$ds.equals(other$ds)) {
                    return false;
                }

                Object this$qsds = this.getQsds();
                Object other$qsds = other.getQsds();
                if (this$qsds == null) {
                    if (other$qsds != null) {
                        return false;
                    }
                } else if (!this$qsds.equals(other$qsds)) {
                    return false;
                }

                Object this$jzds = this.getJzds();
                Object other$jzds = other.getJzds();
                if (this$jzds == null) {
                    if (other$jzds != null) {
                        return false;
                    }
                } else if (!this$jzds.equals(other$jzds)) {
                    return false;
                }

                Object this$yjsje = this.getYjsje();
                Object other$yjsje = other.getYjsje();
                if (this$yjsje == null) {
                    if (other$yjsje != null) {
                        return false;
                    }
                } else if (!this$yjsje.equals(other$yjsje)) {
                    return false;
                }

                Object this$sfzgd = this.getSfzgd();
                Object other$sfzgd = other.getSfzgd();
                if (this$sfzgd == null) {
                    if (other$sfzgd != null) {
                        return false;
                    }
                } else if (!this$sfzgd.equals(other$sfzgd)) {
                    return false;
                }

                Object this$jszq = this.getJszq();
                Object other$jszq = other.getJszq();
                if (this$jszq == null) {
                    if (other$jszq != null) {
                        return false;
                    }
                } else if (!this$jszq.equals(other$jszq)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HuikuanData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $qy = this.getQy();
        result = result * 59 + ($qy == null ? 43 : $qy.hashCode());
        Object $yys = this.getYys();
        result = result * 59 + ($yys == null ? 43 : $yys.hashCode());
        Object $zdmc = this.getZdmc();
        result = result * 59 + ($zdmc == null ? 43 : $zdmc.hashCode());
        Object $zzbm = this.getZzbm();
        result = result * 59 + ($zzbm == null ? 43 : $zzbm.hashCode());
        Object $hh = this.getHh();
        result = result * 59 + ($hh == null ? 43 : $hh.hashCode());
        Object $db = this.getDb();
        result = result * 59 + ($db == null ? 43 : $db.hashCode());
        Object $ydgxbl = this.getYdgxbl();
        result = result * 59 + ($ydgxbl == null ? 43 : $ydgxbl.hashCode());
        Object $ydgxqk = this.getYdgxqk();
        result = result * 59 + ($ydgxqk == null ? 43 : $ydgxqk.hashCode());
        Object $jfkssj = this.getJfkssj();
        result = result * 59 + ($jfkssj == null ? 43 : $jfkssj.hashCode());
        Object $jfjssj = this.getJfjssj();
        result = result * 59 + ($jfjssj == null ? 43 : $jfjssj.hashCode());
        Object $zfzje = this.getZfzje();
        result = result * 59 + ($zfzje == null ? 43 : $zfzje.hashCode());
        Object $dd = this.getDd();
        result = result * 59 + ($dd == null ? 43 : $dd.hashCode());
        Object $ds = this.getDs();
        result = result * 59 + ($ds == null ? 43 : $ds.hashCode());
        Object $qsds = this.getQsds();
        result = result * 59 + ($qsds == null ? 43 : $qsds.hashCode());
        Object $jzds = this.getJzds();
        result = result * 59 + ($jzds == null ? 43 : $jzds.hashCode());
        Object $yjsje = this.getYjsje();
        result = result * 59 + ($yjsje == null ? 43 : $yjsje.hashCode());
        Object $sfzgd = this.getSfzgd();
        result = result * 59 + ($sfzgd == null ? 43 : $sfzgd.hashCode());
        Object $jszq = this.getJszq();
        result = result * 59 + ($jszq == null ? 43 : $jszq.hashCode());
        return result;
    }

    public String toString() {
        return "HuikuanData(qy=" + this.getQy() + ", yys=" + this.getYys() + ", zdmc=" + this.getZdmc() + ", zzbm=" + this.getZzbm() + ", hh=" + this.getHh() + ", db=" + this.getDb() + ", ydgxbl=" + this.getYdgxbl() + ", ydgxqk=" + this.getYdgxqk() + ", jfkssj=" + this.getJfkssj() + ", jfjssj=" + this.getJfjssj() + ", zfzje=" + this.getZfzje() + ", dd=" + this.getDd() + ", ds=" + this.getDs() + ", qsds=" + this.getQsds() + ", jzds=" + this.getJzds() + ", yjsje=" + this.getYjsje() + ", sfzgd=" + this.getSfzgd() + ", jszq=" + this.getJszq() + ")";
    }
}
