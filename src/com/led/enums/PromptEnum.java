package com.led.enums;

/**
 * 提示文本
 * @author likehao
 */
public enum PromptEnum {
    /**
     * logo-01
     */
    LOGO_IMAGE_01("     __     _____  ____     "),
    LOGO_IMAGE_02("    |  |   |   __||    \\    "),
    LOGO_IMAGE_03("    |  |__ |   __||  |  |   "),
    LOGO_IMAGE_04("    |_____||_____||____/    "),
    LOGO_IMAGE_05(" _____  _____  __     _____ "),
    LOGO_IMAGE_06("|     ||  _  ||  |   |     |"),
    LOGO_IMAGE_07("|  |--||     ||  |__ |  |--|"),
    LOGO_IMAGE_08("|_____||__|__||_____||_____|"),
    LOGO_IMAGE_09(" _____  _____  _____  __    "),
    LOGO_IMAGE_10("|_   _||     ||     ||  |   "),
    LOGO_IMAGE_11("  | |  |  |  ||  |  ||  |__ "),
    LOGO_IMAGE_12("  |_|  |_____||_____||_____|"),

    PLEASE_ENTER_TYPE("*请输入选项:"),
    PLEASE_ENTER_CORRECT_NUMBER("X请输入正确的数字，例如:[1]。您输入的是:[%s] %n"),
    PLEASE_ENTER_CORRECT_OPTIONS("X请输入正确的选项，例如:[1]。您输入的是:[%s] %n%n"),

    SHOW_LINE("────────────────────────────"),

    SHOW_TIPS_01("          电压参考"),
    SHOW_TIPS_02("       红色:2.0~2.2V"),
    SHOW_TIPS_03("       黄色:1.8~2.0V"),
    SHOW_TIPS_04("       白色:3.0~4.0V"),
    SHOW_TIPS_05("       蓝色:3.0~4.0V"),
    SHOW_TIPS_06("       绿色:2.0~2.2V"),
    SHOW_TIPS_07("       绿色:3.0~3.2V"),

    SINGLE_LED_CONNECT_1("     单个LED串联电阻计算"),
    SINGLE_LED_CONNECT_2("         ┌┬─────┬┐"),
    SINGLE_LED_CONNECT_3("   ──────┤│  R  │├──────"),
    SINGLE_LED_CONNECT_4("         └┴─────┴┘"),

    PLEASE_ENTER_VOLTAGE("*请输入电源电压-伏特(V):"),
    PLEASE_ENTER_LED_VOLTAGE("*请输入LED电压-伏特(V):"),
    PLEASE_ENTER_LED_ELECTRICITY("*请输入LED电流-毫安(mA):"),
    PLEASE_ENTER_LED_COUNT("*请输入LED数量:"),

    OUTPUT_RESISTANCE("√电阻值为:%sΩ, %s%n"),
    LED_POWER("√LED电功率:%sW, %smW%n"),
    RESISTANCE_POWER("√电阻功率:%sW, %smW%n"),
    SAFE_RESISTANCE_POWER("√安全电阻功率:%sW, %smW%n"),

    RESISTANCE_Tips1("1W = 1000mW"),
    RESISTANCE_Tips2("1/2W = 0.5W = 500mW"),
    RESISTANCE_Tips3("1/4W = 0.25W = 250mW"),
    RESISTANCE_Tips4("1/8W = 0.125W = 125mW"),
    RESISTANCE_Tips5("1/16W = 0.0625W = 62.5mW"),
    RESISTANCE_Tips6("1/32W = 0.03125W = 31.25mW"),

    CHECK_VOLTAGE("“X电源电压”应当比“LED电压”高!\r\nX请检查“电源电压”与“LED电压”。"),

    VOLTAGE_CHECK_TIP("X您输入的电源电压为:%sV,%n"),
    LED_VOLTAGE_CHECK_TIP("LED电压为:%sV%n"),

    CALCULATE_FINISH("          计算结束"),

    EXIT_PROGRAM("          退出程序"),
    BYE_BYE("          Bye bye");


    private String prompt;

    PromptEnum(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
