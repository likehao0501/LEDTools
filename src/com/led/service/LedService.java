package com.led.service;

/**
 * @author likehao
 */
public interface LedService {

    /**
     * 显示logo
     */
    void showLogo();

    /**
     * 显示总菜单
     */
    void showMenu();

    /**
     * 显示选项[1]图像
     * @param type 菜单编号
     */
    void showImage(int type);

    /**
     * 显示选项[1]提示
     */
    void showTip1();

    /**
     * 单个LED电路电阻计算
     * @param type 菜单编号
     */
    void ledCalc(int type);

    /**
     * 显示计算结束
     */
    void calculateFinish();

    /**
     * 显示退出程序
     */
    void exitProgram();
}
