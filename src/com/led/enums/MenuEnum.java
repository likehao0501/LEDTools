package com.led.enums;

/**
 * 菜单项
 * @author likehao
 */
public enum MenuEnum {
    /**
     * 菜单提示
     */
    MENU(0,"            菜单            "),

    /**
     * 显示选项狂
     */
    SHOW_BOX(0,"[%s] "),

    /**
     * 单个LED串联电阻计算
     */
    SHOW_MENU_1(1,"单个LED串联电阻计算"),

    /**
     * 多个LED串联电路电阻计算
     */
    SHOW_MENU_2(2,"多个LED串联电路电阻计算"),

    /**
     * 多个LED并联电路电阻计算
     */
    SHOW_MENU_3(3,"多个LED并联电路电阻计算"),

    /**
     * 退出程序
     */
    SHOW_MENU_4(4,"退出程序");

    /**
     * 菜单选项值
     */
    private Integer index;

    /**
     * 菜单项描述
     */
    private String message;

    MenuEnum(Integer index, String message) {
        this.index = index;
        this.message = message;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static MenuEnum getByIndex(Integer id) {
        for (MenuEnum menu : values()) {
            if (menu.getIndex().equals(0)) {
                continue;
            } else if (menu.getIndex().equals(id)) {
                //获取指定的枚举
                return menu;
            }
        }
        return null;
    }
}
