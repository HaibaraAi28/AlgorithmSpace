package com.fcd.interview.huawei;

import java.util.Scanner;
import java.util.Stack;

public class t3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        //存放操作符
        Stack<String> opeStack = new Stack<>();

        //存放计算结果
        Stack<Integer> numStack = new Stack<>();

        try {
            proceed(string, opeStack, numStack);
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public static void proceed(String string, Stack<String> opeStack, Stack<Integer> resStack) {
        int length = string.length();

        for (int i = 0; i < length;) {
            char ch = string.charAt(i);
            //如果是空格，跳出
            if (ch == ' ') {
                i++;
                continue;
            }

            if (ch == '(') {
                //操作符入栈
                opeStack.push(string.substring(i+1, i+4));
                i+=4;
                continue;
            }

            if ((ch >= '0' && ch <= '9') || ch == '-') {
                int j = i;
                while(string.charAt(j+1) >= '0' && string.charAt(j+1) <= '9') {
                    //将数字读完
                    j++;
                }

                resStack.push(Integer.valueOf(string.substring(i, j+1)));
                i = j+1;
                continue;
            }

            if (ch == ')') {
                //计算结果

                String operation = opeStack.pop();
                Integer num2 = resStack.pop();
                Integer num1 = resStack.pop();

                Integer res = calculate(operation, num1, num2);
                resStack.push(res);
                i++;
            }
        }
        if (opeStack.isEmpty()) {
            //输出计算结果
            System.out.println(resStack.pop());
        } else {
            throw new RuntimeException();
        }
    }

    public static Integer calculate(String operation, Integer num1, Integer num2) {
        switch (operation) {
            case "mul":
                return num1 * num2;
            case "add":
                return num1 + num2;
            case "sub":
                return num1 - num2;
            case "div":
                if (num2 == 0) {
                    throw new RuntimeException();
                }
                return num1 / num2;
            default:
                throw new RuntimeException();
        }
    }
}
