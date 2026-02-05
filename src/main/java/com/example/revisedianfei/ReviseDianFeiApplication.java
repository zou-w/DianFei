package com.example.revisedianfei;

import com.example.revisedianfei.BeizhuServer.BeizhuData;
import com.example.revisedianfei.BeizhuServer.BeizhuService;
import com.example.revisedianfei.HuikuanServer.HuikuanData;
import com.example.revisedianfei.HuikuanServer.HuikuanService;
import com.example.revisedianfei.ZhifuServer.ZhifuService;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviseDianFeiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviseDianFeiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ZhifuService zhifuService, HuikuanService huikuanService, BeizhuService beizhuService) {
        return (args) -> {
            System.out.println("开始处理数据...");
            
            // 步骤1：生成需输入的电费支付数据格式文件
            List<BeizhuData> beizhuDataList = zhifuService.neededBeizhuData().getBeizhuDataList();
            System.out.println("支付数据格式生成成功！");
            System.out.println("生成的支付数据条数：" + beizhuDataList.size());
            
            // 步骤2：读取回款数据
            List<HuikuanData> huikuanDataList = huikuanService.neededHuikuanData().getHuikuanDataList();
            System.out.println("回款数据读取成功！");
            System.out.println("读取的回款数据条数：" + huikuanDataList.size());
            
            // 步骤3：直接使用内存中的数据生成最终文件（无需手动填写）
            List<BeizhuData> finalDataList = beizhuService.finalData(huikuanDataList).getBeizhuDataList();
            System.out.println("最终文件生成成功！");
            System.out.println("处理完成！");
            System.out.println("\n生成的文件：");
            System.out.println("1. data/需输入的电费支付数据格式.xlsx - 可用于检查错误");
            System.out.println("2. data/电费备注数据输出.xlsx - 最终结果文件");
        };
    }
}
