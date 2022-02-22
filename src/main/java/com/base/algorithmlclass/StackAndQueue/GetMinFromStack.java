package com.base.algorithmlclass.StackAndQueue;

import java.util.Stack;

/**
 * 提供一个getMin方法，返回当前栈中最小值，要求时间复杂度O(1)
 */
public class GetMinFromStack {

    /**
     * MyStack2的优化，
     * 当前数比stackMin大时，不压入
     * 弹出时，仅当stackMin栈顶与当前数相同时弹出
     */
    public static class MyStack1 {
        private Stack<Integer> stackData; //存储元素
        private Stack<Integer> stackMin; //辅助记录最小值

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    /**
     * 基本方法
     */
    public static class MyStack2 {
        private Stack<Integer> stackData; //存储元素的栈
        private Stack<Integer> stackMin; //辅助记录最小值

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            } //将push的值和stackMin当前栈顶之间的较小值，写入stackMin栈顶，保证此时弹出的是最小值
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop(); //stackMin也同步弹出栈顶
            return this.stackData.pop();
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }
}
