package com.fcd.oldexam.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/dfeed0e0e4624814b122265e859783b2
 * 来源：牛客网
 *
 * 先输入你要输入的字符串的个数。然后换行输入该组字符串。每个字符串以回车结束，每个字符串少于一百个字符。 如果在输入过程中输入的一个字符串为“stop”，也结束输入。 然后将这输入的该组字符串按每个字符串的长度，由小到大排序，按排序结果输出字符串。
 *
 * 输入描述:
 * 字符串的个数，以及该组字符串。每个字符串以‘\n’结束。如果输入字符串为“stop”，也结束输入.
 *
 *
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 将输入的所有字符串按长度由小到大排序输出(如果有“stop”，不输出“stop”)。
 *
 * 根据输入的字符串个数来动态分配存储空间（采用new()函数）。每个字符串会少于100个字符。
 * 测试数据有多组，注意使用while()循环输入。
 * 示例1
 * 输入
 * 5
 * sky is grey
 * cold
 * very cold
 * stop
 * 3
 * it is good enough to be proud of
 * good
 * it is quite good
 * 输出
 * cold
 * very cold
 * sky is grey
 * good
 * it is quite good
 * it is good enough to be proud of
 */
public class 字符串排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.equals("stop")) {
                break;
            } else {
                list.add(line);
            }
        }
        list.sort(Comparator.comparingInt(String::length));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
