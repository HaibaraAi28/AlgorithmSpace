package com.fcd.simulate.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 *
 * 输入例子1:
 * 0xA
 *
 * 输出例子1:
 * 10
 */
public class test2_进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String s = sc.nextLine();

            s = s.substring(2);

            System.out.println(convert(s));
        }
    }

    public static int convert(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int val = 0;
            if (chars[i] >= 'A' && chars[i] <= 'F') {
                val = (int)chars[i] - 55;
            } else {
                val = Integer.parseInt(String.valueOf(chars[i]));
            }
            res += Math.pow(16, chars.length - 1 - i) * val;
        }
        return res;
    }
}
