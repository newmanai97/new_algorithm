package leetCode.question;

import java.util.Arrays;

public class leetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int k = n /2;
        dp[0]  = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-i*i]+1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? n : dp[n];
    }
}
