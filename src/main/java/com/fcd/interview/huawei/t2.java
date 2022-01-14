package com.fcd.interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] info = s.split(" ");

        char[] chars = info[0].toCharArray();
        Arrays.sort(chars);

        int size = Integer.valueOf(info[1]);

        if (size == chars.length) {
            //都是个位数
            System.out.println(chars[0]);
            return;
        } else if (chars.length > size && chars.length < size * 2) {
            //个位数加两位数,有特殊情况
            System.out.println(10 - (size*2 - chars.length));
            return;
        } else if (chars.length == size * 2) {
            if (size >= 92) {
                System.out.println(10 - (size-90)/2);
            }
            //都是两位数，有特殊情况
            for (int i = 10; i < 99 - size; i++) {
                String res = generate(i, size);
                char[] resChars = res.toCharArray();
                Arrays.sort(resChars);
                if (Arrays.equals(chars, resChars)) {
                    System.out.println(res.substring(0,2));
                    return;
                }
            }
        } else if (chars.length > size * 2 && chars.length < size * 3) {
            //有两位数，有三位数
            System.out.println(100 - (size * 3 - chars.length));
        } else if (chars.length == size * 3) {
            //都是三位数
            for (int i = 100; i < 999 - size; i++) {
                String res = generate(i, size);
                char[] resChars = res.toCharArray();
                Arrays.sort(resChars);
                if (Arrays.equals(chars, resChars)) {
                    System.out.println(res.substring(0,3));
                    return;
                }
            }
        }

        System.out.println();
    }

    public static int[] convert(char[] chars) {
        int[] nums = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return nums;
    }


    public static String generate(Integer num, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(num.toString());
            num++;
        }
        return sb.toString();
    }
}
