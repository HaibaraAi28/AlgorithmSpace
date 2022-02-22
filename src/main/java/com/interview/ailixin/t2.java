package com.interview.ailixin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t2 {
    public static void main(String[] args) {
        int[] A = {3,8,2,3,3,2};
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        int[] record = new int[max + 1];

        for (int i = 0; i < A.length; i++) {
            record[A[i]]++;
        }

        for (int i = max; i > 0; i--) {
            if (record[i] == i) {
                return i;
            }
        }
        return 0;
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (record.containsKey(A[i])) {
                int num = record.get(A[i]);
                record.put(A[i], num+1);
            }
        }

        Iterator map1it=record.entrySet().iterator();
        while(map1it.hasNext())
        {
            Map.Entry<String, String> entry=(Map.Entry<String, String>) map1it.next();
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
        return 0;
    }

}
