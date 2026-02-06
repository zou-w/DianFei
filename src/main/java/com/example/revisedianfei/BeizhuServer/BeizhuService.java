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
        // 从Excel文件读取数据（保持原有功能）
        return processDataFromExcel(huikuanDataList);
    }

    /**
     * 直接处理内存中的BeizhuData列表
     * 用于跳过Excel文件读取，直接处理ZhifuService生成的数据
     */
    public BeizhuStats finalDataFromMemory(List<HuikuanData> huikuanDataList, List<BeizhuData> beizhuDataList) {
        BeizhuListener beizhuListener = new BeizhuListener(huikuanDataList);

        // 直接处理内存中的数据，跳过Excel文件读取
        // 使用数据的副本进行处理，保持原始数据不变
        for (BeizhuData originalData : beizhuDataList) {
            // 创建数据的副本
            BeizhuData copyData = createBeizhuDataCopy(originalData);
            beizhuListener.invoke(copyData, null);
        }

        // 生成最终文件，传入原始数据列表，确保"支付备注数据"表使用原始数据
        generateOutputFileWithOriginalData(beizhuListener, beizhuDataList);

        return beizhuListener.getBeizhuStats();
    }

    /**
     * 创建BeizhuData的副本
     */
    private BeizhuData createBeizhuDataCopy(BeizhuData original) {
        BeizhuData copy = new BeizhuData();
        copy.setFtcs(original.getFtcs());
        copy.setQy(original.getQy());
        copy.setZdmc(original.getZdmc());
        copy.setTtzdbm(original.getTtzdbm());
        copy.setHh(original.getHh());
        copy.setDb(original.getDb());
        copy.setQd(original.getQd());
        copy.setZd(original.getZd());
        copy.setKssj(original.getKssj());
        copy.setJssj(original.getJssj());
        copy.setZfsj(original.getZfsj());
        copy.setZfdl(original.getZfdl());
        copy.setYdje(original.getYdje());
        copy.setGdfs(original.getGdfs());
        copy.setYsdf(original.getYsdf());
        copy.setFtbl(original.getFtbl());
        copy.setFtje(original.getFtje());
        copy.setBz(original.getBz());
        return copy;
    }

    /**
     * 从Excel文件读取数据并处理
     */
    private BeizhuStats processDataFromExcel(List<HuikuanData> huikuanDataList) {
        BeizhuListener beizhuListener = new BeizhuListener(huikuanDataList);
        ((ExcelReaderSheetBuilder)EasyExcel.read(Excel_Path, BeizhuData.class, beizhuListener).sheet("支付备注数据").headRowNumber(1)).doRead();

        // 生成最终文件
        generateOutputFile(beizhuListener);

        return beizhuListener.getBeizhuStats();
    }

    /**
     * 生成输出文件
     */
    private void generateOutputFile(BeizhuListener beizhuListener) {
        ExcelWriter excelWriter = EasyExcel.write(excelFilePath).build();

        try {
            // 生成支付备注数据sheet，包含所有原始数据
            WriteSheet writeSheet1 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(0, "支付备注数据").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getBeizhuStats().getBeizhuDataList(), writeSheet1);
            
            // 生成回款备注数据sheet
            WriteSheet writeSheet2 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(1, "回款备注数据").head(HuikuanData.class)).build();
            excelWriter.write(beizhuListener.getHuikuanDataList(), writeSheet2);
            
            // 生成已收sheet
            WriteSheet writeSheet3 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(2, "已收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getYishoulist(), writeSheet3);
            
            // 生成未收sheet
            WriteSheet writeSheet4 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(3, "未收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getWeishoulist(), writeSheet4);
            
            // 生成预收sheet
            WriteSheet writeSheet5 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(4, "预收").head(HuikuanData.class)).build();
            excelWriter.write(beizhuListener.getYushoulist(), writeSheet5);
        } catch (Throwable var9) {
            if (excelWriter != null) {
                try {
                    excelWriter.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }
            }

            throw var9;
        } finally {
            if (excelWriter != null) {
                excelWriter.close();
            }
        }
    }

    /**
     * 生成输出文件，使用原始数据生成"支付备注数据"表
     */
    private void generateOutputFileWithOriginalData(BeizhuListener beizhuListener, List<BeizhuData> originalBeizhuDataList) {
        ExcelWriter excelWriter = EasyExcel.write(excelFilePath).build();

        try {
            // 生成支付备注数据sheet，使用原始数据，确保与"需输入的电费支付数据格式"中的数据一致
            WriteSheet writeSheet1 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(0, "支付备注数据").head(BeizhuData.class)).build();
            excelWriter.write(originalBeizhuDataList, writeSheet1);
            
            // 生成回款备注数据sheet
            WriteSheet writeSheet2 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(1, "回款备注数据").head(HuikuanData.class)).build();
            excelWriter.write(beizhuListener.getHuikuanDataList(), writeSheet2);
            
            // 生成已收sheet
            WriteSheet writeSheet3 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(2, "已收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getYishoulist(), writeSheet3);
            
            // 生成未收sheet
            WriteSheet writeSheet4 = ((ExcelWriterSheetBuilder)EasyExcel.writerSheet(3, "未收").head(BeizhuData.class)).build();
            excelWriter.write(beizhuListener.getWeishoulist(), writeSheet4);
            
            // 生成预收sheet
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
        } finally {
            if (excelWriter != null) {
                excelWriter.close();
            }
        }
    }
}
