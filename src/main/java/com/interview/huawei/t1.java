package com.interview.huawei;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }
        s = s.substring(1, s.length()-1);
        String[] numString = s.split(",");
        int[] nums = new int[numString.length+1];
//        int max = 0;

        for (String string : numString) {
            int num = Integer.valueOf(string);
            nums[num] = 1;
//            if (num > max) {
//                max = num;
//            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                System.out.print(i);
                return;
            }
        }
    }
}
