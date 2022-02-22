package com.base.collection.huawei;

import java.util.Scanner;

/**
 *
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 *
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 *
 * 也适用于字符串翻转
 */
public class 数字颠倒 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb.toString());
    }

}
