package com.base.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 优势洗牌_870 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{718967141,189971378,341560426,23521218,339517772};
        int[] nums2 = new int[]{967482459,978798455,744530040,3454610,940238504};

        System.out.println(advantageCount(nums1, nums2));
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < length; i++) {
            if (indexMap.get(nums2[i]) != null) {
                List<Integer> indexValues = indexMap.get(nums2[i]);
                indexValues.add(i);
                indexMap.put(nums2[i], indexValues);
            } else {
                List<Integer> indexValues = new ArrayList<>();
                indexValues.add(i);
                indexMap.put(nums2[i], indexValues);
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int point = 0;

        // 遍历排序后的nums2,每次寻找nums1中对应大于nums2[i]的最小数
        int[] res = new int[length];
        Arrays.fill(res, -1);
        for (int i = 0; i < length; i++) {
            // 获取nums1中比nums2当前值大的最小值填入res对应位置，并将nums1对应值置为-1做标记
            point = getNextLargerIndex(nums1, point, nums2[i]);
            if (point > -1) {
                List<Integer> indexValues = indexMap.get(nums2[i]);
                res[indexValues.get(0)] = nums1[point];
                nums1[point] = -1;
                indexValues.remove(0);
            } else {
                break;
            }
        }
        int index = 0;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums1[i] > -1) {
                temp[index++] = nums1[i];
            }
        }
        index = 0;
        for (int i = 0; i < length; i++) {
            if (res[i] == -1) {
                res[i] = temp[index++];
            }
        }
        return res;
    }

    private static int getNextLargerIndex(int[] arr, int start, int value) {
        if (start >= arr.length) {
            return -1;
        }

        for (int i = start; i < arr.length; i++) {
            if (arr[i] > value) {
                return i;
            }
        }
        return -1;
    }
}
