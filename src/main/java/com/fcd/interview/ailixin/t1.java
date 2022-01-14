package com.fcd.interview.ailixin;

public class t1 {

    public static void main(String[] args) {
        System.out.println(solution(-999));
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        if (N > 0) {
            String num = String.valueOf(N);
            char[] chars = num.toCharArray();
            char[] res = new char[chars.length + 1];
            int index = 0;
            boolean isInsert = false;
            for(int i = 0; i < chars.length; i++) {
                if (!isInsert && '5' >= chars[i]) {
                    res[index] = '5';
                    res[index+1] = chars[i];
                    isInsert = true;
                    index+=2;
                } else {
                    res[index] = chars[i];
                    index++;
                }
            }
            return Integer.parseInt(String.valueOf(res));
        } else if (N == 0) {
            return 50;
        } else {
            String num = String.valueOf(N);
            num = num.substring(1);
            char[] chars = num.toCharArray();
            char[] res = new char[chars.length + 1];
            int index = 0;
            boolean isInsert = false;
            for(int i = 0; i < chars.length; i++) {
                if (!isInsert && '5' < chars[i]) {
                    res[index] = '5';
                    res[index+1] = chars[i];
                    isInsert = true;
                    index+=2;
                } else {
                    res[index] = chars[i];
                    index++;
                }
            }
            return 0 - Integer.parseInt(String.valueOf(res));
        }
    }


}
