package com.interview.huawei;

public class t5 {

    public static void main(String[] args) {
        System.out.println(mutiply("123456789", "20"));
    }

    public static int mutiply(String num1, String num2) {

        if (num1.equals("0") ||   num2.equals("0")) {
            return 0;
        }

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();

        int length = a.length + b.length;
        int[] result = new int[length];


        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                result[length - 2 - i - j] += (a[i] - 48) * (b[j] - 48);
            }
        }

        for (int i = 0; i < length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }

        int answer = 0;
        for (int i = 0 ; i < length; i++) {
            answer += result[i] * Math.pow(10, i);
        }
        return answer;
    }
}
