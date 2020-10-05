package com.fcd.oldexam.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5af18ba2eb45443aa91a11e848aa6723
 * 来源：牛客网
 *
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 *
 *
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class 字串的连接最长路径查找 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String [] ss = new String[num];
        for (int i = 0; i < num; i++) {
            ss[i]=sc.next();
        }
        Arrays.sort(ss);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
}
