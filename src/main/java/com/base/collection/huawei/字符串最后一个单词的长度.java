package com.base.collection.huawei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 *
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 */
public class 字符串最后一个单词的长度 {

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] s = str.split(" "); //正则表达式实用性更强( str.split("\\s+"))
//        int length = s[s.length - 1].length();
//        System.out.println(length);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i)==' ') { // 或者 if (str.substring(i, i + 1).equals(" ")) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
