package com.base.collection.huawei;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/440f16e490a0404786865e99c6ad91c9
 * 来源：牛客网
 *
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 *
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 */
public class 求int型数据在内存中存储时1的个数 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n>0){
            if((n&1)>0){
                count++;
            }
            n=n>>1;
        }
        System.out.println(count);
    }



/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String s = Integer.toBinaryString(num);
        num=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                num++;
            }
        }
        System.out.println(num);
    }*/
}
