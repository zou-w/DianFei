package com.example.revisedianfei.BeizhuServer;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.revisedianfei.HuikuanServer.HuikuanData;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BeizhuService {
    private static String Excel_Path = "data/电费备注数据输入.xlsx";
    private static String excelFilePath = "data/电费备注数据输出.xlsx";

    public BeizhuStats finalData(List<HuikuanData> huikuanDataList) {
        BeizhuListener beizhuListener = new BeizhuListener(huikuanDataList);
        ((ExcelReaderSheetBuilder)EasyExcel.read(Excel_Path, BeizhuData.class, beizhuListener).sheet("支付备注数据").headRowNumber(1)).doRead();
        ExcelWriter excelWriter = EasyExcel.write(excelFilePath).build();

        try {
            WriteSheet writeSheet1 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(0, "支付备注数据").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getBeizhuStats().getBeizhuDataList(), writeSheet1);
            WriteSheet writeSheet2 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(1, "回款备注数据").head(HuikuanData.class)).build();
            excelWriter.write(beizhuListener.getHuikuanDataList(), writeSheet2);
            WriteSheet writeSheet3 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(2, "已收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getYishoulist(), writeSheet3);
            WriteSheet writeSheet4 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(3, "未收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getWeishoulist(), writeSheet4);
            WriteSheet writeSheet5 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(4, "预收").head(HuikuanData.class)).build();
            excelWriter.write(beizhuListener.getYushoulist(), writeSheet5);
        } catch (Throwable var10) {
            if (excelWriter != null) {
                try {
                    excelWriter.close();
                } catch (Throwable var9) {
                    var10.addSuppressed(var9);
                }
            }

            throw var10;
        }

        if (excelWriter != null) {
            excelWriter.close();
        }

        return beizhuListener.getBeizhuStats();
    }
}
