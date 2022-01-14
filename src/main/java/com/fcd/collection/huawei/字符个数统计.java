package com.fcd.collection.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 输入
 * abaca
 * 输出
 * 3
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 *
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * abc
 * 输出
 * 3
 */
public class 字符个数统计 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[] ch=str.toCharArray();
            HashSet<Character> set=new HashSet<Character>();
            for (int i = 0; i < ch.length; i++) {
                set.add(ch[i]);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}
