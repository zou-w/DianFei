package com.example.revisedianfei.HuikuanServer;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import org.springframework.stereotype.Service;

@Service
public class HuikuanService {
    private static String Excel_Path = "data/电费备注数据输入.xlsx";

    public HuikuanStats neededHuikuanData() {
        HuikuanListener huikuanListener = new HuikuanListener();
        ((ExcelReaderSheetBuilder)EasyExcel.read(Excel_Path, HuikuanData.class, huikuanListener).sheet("回款备注数据").headRowNumber(1)).doRead();
        return huikuanListener.getHuikuanStats();
    }
}
