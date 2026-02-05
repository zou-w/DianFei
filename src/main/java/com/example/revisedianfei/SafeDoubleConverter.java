package com.example.revisedianfei;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * 智能Double转换器 - 最终修复版
 *
 * 核心逻辑：
 * 1. null/空值 → 0.0（避免NullPointerException）
 * 2. 百分比：50% → 0.5, 100% → 1.0
 * 3. 小数比例：0.5 → 0.5（直接使用）
 * 4. 普通数字：100.5 → 100.5
 * 5. 千分位：1,000.5 → 1000.5
 * 6. 占位符：- — / N/A 无 → 0.0
 * 7. 转换失败 → 0.0（兜底处理）
 *
 * 关键改进：所有异常情况都返回0.0，让业务逻辑处理
 */
public class SafeDoubleConverter implements Converter<Double> {

    @Override
    public Class<Double> supportJavaTypeKey() {
        return Double.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        // 支持所有类型的单元格数据，包括STRING、NUMERIC等
        return null;
    }

    @Override
    public Double convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) {
        try {
            // 根据单元格数据类型进行处理
            switch (cellData.getType()) {
                case STRING:
                    // 处理字符串类型数据
                    String stringValue = cellData.getStringValue();
                    return handleStringValue(stringValue);
                case NUMBER:
                    // 处理数字类型数据
                    if (cellData.getNumberValue() != null) {
                        return cellData.getNumberValue().doubleValue();
                    }
                    return 0.0;
                case BOOLEAN:
                    // 布尔类型转换为数字
                    return cellData.getBooleanValue() ? 1.0 : 0.0;
                case ERROR:
                    // 空白或错误单元格返回0.0
                    return 0.0;
                default:
                    // 其他类型尝试转换
                    Object data = cellData.getData();
                    if (data != null) {
                        if (data instanceof Number) {
                            return ((Number)data).doubleValue();
                        } else {
                            return handleStringValue(data.toString());
                        }
                    }
                    return 0.0;
            }
        } catch (Exception e) {
            // 转换失败时返回0.0作为默认值（避免数据丢失）
            System.err.println("[SafeDoubleConverter] 数据转换失败，使用默认值0.0: 原始值=" + cellData + ", 错误=" + e.getMessage());
            return 0.0;
        }
    }

    /**
     * 处理字符串类型的值
     */
    private Double handleStringValue(String stringValue) {
        if (stringValue == null) {
            return 0.0;
        }

        stringValue = stringValue.trim();

        // 如果字符串为空，返回0.0
        if (stringValue.isEmpty()) {
            return 0.0;
        }

        // 处理占位符：横线、斜杠等 → 0.0
        if ("-".equals(stringValue) || "—".equals(stringValue) || "/".equals(stringValue)
                || "N/A".equalsIgnoreCase(stringValue) || "无".equals(stringValue)) {
            return 0.0;
        }

        // 移除千分位逗号（包括中英文）
        stringValue = stringValue.replace(",", "");
        stringValue = stringValue.replace("，", "");

        // 处理百分号：50% → 0.5, 100% → 1.0
        if (stringValue.endsWith("%")) {
            stringValue = stringValue.replace("%", "");
            try {
                double value = Double.parseDouble(stringValue);
                return value / 100.0;
            } catch (Exception e) {
                return 0.0;
            }
        }

        // 移除货币符号（保留数字、小数点、负号）
        stringValue = stringValue.replaceAll("[^\\d.\\-]", "");

        // 检查是否为空字符串
        if (stringValue.isEmpty()) {
            return 0.0;
        }

        // 处理多个小数点的情况（取第一个）
        int dotIndex = stringValue.indexOf(".");
        if (dotIndex != -1 && stringValue.lastIndexOf(".") != dotIndex) {
            stringValue = stringValue.substring(0, dotIndex) + stringValue.substring(dotIndex).replace(".", "");
        }

        // 转换为Double
        try {
            return Double.parseDouble(stringValue);
        } catch (Exception e) {
            return 0.0;
        }
    }

    @Override
    public WriteCellData<String> convertToExcelData(Double value, ExcelContentProperty contentProperty,
                                                    GlobalConfiguration globalConfiguration) {
        // 写入时，null转换为空字符串，保留2位小数
        if (value == null) {
            return new WriteCellData<>("");
        }
        return new WriteCellData<>(String.format("%.2f", value));
    }
}
