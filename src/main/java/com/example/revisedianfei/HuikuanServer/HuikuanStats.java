package com.example.revisedianfei.HuikuanServer;

import java.util.List;

public class HuikuanStats {
    private List<HuikuanData> huikuanDataList;

    public HuikuanStats(List<HuikuanData> huikuanDataList) {
        this.huikuanDataList = huikuanDataList;
    }

    public List<HuikuanData> getHuikuanDataList() {
        return this.huikuanDataList;
    }

    public void setHuikuanDataList(final List<HuikuanData> huikuanDataList) {
        this.huikuanDataList = huikuanDataList;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HuikuanStats)) {
            return false;
        } else {
            HuikuanStats other = (HuikuanStats)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$huikuanDataList = this.getHuikuanDataList();
                Object other$huikuanDataList = other.getHuikuanDataList();
                if (this$huikuanDataList == null) {
                    if (other$huikuanDataList != null) {
                        return false;
                    }
                } else if (!this$huikuanDataList.equals(other$huikuanDataList)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HuikuanStats;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $huikuanDataList = this.getHuikuanDataList();
        result = result * 59 + ($huikuanDataList == null ? 43 : $huikuanDataList.hashCode());
        return result;
    }

    public String toString() {
        return "HuikuanStats(huikuanDataList=" + this.getHuikuanDataList() + ")";
    }
}
