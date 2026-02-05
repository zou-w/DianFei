package com.example.revisedianfei.HuikuanServer;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HuikuanListener extends AnalysisEventListener<HuikuanData> {
    private static final Logger log = LoggerFactory.getLogger(HuikuanListener.class);
    private final List<HuikuanData> huikuanDataList = new ArrayList();

    public void invoke(HuikuanData huikuanData, AnalysisContext context) {
        this.huikuanDataList.add(huikuanData);
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    public HuikuanStats getHuikuanStats() {
        return new HuikuanStats(this.huikuanDataList);
    }

    public List<HuikuanData> getHuikuanDataList() {
        return this.huikuanDataList;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HuikuanListener)) {
            return false;
        } else {
            HuikuanListener other = (HuikuanListener)o;
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
        return other instanceof HuikuanListener;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $huikuanDataList = this.getHuikuanDataList();
        result = result * 59 + ($huikuanDataList == null ? 43 : $huikuanDataList.hashCode());
        return result;
    }

    public String toString() {
        return "HuikuanListener(huikuanDataList=" + this.getHuikuanDataList() + ")";
    }
}
