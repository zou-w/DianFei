package com.example.revisedianfei.BeizhuServer;

import com.alibaba.excel.annotation.ExcelProperty;

public class TempBeizhuData1 {
    @ExcelProperty({"分摊厂商"})
    private String ftcs;
    @ExcelProperty({"区域"})
    private String qy;
    @ExcelProperty({"站点名称"})
    private String zdmc;
    @ExcelProperty({"铁塔站点编码"})
    private String ttzdbm;
    @ExcelProperty({"户号"})
    private String hh;
    @ExcelProperty({"电表"})
    private String db;
    @ExcelProperty({"起度"})
    private Double qd;
    @ExcelProperty({"止度"})
    private Double zd;
    @ExcelProperty({"开始时间"})
    private String kssj;
    @ExcelProperty({"结束时间"})
    private String jssj;
    @ExcelProperty({"支付时间"})
    private String zfsj;
    @ExcelProperty({"支付电量"})
    private Double zfdl;
    @ExcelProperty({"用电金额"})
    private Double ydje;
    @ExcelProperty({"供电方式"})
    private String gdfs;
    @ExcelProperty({"应收电费"})
    private Double ysdf;
    @ExcelProperty({"分摊比例"})
    private Double ftbl;
    @ExcelProperty({"分摊金额"})
    private Double ftje;
    @ExcelProperty({"备注"})
    private String bz;

    public String getFtcs() {
        return this.ftcs;
    }

    public String getQy() {
        return this.qy;
    }

    public String getZdmc() {
        return this.zdmc;
    }

    public String getTtzdbm() {
        return this.ttzdbm;
    }

    public String getHh() {
        return this.hh;
    }

    public String getDb() {
        return this.db;
    }

    public Double getQd() {
        return this.qd;
    }

    public Double getZd() {
        return this.zd;
    }

    public String getKssj() {
        return this.kssj;
    }

    public String getJssj() {
        return this.jssj;
    }

    public String getZfsj() {
        return this.zfsj;
    }

    public Double getZfdl() {
        return this.zfdl;
    }

    public Double getYdje() {
        return this.ydje;
    }

    public String getGdfs() {
        return this.gdfs;
    }

    public Double getYsdf() {
        return this.ysdf;
    }

    public Double getFtbl() {
        return this.ftbl;
    }

    public Double getFtje() {
        return this.ftje;
    }

    public String getBz() {
        return this.bz;
    }

    public void setFtcs(final String ftcs) {
        this.ftcs = ftcs;
    }

    public void setQy(final String qy) {
        this.qy = qy;
    }

    public void setZdmc(final String zdmc) {
        this.zdmc = zdmc;
    }

    public void setTtzdbm(final String ttzdbm) {
        this.ttzdbm = ttzdbm;
    }

    public void setHh(final String hh) {
        this.hh = hh;
    }

    public void setDb(final String db) {
        this.db = db;
    }

    public void setQd(final Double qd) {
        this.qd = qd;
    }

    public void setZd(final Double zd) {
        this.zd = zd;
    }

    public void setKssj(final String kssj) {
        this.kssj = kssj;
    }

    public void setJssj(final String jssj) {
        this.jssj = jssj;
    }

    public void setZfsj(final String zfsj) {
        this.zfsj = zfsj;
    }

    public void setZfdl(final Double zfdl) {
        this.zfdl = zfdl;
    }

    public void setYdje(final Double ydje) {
        this.ydje = ydje;
    }

    public void setGdfs(final String gdfs) {
        this.gdfs = gdfs;
    }

    public void setYsdf(final Double ysdf) {
        this.ysdf = ysdf;
    }

    public void setFtbl(final Double ftbl) {
        this.ftbl = ftbl;
    }

    public void setFtje(final Double ftje) {
        this.ftje = ftje;
    }

    public void setBz(final String bz) {
        this.bz = bz;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TempBeizhuData1)) {
            return false;
        } else {
            TempBeizhuData1 other = (TempBeizhuData1)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$ftcs = this.getFtcs();
                Object other$ftcs = other.getFtcs();
                if (this$ftcs == null) {
                    if (other$ftcs != null) {
                        return false;
                    }
                } else if (!this$ftcs.equals(other$ftcs)) {
                    return false;
                }

                Object this$qy = this.getQy();
                Object other$qy = other.getQy();
                if (this$qy == null) {
                    if (other$qy != null) {
                        return false;
                    }
                } else if (!this$qy.equals(other$qy)) {
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

                Object this$ttzdbm = this.getTtzdbm();
                Object other$ttzdbm = other.getTtzdbm();
                if (this$ttzdbm == null) {
                    if (other$ttzdbm != null) {
                        return false;
                    }
                } else if (!this$ttzdbm.equals(other$ttzdbm)) {
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

                Object this$qd = this.getQd();
                Object other$qd = other.getQd();
                if (this$qd == null) {
                    if (other$qd != null) {
                        return false;
                    }
                } else if (!this$qd.equals(other$qd)) {
                    return false;
                }

                Object this$zd = this.getZd();
                Object other$zd = other.getZd();
                if (this$zd == null) {
                    if (other$zd != null) {
                        return false;
                    }
                } else if (!this$zd.equals(other$zd)) {
                    return false;
                }

                Object this$kssj = this.getKssj();
                Object other$kssj = other.getKssj();
                if (this$kssj == null) {
                    if (other$kssj != null) {
                        return false;
                    }
                } else if (!this$kssj.equals(other$kssj)) {
                    return false;
                }

                Object this$jssj = this.getJssj();
                Object other$jssj = other.getJssj();
                if (this$jssj == null) {
                    if (other$jssj != null) {
                        return false;
                    }
                } else if (!this$jssj.equals(other$jssj)) {
                    return false;
                }

                Object this$zfsj = this.getZfsj();
                Object other$zfsj = other.getZfsj();
                if (this$zfsj == null) {
                    if (other$zfsj != null) {
                        return false;
                    }
                } else if (!this$zfsj.equals(other$zfsj)) {
                    return false;
                }

                Object this$zfdl = this.getZfdl();
                Object other$zfdl = other.getZfdl();
                if (this$zfdl == null) {
                    if (other$zfdl != null) {
                        return false;
                    }
                } else if (!this$zfdl.equals(other$zfdl)) {
                    return false;
                }

                Object this$ydje = this.getYdje();
                Object other$ydje = other.getYdje();
                if (this$ydje == null) {
                    if (other$ydje != null) {
                        return false;
                    }
                } else if (!this$ydje.equals(other$ydje)) {
                    return false;
                }

                Object this$gdfs = this.getGdfs();
                Object other$gdfs = other.getGdfs();
                if (this$gdfs == null) {
                    if (other$gdfs != null) {
                        return false;
                    }
                } else if (!this$gdfs.equals(other$gdfs)) {
                    return false;
                }

                Object this$ysdf = this.getYsdf();
                Object other$ysdf = other.getYsdf();
                if (this$ysdf == null) {
                    if (other$ysdf != null) {
                        return false;
                    }
                } else if (!this$ysdf.equals(other$ysdf)) {
                    return false;
                }

                Object this$ftbl = this.getFtbl();
                Object other$ftbl = other.getFtbl();
                if (this$ftbl == null) {
                    if (other$ftbl != null) {
                        return false;
                    }
                } else if (!this$ftbl.equals(other$ftbl)) {
                    return false;
                }

                Object this$ftje = this.getFtje();
                Object other$ftje = other.getFtje();
                if (this$ftje == null) {
                    if (other$ftje != null) {
                        return false;
                    }
                } else if (!this$ftje.equals(other$ftje)) {
                    return false;
                }

                Object this$bz = this.getBz();
                Object other$bz = other.getBz();
                if (this$bz == null) {
                    if (other$bz != null) {
                        return false;
                    }
                } else if (!this$bz.equals(other$bz)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TempBeizhuData1;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $ftcs = this.getFtcs();
        result = result * 59 + ($ftcs == null ? 43 : $ftcs.hashCode());
        Object $qy = this.getQy();
        result = result * 59 + ($qy == null ? 43 : $qy.hashCode());
        Object $zdmc = this.getZdmc();
        result = result * 59 + ($zdmc == null ? 43 : $zdmc.hashCode());
        Object $ttzdbm = this.getTtzdbm();
        result = result * 59 + ($ttzdbm == null ? 43 : $ttzdbm.hashCode());
        Object $hh = this.getHh();
        result = result * 59 + ($hh == null ? 43 : $hh.hashCode());
        Object $db = this.getDb();
        result = result * 59 + ($db == null ? 43 : $db.hashCode());
        Object $qd = this.getQd();
        result = result * 59 + ($qd == null ? 43 : $qd.hashCode());
        Object $zd = this.getZd();
        result = result * 59 + ($zd == null ? 43 : $zd.hashCode());
        Object $kssj = this.getKssj();
        result = result * 59 + ($kssj == null ? 43 : $kssj.hashCode());
        Object $jssj = this.getJssj();
        result = result * 59 + ($jssj == null ? 43 : $jssj.hashCode());
        Object $zfsj = this.getZfsj();
        result = result * 59 + ($zfsj == null ? 43 : $zfsj.hashCode());
        Object $zfdl = this.getZfdl();
        result = result * 59 + ($zfdl == null ? 43 : $zfdl.hashCode());
        Object $ydje = this.getYdje();
        result = result * 59 + ($ydje == null ? 43 : $ydje.hashCode());
        Object $gdfs = this.getGdfs();
        result = result * 59 + ($gdfs == null ? 43 : $gdfs.hashCode());
        Object $ysdf = this.getYsdf();
        result = result * 59 + ($ysdf == null ? 43 : $ysdf.hashCode());
        Object $ftbl = this.getFtbl();
        result = result * 59 + ($ftbl == null ? 43 : $ftbl.hashCode());
        Object $ftje = this.getFtje();
        result = result * 59 + ($ftje == null ? 43 : $ftje.hashCode());
        Object $bz = this.getBz();
        result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
        return result;
    }

    public String toString() {
        return "TempBeizhuData1(ftcs=" + this.getFtcs() + ", qy=" + this.getQy() + ", zdmc=" + this.getZdmc() + ", ttzdbm=" + this.getTtzdbm() + ", hh=" + this.getHh() + ", db=" + this.getDb() + ", qd=" + this.getQd() + ", zd=" + this.getZd() + ", kssj=" + this.getKssj() + ", jssj=" + this.getJssj() + ", zfsj=" + this.getZfsj() + ", zfdl=" + this.getZfdl() + ", ydje=" + this.getYdje() + ", gdfs=" + this.getGdfs() + ", ysdf=" + this.getYsdf() + ", ftbl=" + this.getFtbl() + ", ftje=" + this.getFtje() + ", bz=" + this.getBz() + ")";
    }
}
