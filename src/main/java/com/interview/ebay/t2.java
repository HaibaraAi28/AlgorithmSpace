package com.interview.ebay;

import java.util.Arrays;

public class t2 {

    public void getThreeSum(int[] nums) {
        Arrays.sort(nums);

    }

    public void process1(int[] nums, int left, int right, int num1) {
        for (int i = left; i < right; i++) {
            if (nums[i] > 0 - num1) {
                return;
            }
            process2(nums, i + 1, right, nums[i], num1);
        }
    }

    public void process2(int[] nums, int left, int right, int num2, int num1) {


        while(left < right) {
            if (nums[left] > 0 - num1 - num2) {
                return;
            } else if (nums[left] == 0 - num1 - num2) {
                System.out.println(num1 + " " + num2 + " " + nums[left]);
                return;
            }
            left++;
        }
    }
}
