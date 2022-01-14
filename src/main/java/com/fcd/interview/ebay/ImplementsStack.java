package com.fcd.interview.ebay;

public class ImplementsStack {


    private int limit;
    private int size = 0;
    private Integer[] arr = null;

    public ImplementsStack(int limit) {
        this.limit = limit;
        this.arr = new Integer[limit];
    }


    public static void main(String[] args) {
        ImplementsStack stack = new ImplementsStack(7);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peak());
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack.push(10));
        System.out.println(stack.push(11));
        System.out.println(stack.push(12));
    }

    public boolean push(int num) {
        if (size < limit) {
            arr[size++] = num;
        } else {
            return false;
        }
        return true;
    }

    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int res = arr[size-1];
        arr[size-1] = null;
        size--;
        return res;
    }

    public Integer peak() {
        return arr[size-1];
    }
}
