package com.led.service.impl;

import com.led.enums.MenuEnum;
import com.led.enums.PromptEnum;
import com.led.service.LedService;
import com.led.tools.TypeConvert;

import java.util.Scanner;

/**
 * @author likehao
 */
public class LedServiceImpl implements LedService {

    /**
     * 小数格式化字符串 保留3位小数
     */
    private static final String FORMAT_STRING = "%.3f";

    /**
     * String.indexOf() 无匹配时返回-1
     */
    private static final int NONE = -1;

    /**
     * 开始下标
     */
    private static final int BEGIN_INDEX = 0;

    /**
     * 电阻值的键
     */
    private static final String RESISTANCE = "resistance";

    /**
     * 电阻值的单位
     */
    private static final String[] RESISTANCE_UNIT = {"Ω", "KΩ", "MΩ"};

    /**
     * 菜单选项1
     */
    private static final int TYPE_ONE = 1;

    /**
     * 类型2
     */
    private static final int TYPE_TWO = 2;

    /**
     * 类型3
     */
    private static final int TYPE_THREE = 3;

    /**
     * 倍数K
     */
    private static final int MULTIPLE_1000 = 1000;

    /**
     * 倍数M
     */
    private static final int MULTIPLE_1000000 = 1000000;

    /**
     * 扫描器
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 类型转换工具
     */
    private static TypeConvert typeConvert = new TypeConvert();

    @Override
    public void showLogo() {
        System.out.println(PromptEnum.LOGO_IMAGE_01.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_02.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_03.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_04.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_05.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_06.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_07.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_08.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_09.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_10.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_11.getPrompt());
        System.out.println(PromptEnum.LOGO_IMAGE_12.getPrompt() + "\r\n");
    }


    /**
     * 显示总菜单
     */
    @Override
    public void showMenu() {
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(MenuEnum.MENU.getMessage());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());

        //选项1
        System.out.printf(MenuEnum.SHOW_BOX.getMessage(), MenuEnum.SHOW_MENU_1.getIndex());
        System.out.println(MenuEnum.SHOW_MENU_1.getMessage());

        //选项2
        System.out.printf(MenuEnum.SHOW_BOX.getMessage(), MenuEnum.SHOW_MENU_2.getIndex());
        System.out.println(MenuEnum.SHOW_MENU_2.getMessage());

        //选项3
        System.out.printf(MenuEnum.SHOW_BOX.getMessage(), MenuEnum.SHOW_MENU_3.getIndex());
        System.out.println(MenuEnum.SHOW_MENU_3.getMessage());

        //选项4
        System.out.printf(MenuEnum.SHOW_BOX.getMessage(), MenuEnum.SHOW_MENU_4.getIndex());
        System.out.println(MenuEnum.SHOW_MENU_4.getMessage());

        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
    }

    /**
     * 显示选项[1]图像
     */
    @Override
    public void showImage(int type) {
        switch (type) {
            case TYPE_ONE:
            case TYPE_TWO:
            case TYPE_THREE:
                System.out.println(PromptEnum.SHOW_LINE.getPrompt());
                System.out.println(PromptEnum.SINGLE_LED_CONNECT_1.getPrompt());
                System.out.println(PromptEnum.SHOW_LINE.getPrompt());
                System.out.println(PromptEnum.SINGLE_LED_CONNECT_2.getPrompt());
                System.out.println(PromptEnum.SINGLE_LED_CONNECT_3.getPrompt());
                System.out.println(PromptEnum.SINGLE_LED_CONNECT_4.getPrompt());
                break;

            default:

                break;
        }
    }

    /**
     * 显示选项[1]提示
     */
    @Override
    public void showTip1() {
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_01.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_02.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_03.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_04.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_05.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_06.getPrompt());
        System.out.println(PromptEnum.SHOW_TIPS_07.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
    }

    /**
     * 单个LED电路电阻计算
     */
    @Override
    public void ledCalc(int type) {

        //显示图像
        showImage(type);

        //显示提示
        showTip1();

        //提示输入电压
        System.out.print(PromptEnum.PLEASE_ENTER_VOLTAGE.getPrompt());

        //判断是否输入字符
        if (scanner.hasNext()) {

            //输入的电压值
            String voltageString = scanner.next();

            //类型转换为Float
            float voltageFloat = typeConvert.convert2Float(voltageString);

            //提示输入LED两端电压
            System.out.print(PromptEnum.PLEASE_ENTER_LED_VOLTAGE.getPrompt());

            //判断是否输入字符
            if (scanner.hasNext()) {

                //输入的LED两端电压值
                String ledVoltageString = scanner.next();

                //类型转换为Float
                float ledVoltageFloat = typeConvert.convert2Float(ledVoltageString);

                //判断电源电压大于LED电压
                if (voltageFloat > ledVoltageFloat) {

                    //提示输入LED电流值
                    System.out.print(PromptEnum.PLEASE_ENTER_LED_ELECTRICITY.getPrompt());

                    //判断是否输入字符
                    if (scanner.hasNext()) {

                        //输入的LED电流值
                        String ledElectricityString = scanner.next();

                        //类型转换为Float
                        float ledElectricityFloat = typeConvert.convert2Float(ledElectricityString);


                        //电压值
                        float voltageDifferenceFloat = 0.0f;

                        //LED电流
                        double ledElectricityDouble = 0.00;

                        //LED数量
                        int ledCountInt = 1;

                        //不是单LED时需要输入数量
                        if (type != TYPE_ONE) {
                            //提示输入LED数量
                            System.out.print(PromptEnum.PLEASE_ENTER_LED_COUNT.getPrompt());
                            if (scanner.hasNext()) {
                                String ledCountString = scanner.next();
                                ledCountInt = typeConvert.convert2Int(ledCountString);
                            }
                        }

                        if (type == TYPE_TWO) {
                            //1.电源电压-(led电压xled数量)=电阻电压
                            voltageDifferenceFloat = voltageFloat - (ledVoltageFloat * ledCountInt);
                            //将LED电流(I)换算为安培(A)
                            ledElectricityDouble = ledElectricityFloat / 1000.00;
                        } else if (type == TYPE_THREE) {
                            //1.电源电压-led电压xled数量=电阻电压
                            voltageDifferenceFloat = voltageFloat - ledVoltageFloat;
                            //将LED电流(I)x数量之后换算为安培(A)
                            ledElectricityDouble = ledElectricityFloat * ledCountInt / 1000.00;
                        } else {
                            //1.电源电压-led电压=电阻电压
                            voltageDifferenceFloat = voltageFloat - ledVoltageFloat;
                            //将LED电流(I)换算为安培(A)
                            ledElectricityDouble = ledElectricityFloat / 1000.00;
                        }
                        /*
                         * 根据欧姆定律
                         * 电阻=电压/电流
                         */

                        //2.电阻电压/LED电流=电阻阻值
                        double resistanceDouble = voltageDifferenceFloat / ledElectricityDouble;
                        //输出计算得到的电阻值
                        String resistanceString = String.format(FORMAT_STRING, resistanceDouble);
                        String res = resistanceFormat(resistanceString);
                        System.out.printf(PromptEnum.OUTPUT_RESISTANCE.getPrompt(), resistanceString, res);

                        //计算led功率
                        double ledPower = ledElectricityDouble * ledVoltageFloat;
                        System.out.printf(PromptEnum.LED_POWER.getPrompt(), String.format(FORMAT_STRING, ledPower), String.format(FORMAT_STRING, ledPower * 1000));

                        //计算电阻功率
                        double resistancePower = ledElectricityDouble * voltageDifferenceFloat;
                        System.out.printf(PromptEnum.RESISTANCE_POWER.getPrompt(), String.format(FORMAT_STRING, resistancePower), String.format(FORMAT_STRING, resistancePower * 1000));

                        //计算安全的电阻功率
                        double safeResistancePower = resistancePower / 0.6;
                        System.out.printf(PromptEnum.SAFE_RESISTANCE_POWER.getPrompt(), String.format(FORMAT_STRING, safeResistancePower), String.format(FORMAT_STRING, safeResistancePower * 1000));

                        //提示电阻功率换算表
                        resistanceTips();
                    }
                } else {
                    //提示电源电压小于LED电压
                    checkVoltage(voltageString, ledVoltageString);
                }
            }
        }
    }

    /**
     * 显示计算结束
     */
    @Override
    public void calculateFinish() {
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.CALCULATE_FINISH.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
    }

    /**
     * 显示退出程序
     */
    @Override
    public void exitProgram() {
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.EXIT_PROGRAM.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.BYE_BYE.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt() + "\r\n");
    }

    /**
     * 提示电源电压小于LED电压
     *
     * @param voltageString    电源电压
     * @param ledVoltageString LED电压
     */
    private void checkVoltage(String voltageString, String ledVoltageString) {
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.println(PromptEnum.CHECK_VOLTAGE.getPrompt());
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
        System.out.printf(PromptEnum.VOLTAGE_CHECK_TIP.getPrompt(), voltageString);
        System.out.printf(PromptEnum.LED_VOLTAGE_CHECK_TIP.getPrompt(), ledVoltageString);
        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
    }

    /**
     * 提示电阻功率
     */
    private void resistanceTips() {
        System.out.println(PromptEnum.RESISTANCE_Tips1.getPrompt());
        System.out.println(PromptEnum.RESISTANCE_Tips2.getPrompt());
        System.out.println(PromptEnum.RESISTANCE_Tips3.getPrompt());
        System.out.println(PromptEnum.RESISTANCE_Tips4.getPrompt());
        System.out.println(PromptEnum.RESISTANCE_Tips5.getPrompt());
        System.out.println(PromptEnum.RESISTANCE_Tips6.getPrompt());
    }

    /**
     * @param resistance
     * @return
     */
    private String resistanceFormat(String resistance) {
        if (resistance != null) {

            double resistanceDouble = typeConvert.convert2Double(resistance);
            //单位
            String unit = RESISTANCE_UNIT[0];
            if (resistanceDouble / MULTIPLE_1000000 >= 1) {
                resistanceDouble /= 1000000;
                unit = RESISTANCE_UNIT[2];
            } else if (resistanceDouble / MULTIPLE_1000 >= 1) {
                resistanceDouble /= 1000;
                unit = RESISTANCE_UNIT[1];
            }

            String resistanceDoubleString = String.valueOf(resistanceDouble);

            int index = resistanceDoubleString.indexOf('.');
            int value = 0;
            if (index != NONE) {
                //取出小数部分
                int decimal = typeConvert.convert2Int(resistanceDoubleString.substring(index + 1));

                //判断小数部分是不是全为0
                if (decimal == 0) {
                    value = typeConvert.convert2Int(resistanceDoubleString.substring(BEGIN_INDEX, index));
                    return value + unit;
                } else {
                    return String.format(FORMAT_STRING, resistanceDouble) + unit;
                }
            }
        }
        return NONE + RESISTANCE_UNIT[0];
    }
}
