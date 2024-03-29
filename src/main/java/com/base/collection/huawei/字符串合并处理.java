package com.base.collection.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/d3d8e23870584782b3dd48f26cb39c8f
 * 来源：牛客网
 *
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 输入描述:
 * 输入两个字符串
 *
 *
 *
 * 输出描述:
 * 输出转化后的结果
 *
 * 示例1
 * 输入
 * dec fab
 * 输出
 * 5D37BF
 */
public class 字符串合并处理 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            str += sc.next();
            System.out.println(processString(str));
        }
    }
    private static String processString(String str){
        if(str==null||str.length()==0){
            return "";
        }
        int n = str.length();
        ArrayList<Character> ji = new ArrayList<>();
        ArrayList<Character> ou = new ArrayList<>();
        for(int i=0;i<n;i++){//奇数和偶数分开存到集合中
            if(i%2==0){
                ou.add(str.charAt(i));
            }else{
                ji.add(str.charAt(i));
            }
        }
        //排序
        Collections.sort(ji);
        Collections.sort(ou);
        char[] chs = new char[n];
        int ouIndex = 0,jiIndex = 0;
        for(int i=0;i<n;i++){//之后再把排序后的奇数偶数重新放到char型数组中
            if(i%2==0){
                chs[i] = ou.get(ouIndex++);
            }else{
                chs[i] = ji.get(jiIndex++);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){//依次把char型数组中的字符经过处理后就加入到stringbuffer中
            char ch = chs[i];
            if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='f')||(ch>='A'&&ch<='F')){
                sb.append(processChar(ch));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    private static char processChar(char c){//处理这些特殊字符，返回char型字符
        int num = 0;//num代表该字符所代表的十六进制数字
        if(c>='0'&&c<='9'){
            num = Integer.parseInt(c+"");
        }else if(c>='a'&&c<='f'){
            num = c-87;
        }else {
            num = c-55;
        }
        return getReverseResult(num);//也就是对该十六进制数字进行处理
    }
    private static char getReverseResult(int num){//对该十六进制数字进行处理
        String nums = reverseBinaryString(num);//对该数字进行转化为4位二进制数，然后反转。
        int res = Integer.parseInt(nums,2);//之后再对返回后的二进制字符串转换为十进制数字
        if(res>=0&&res<=9){//对十进制数字分两种情况转换为十六进制字符
            return (res+"").charAt(0);
        }else{
            return (char)(res+55);
        }
    }
    //对该数字进行转化为4位二进制数，然后反转，返回反转后的字符串
    private static String reverseBinaryString(int num){
        int k = 1<<3;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<4;i++){
            int flag = ((num&k)==0?0:1);
            sb.append(flag);
            num=num<<1;
        }
        return sb.reverse().toString();
    }
}
