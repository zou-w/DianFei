package com.example.revisedianfei.ZhifuServer;

import com.alibaba.excel.annotation.ExcelProperty;

public class ZhifuData {
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
    @ExcelProperty({"移动比例"})
    private Double ydbl;
    @ExcelProperty({"联通比例"})
    private Double ltbl;
    @ExcelProperty({"电信比例"})
    private Double dxbl;
    @ExcelProperty({"拓展"})
    private Double tz;
    @ExcelProperty({"能源"})
    private Double ny;
    @ExcelProperty({"微站"})
    private Double wz;

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

    public Double getYdbl() {
        return this.ydbl;
    }

    public Double getLtbl() {
        return this.ltbl;
    }

    public Double getDxbl() {
        return this.dxbl;
    }

    public Double getTz() {
        return this.tz;
    }

    public Double getNy() {
        return this.ny;
    }

    public Double getWz() {
        return this.wz;
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

    public void setYdbl(final Double ydbl) {
        this.ydbl = ydbl;
    }

    public void setLtbl(final Double ltbl) {
        this.ltbl = ltbl;
    }

    public void setDxbl(final Double dxbl) {
        this.dxbl = dxbl;
    }

    public void setTz(final Double tz) {
        this.tz = tz;
    }

    public void setNy(final Double ny) {
        this.ny = ny;
    }

    public void setWz(final Double wz) {
        this.wz = wz;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ZhifuData)) {
            return false;
        } else {
            ZhifuData other = (ZhifuData)o;
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

                Object this$ydbl = this.getYdbl();
                Object other$ydbl = other.getYdbl();
                if (this$ydbl == null) {
                    if (other$ydbl != null) {
                        return false;
                    }
                } else if (!this$ydbl.equals(other$ydbl)) {
                    return false;
                }

                Object this$ltbl = this.getLtbl();
                Object other$ltbl = other.getLtbl();
                if (this$ltbl == null) {
                    if (other$ltbl != null) {
                        return false;
                    }
                } else if (!this$ltbl.equals(other$ltbl)) {
                    return false;
                }

                Object this$dxbl = this.getDxbl();
                Object other$dxbl = other.getDxbl();
                if (this$dxbl == null) {
                    if (other$dxbl != null) {
                        return false;
                    }
                } else if (!this$dxbl.equals(other$dxbl)) {
                    return false;
                }

                Object this$tz = this.getTz();
                Object other$tz = other.getTz();
                if (this$tz == null) {
                    if (other$tz != null) {
                        return false;
                    }
                } else if (!this$tz.equals(other$tz)) {
                    return false;
                }

                Object this$ny = this.getNy();
                Object other$ny = other.getNy();
                if (this$ny == null) {
                    if (other$ny != null) {
                        return false;
                    }
                } else if (!this$ny.equals(other$ny)) {
                    return false;
                }

                Object this$wz = this.getWz();
                Object other$wz = other.getWz();
                if (this$wz == null) {
                    if (other$wz != null) {
                        return false;
                    }
                } else if (!this$wz.equals(other$wz)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ZhifuData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
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
        Object $ydbl = this.getYdbl();
        result = result * 59 + ($ydbl == null ? 43 : $ydbl.hashCode());
        Object $ltbl = this.getLtbl();
        result = result * 59 + ($ltbl == null ? 43 : $ltbl.hashCode());
        Object $dxbl = this.getDxbl();
        result = result * 59 + ($dxbl == null ? 43 : $dxbl.hashCode());
        Object $tz = this.getTz();
        result = result * 59 + ($tz == null ? 43 : $tz.hashCode());
        Object $ny = this.getNy();
        result = result * 59 + ($ny == null ? 43 : $ny.hashCode());
        Object $wz = this.getWz();
        result = result * 59 + ($wz == null ? 43 : $wz.hashCode());
        return result;
    }

    public String toString() {
        return "ZhifuData(qy=" + this.getQy() + ", zdmc=" + this.getZdmc() + ", ttzdbm=" + this.getTtzdbm() + ", hh=" + this.getHh() + ", db=" + this.getDb() + ", qd=" + this.getQd() + ", zd=" + this.getZd() + ", kssj=" + this.getKssj() + ", jssj=" + this.getJssj() + ", zfsj=" + this.getZfsj() + ", zfdl=" + this.getZfdl() + ", ydje=" + this.getYdje() + ", gdfs=" + this.getGdfs() + ", ysdf=" + this.getYsdf() + ", ydbl=" + this.getYdbl() + ", ltbl=" + this.getLtbl() + ", dxbl=" + this.getDxbl() + ", tz=" + this.getTz() + ", ny=" + this.getNy() + ", wz=" + this.getWz() + ")";
    }
}
