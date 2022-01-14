package com.fcd.interview;

import org.junit.Assert;
import org.junit.Test;


class QuickSortTest {

    @Test
    public void quickSortTest() {
        int[] nums = {5,4,3,2,1};
        int[] res = {1,2,3,4,5};

        QuickSort.sort(nums);
        Assert.assertArrayEquals(nums,res);
    }

}