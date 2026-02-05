package com.example.revisedianfei.BeizhuServer;

import java.util.List;

public class BeizhuStats {
    private List<BeizhuData> beizhuDataList;

    public BeizhuStats(List<BeizhuData> beizhuDataList) {
        this.beizhuDataList = beizhuDataList;
    }

    public List<BeizhuData> getBeizhuDataList() {
        return this.beizhuDataList;
    }

    public void setBeizhuDataList(final List<BeizhuData> beizhuDataList) {
        this.beizhuDataList = beizhuDataList;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BeizhuStats)) {
            return false;
        } else {
            BeizhuStats other = (BeizhuStats)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$beizhuDataList = this.getBeizhuDataList();
                Object other$beizhuDataList = other.getBeizhuDataList();
                if (this$beizhuDataList == null) {
                    if (other$beizhuDataList != null) {
                        return false;
                    }
                } else if (!this$beizhuDataList.equals(other$beizhuDataList)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BeizhuStats;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $beizhuDataList = this.getBeizhuDataList();
        result = result * 59 + ($beizhuDataList == null ? 43 : $beizhuDataList.hashCode());
        return result;
    }

    public String toString() {
        return "BeizhuStats(beizhuDataList=" + this.getBeizhuDataList() + ")";
    }
}
