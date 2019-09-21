package com.led;

import com.led.enums.MenuEnum;
import com.led.enums.PromptEnum;
import com.led.service.LedService;
import com.led.service.impl.LedServiceImpl;
import com.led.tools.TypeConvert;

import java.util.Scanner;

/**
 * @author likehao
 */
public class Main {

    private static final String[] GO_ON_OPTIONS = {"y", "n"};

    /**
     * 扫描器
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 类型转换工具
     */
    private static TypeConvert typeConvert = new TypeConvert();

    /**
     * Led业务
     */
    private static LedService ledService = new LedServiceImpl();

    public static void main(String[] args) {
        //显示logo
        ledService.showLogo();

        while (true) {
            //显示总菜单
            ledService.showMenu();

            //提示选择
            System.out.print(PromptEnum.PLEASE_ENTER_TYPE.getPrompt());

            //判断是否输入字符
            if (scanner.hasNext()) {

                //输入的菜单选项
                String typeString = scanner.next();

                //类型转换为Int
                int typeInt = typeConvert.convert2Int(typeString);

                //单个LED电路电阻计算
                MenuEnum menuEnum = MenuEnum.getByIndex(typeInt);
                if (menuEnum != null) {
                    switch (menuEnum) {
                        //单个LED串联电阻计算选项
                        case SHOW_MENU_1:
                        case SHOW_MENU_2:
                        case SHOW_MENU_3:
                            while (true) {
                                ledService.ledCalc(menuEnum.getIndex());
                                ledService.calculateFinish();
                                String next = "";
                                while (true) {
                                    System.out.print("？是否继续计算(y/n)");
                                    if (scanner.hasNext()) {
                                        System.out.println(PromptEnum.SHOW_LINE.getPrompt());
                                        next = scanner.next();
                                        if (next != null && GO_ON_OPTIONS[0].equals(next)) {
                                            System.out.println("          继续计算");
                                            break;
                                        } else if (next != null && GO_ON_OPTIONS[1].equals(next)) {
                                            System.out.println("          返回菜单");
                                            break;
                                        } else {
                                            System.out.printf("X请检查输入的选项\r\n应输入[y]或[n],您输入的是[%s]%n", next);
                                            System.out.println(PromptEnum.SHOW_LINE.getPrompt());
                                        }
                                    }
                                }

                                //如果输入[y]循环执行当前功能
                                if (GO_ON_OPTIONS[0].equals(next)) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            break;

                        //退出程序选项
                        case SHOW_MENU_4:
                            ledService.exitProgram();
                            break;

                        default:

                            break;
                    }

                    //退出外层循环
                    if (typeInt == MenuEnum.SHOW_MENU_4.getIndex()) {
                        break;
                    }
                } else {
                    //提示输入错误
                    System.out.printf(PromptEnum.PLEASE_ENTER_CORRECT_OPTIONS.getPrompt(), typeInt);
                }
            }
        }
    }
}
