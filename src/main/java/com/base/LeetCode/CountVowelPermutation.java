package com.fcd.LeetCode;

public class CountVowelPermutation {
    public int countVowelPermutation(int n) {
        long[] ndp = new long[5];
        long[] dp = new long[5];
        if (n == 1) {
            return 5;
        }

        if (n == 2) {
            return 10;
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 2; i <= n; i++) {
            ndp[0] = (dp[1]+dp[2]+dp[4]) % 1000000007;
            ndp[1] = (dp[0]+dp[2]) % 1000000007;
            ndp[2] = (dp[1]+dp[3]) % 1000000007;
            ndp[3] = (dp[2]) % 1000000007;
            ndp[4] = (dp[2]+dp[3]) % 1000000007;

            dp[0] = ndp[0];
            dp[1] = ndp[1];
            dp[2] = ndp[2];
            dp[3] = ndp[3];
            dp[4] = ndp[4];
        }

        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % 1000000007;
        }
        return (int)ans;
        // return (int)(ndp[0] % 1000000007 + ndp[1] % 1000000007 + ndp[2] % 1000000007 + ndp[3] % 1000000007 + ndp[4] % 1000000007);
    }
}
