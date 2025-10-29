package leetCode.question;

import java.util.Arrays;

public class leetCode123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[]dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+ prices[i-1]);
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+prices[i-1]);
        }
        return dp[3];
    }
}
