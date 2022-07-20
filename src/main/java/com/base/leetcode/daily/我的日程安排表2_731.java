package com.base.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 我的日程安排表2_731 {
    public static List<int[]> oncePeriod;
    public static List<int[]> twicePeriod;

    public 我的日程安排表2_731() {
        oncePeriod = new ArrayList<int[]>();
        twicePeriod = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        if (end <= start) {
            return false;
        }
        for (int[] period : twicePeriod) {
            if (start < period[1] && end > period[0]) {
                return false;
            }
        }

        for (int[] period : oncePeriod) {
            if (start < period[1] && end > period[0]) {
                twicePeriod.add(new int[]{Math.max(start, period[0]), Math.min(end, period[1])});
            }
        }
        oncePeriod.add(new int[]{start, end});
        return true;
    }
    // s1: 会内存溢出
    /*
    public static Map<Integer, Integer> record;

    public 我的日程安排表2_731() {
        record = new HashMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        if (end <= start) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (record.get(i) != null && 2 == record.get(i)) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            record.put(i, record.get(i) == null ? 1 : record.get(i) + 1);
        }
        return true;
    }*/

}
