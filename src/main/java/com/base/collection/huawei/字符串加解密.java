package com.base.collection.huawei;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/2aa32b378a024755a3f251e75cbf233a
 * 来源：牛客网
 *
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 *
 *
 * 接口描述：
 *
 *     实现接口，每个接口实现1个基本操作：
 *
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 *
 * 说明：
 *
 * 1、字符串以\0结尾。
 *
 * 2、字符串最长100个字符。
 *
 *
 *
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 *
 * 说明：
 *
 * 1、字符串以\0结尾。
 *
 * 2、字符串最长100个字符。
 *
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 *
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 示例1
 * 输入
 * abcdefg
 * BCDEFGH
 * 输出
 * BCDEFGH
 * abcdefg
 */
public class 字符串加解密 {
    public static char encryption(char c){
        if(c >= 'a' && c < 'z') {
            return (char) (c + 1 - 32);
        }else if(c == 'z'){
            return 'A';
        }else if(c >= 'A' && c < 'Z'){
            return (char)(c + 1 + 32);
        }else if(c == 'Z'){
            return 'a';
        }else if(c >= '0' && c < '9'){
            return (char)(c + 1);
        }else if(c == '9'){
            return '0';
        }else{
            return c;
        }
    }

    public static char decryption(char c){
        if(c > 'a' && c <= 'z') {
            return (char)(c - 1 - 32);
        }else if(c == 'a'){
            return 'Z';
        }else if(c > 'A' && c <= 'Z'){
            return (char)(c - 1 + 32);
        }else if(c == 'A'){
            return 'z';
        }else if(c > '0' && c <= '9'){
            return (char)(c - 1);
        }else if(c == '0'){
            return '9';
        }else{
            return c;
        }
    }

    public static String enCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(encryption(cs[i]));
        }
        return sb.toString();
    }

    public static String deCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(decryption(cs[i]));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(enCryption(s1));
            System.out.println(deCryption(s2));
        }
        sc.close();
    }
}
