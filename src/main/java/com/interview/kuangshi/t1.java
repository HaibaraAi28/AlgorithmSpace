package com.interview.kuangshi;

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "zhangchangzhi", C = 'a'
 * 输出: [2, 1, 0, 1, 2, 2 ,1, 0, 1, 2,3,4,5]
 */
public class t1 {
    public static void main(String[] args) {
        String S = "zhangchangzhi";
        char C = 'a';

        int[] res = returnDistance(S, C);
        System.out.print('[');
        for(int i = 0; i < res.length; i++) {
            if (i != res.length -1) {
                System.out.print(res[i] + ", ");
            } else {
                System.out.print(res[i] + "]");
            }
        }
    }

    public static int[] returnDistance(String s, char ch) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = Math.min(searchToLeft(chars, ch, i), searchToRight(chars, ch, i));
        }
        return res;
    }

    public static int searchToLeft(char[] chars, char ch, int index) {
        int start = index;
        while(index > 0 && chars[index] != ch) {
            index--;
        }
        if (index == 0) {
            index = 0 - chars.length -1;
        }
        return start - index;
    }

    public static int searchToRight(char[] chars, char ch, int index) {
        int start = index;
        while(index < chars.length && chars[index] != ch) {
            index++;
        }
        if (index == chars.length) {
            index = chars.length * 2 + 1;
        }
        return index - start;
    }
}
