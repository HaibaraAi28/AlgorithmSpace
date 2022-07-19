package com.base.leetcode.daily;

public class 最长回文子串_05 {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0,0));
        System.out.println(s);
        System.out.println(s.substring(0,1));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);
        }

        int max = 1;
        String res = s.substring(0,1);
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = 1; j <= i && (i+j) < s.length(); j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    if (j * 2 + 1 > max) {
                        max = j * 2 + 1;
                        res = s.substring(i-j, i+j+1);
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                if (max < 2) {
                    max = 2;
                    res = s.substring(i,i+2);
                }
                for (int j = 1; j <= i && (i+j+1) < s.length(); j++) {
                    if (s.charAt(i-j) == s.charAt(i+j+1)) {
                        if (j * 2 + 2 > max) {
                            max = j * 2 + 2;
                            res = s.substring(i-j, i+j+2);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
