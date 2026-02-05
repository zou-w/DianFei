package com.example.revisedianfei.ZhifuServer;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.revisedianfei.BeizhuServer.BeizhuData;
import com.example.revisedianfei.BeizhuServer.BeizhuStats;
import org.springframework.stereotype.Service;

@Service
public class ZhifuService {
    private static String Excel_Path = "data/电费支付.xlsx";
    private static String excelFilePath = "data/需输入的电费支付数据格式.xlsx";

    public BeizhuStats neededBeizhuData() {
        System.out.println("开始处理支付数据...");
        System.out.println("读取文件: " + Excel_Path);
        
        ZhifuListener dianfeiDataListener = new ZhifuListener();
        
        try {
            ((ExcelReaderSheetBuilder)EasyExcel.read(Excel_Path, ZhifuData.class, dianfeiDataListener).sheet("支付").headRowNumber(2)).doRead();
        } catch (Exception e) {
            System.err.println("读取Excel文件失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        int dataCount = dianfeiDataListener.getBeizhuDatalist().size();
        System.out.println("处理完成，共生成 " + dataCount + " 条数据");
        
        ExcelWriter excelWriter = EasyExcel.write(excelFilePath).build();

        try {
            WriteSheet writeSheet = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(0, "电费支付数据格式").head(BeizhuData.class)).build();
            excelWriter.write(dianfeiDataListener.getBeizhuStats().getBeizhuDataList(), writeSheet);
            System.out.println("数据写入成功: " + excelFilePath);
        } catch (Throwable var6) {
            System.err.println("写入Excel文件失败: " + var6.getMessage());
            var6.printStackTrace();
            if (excelWriter != null) {
                try {
                    excelWriter.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }
            }

            throw var6;
        } finally {
            if (excelWriter != null) {
                excelWriter.close();
            }
        }

        return dianfeiDataListener.getBeizhuStats();
    }
}
