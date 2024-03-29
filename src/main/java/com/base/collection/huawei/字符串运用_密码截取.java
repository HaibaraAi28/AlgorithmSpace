package com.base.collection.huawei;

import java.util.Scanner;

/**
 *
 * Catcher 是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * （注意：记得加上while处理多个测试用例）
 *
 *
 * 输入描述:
 * 输入一个字符串
 *
 *
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入
 * ABBA
 * 输出
 * 4
 */
public class 字符串运用_密码截取 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.next();
            System.out.println(字符串运用_密码截取.getNumber(input));


        }
    }
    public static int getNumber(String str){
        int result = 1;
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        //获取所有子串，查看翻转后的字符串是否包含该子串
        for(int i = temp.length(); i >= 1 ;i--){
            //i为子串的长度
            for(int j = 0; j <= temp.length()-i;j++){
                String tempSubString = temp.substring(j,j + i);
                if(str.contains(tempSubString)){
                    return i;
                }
            }
        }
        return result;
    }
}
