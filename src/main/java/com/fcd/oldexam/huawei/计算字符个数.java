package com.fcd.oldexam.huawei;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a35ce98431874e3a820dbe4b2d0508b1?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 *
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 */
public class 计算字符个数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        System.out.print(str.length()-str.replaceAll(s,"").length());
    }
}
