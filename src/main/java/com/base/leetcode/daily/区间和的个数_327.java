package com.base.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;

public class 区间和的个数_327 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483647,0,-2147483647,2147483647};
        countRangeSum(nums, -564, 3864);
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        int[][] res = new int[nums.length][nums.length];
        res[0][0] = nums[0];
        if (checkRange(res[0][0], lower, upper)) {
            count++;
        }
        for (int i = 1; i < nums.length; i++) {
            res[0][i] = res[0][i-1] + nums[i];
            if (checkRange(res[0][i], lower, upper)) {
                count++;
            }
        }
        for (int j = 1; j < nums.length; j++) {
            for (int i = j; i < nums.length; i++) {
                res[j][i] = res[j-1][i] - res[j-1][j-1];
                if (checkRange(res[j][i], lower, upper)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkRange(int res, int lower, int upper) {
        return res >= lower && res <= upper;
    }
}
