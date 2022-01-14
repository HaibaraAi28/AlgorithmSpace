package com.fcd.interview;

public class QuickSort {
    public static void main(String[] args){
        int[] nums = {23,421,6136,36,2,4556,156,15,16};
        sort(nums);
        for ( int i = 0; i< nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        int left = low; //左边指针
        int right = high;//右边指针
        int privot = nums[left]; //标准值                        

        while(left < right){

            while (nums[right] >= privot && left < right){
                //找到右边第一个比privot小的值得下标
                right--;
            }

            while (nums[left] <= privot && left < right){
                //找到左边第一个比privot大的值得下标
                left++;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        nums[low] = nums[left];
        nums[left] = privot;

        if (low < high) {
            quickSort(nums, low, left-1);
            quickSort(nums, left+1, high);
        }
    }
}
