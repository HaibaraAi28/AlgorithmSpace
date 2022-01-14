package com.fcd.collection.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e4af1fe682b54459b2a211df91a91cf3
 * 来源：牛客网
 *
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * voidencrypt(char * key,char * data,char * encrypt);
 *
 * 输入参数：
 *
 * char * key：密匙
 *
 * char * data：明文
 *
 * 输出参数：
 *
 * char * encrypt：密文
 *
 * 返回值：
 *
 * void
 *
 * 本题有多组输入数据，请使用while(cin>>)读取
 *
 *
 * 输入描述:
 * 先输入key和要加密的字符串
 *
 *
 *
 * 输出描述:
 * 返回加密后的字符串
 *
 * 示例1
 * 输入
 * nihao
 * ni
 * 输出
 * le
 */
public class 字符串加密 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            char[] key = cin.next().toCharArray(),
                    s = cin.next().toCharArray();

            Set<Character> set = new HashSet<>();
            char[] table = new char[26];
            int k = 0;


            for (int i = 0; i < key.length; ++i) {
                char c = key[i];
                if (!set.contains(c)) {
                    table[k++] = c;
                    set.add(Character.toLowerCase(c));
                }
            }

            for (; k < 26; ++k) {
                for (int i = 0; i < 26; ++i) {
                    char c = (char) ('a' + i);
                    if (!set.contains(c)) {
                        table[k++] = c;
                        set.add(Character.toLowerCase(c));
                    }
                }
            }

            for (int i = 0; i < s.length; ++i) {
                boolean up = false;
                char c = s[i];
                if (Character.isUpperCase(c)) {
                    up = true;
                }

                char res = table[c - 'a'];
                if (up) {
                    System.out.print(Character.toUpperCase(res));
                }
                System.out.print(res);
            }

            System.out.println();
        }
    }
}
