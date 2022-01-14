package com.fcd.collection.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 *
 * 输入描述:
 * 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 *
 *
 * 输出描述:
 * 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 * 示例1
 * 输入
 * 7 2
 * 输出
 * 111
 */
public class 进制转换 {

    public static void main(String[] args) {
//        //N进制转换器
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        //查询表,
        String table = "0123456789ABCDEF";
        int flag = 1;
        if (M < 0) {
            M = -M;
            flag = 0;
        }

        Stack S = new Stack();
        decimalBaseToNBaseConvertor(M, N, S, table);
        //output
        if (flag == 0) {
            S.push('-');
        }
        while (!S.empty()) {
            System.out.print(S.pop());
        }
    }
//十进制转二进制,占用空间较多;递归算法;
/*改进:
    1. 使用堆栈来存储余数,并且利用堆栈的特点,倒序输出余数的值,N进制.堆栈是wrapper Character Object
    2. 输入用Scanner类型到存储System.in的值.
    3. Object 有String 和Character.A Java String is an object of the class java.lang.
    对象有方法.比C++的String更加方面(单纯char的数组）.
    This Character class also offers a number of useful class (i.e., static) methods
    for manipulating characters.
时间复杂度:
空间复杂度:*/

    public static void decimalBaseToNBaseConvertor(int M, int N, Stack<Character> S, String table) {
        if (M == 0) {
            return;
        }

        //入栈
        S.push(table.charAt(M % N));
        //下一次
        decimalBaseToNBaseConvertor(M / N, N, S, table);

    }
}
