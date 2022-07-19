package com.base.leetcode.swordoffer;


import java.util.Arrays;

public class PaintHouse_091 {
    public int minCost1(int[][] costs) {

        // 第i个房子涂j颜色时最小总价
        int[][] dp = new int[costs.length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        if (costs.length == 1) {
            return dp[0][0] <= dp[0][1] ? Math.min(dp[0][0], dp[0][2]) : Math.min(dp[0][1], dp[0][2]);
        }

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + costs[i][2];
        }
        return dp[costs.length-1][0] <= dp[costs.length-1][1] ? Math.min(dp[costs.length-1][0], dp[costs.length-1][2]) : Math.min(dp[costs.length-1][1], dp[costs.length-1][2]);
    }

    public int minCost2(int[][] costs) {
        // 各颜色当前最低总价
        int[] cost = new int[3];

        System.arraycopy(costs[0], 0, cost, 0, 3);

        for (int i = 1; i < costs.length; i++) {
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                temp[j] = Math.min(cost[j%3+1], cost[j%3+2]) + costs[i][j];
            }
            cost = temp;
        }

        return Arrays.stream(cost).min().getAsInt();
    }
}
