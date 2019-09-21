package com.led.tools;

import com.led.enums.PromptEnum;

/**
 * 类型转换工具
 * @author likehao
 */
public class TypeConvert {

    /**
     * 字符串转换为整型
     * @param intString 整型字符串
     * @return 整型
     */
    public int convert2Int(String intString) {
        int convertInt = 0;
        try {
            if (intString != null && intString != "") {
                convertInt = Integer.valueOf(intString);
            }
        } catch (NumberFormatException e) {
            System.out.printf(PromptEnum.PLEASE_ENTER_CORRECT_NUMBER.getPrompt(), intString);
        }
        return convertInt;
    }

    /**
     * 字符串转换为单精度浮点型
     * @param floatString 浮点型字符串
     * @return 单精度浮点型
     */
    public float convert2Float(String floatString) {
        float convertInt = 0;
        try {
            if (floatString != null && floatString != "") {
                convertInt = Float.valueOf(floatString);
            }
        } catch (NumberFormatException e) {
            System.out.printf(PromptEnum.PLEASE_ENTER_CORRECT_NUMBER.getPrompt(), floatString);
        }
        return convertInt;
    }

    /**
     * 字符串转换为双精度浮点型
     * @param doubleString 浮点型字符串
     * @return 双精度浮点型
     */
    public double convert2Double(String doubleString) {
        double convertInt = 0;
        try {
            if (doubleString != null && doubleString != "") {
                convertInt = Double.valueOf(doubleString);
            }
        } catch (NumberFormatException e) {
            System.out.printf(PromptEnum.PLEASE_ENTER_CORRECT_NUMBER.getPrompt(), doubleString);
        }
        return convertInt;
    }
}
