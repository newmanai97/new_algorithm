package leetCode.question;

public class leetCode309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp1 = dp[0];
            int temp2 = dp[2];

            dp[0] = Math.max(dp[0], Math.max(dp[3]-prices[i], dp[1]-prices[i]));

            dp[1] = Math.max(dp[1], dp[3]);

            dp[2] = temp1+prices[i];

            dp[3] = temp2;
        }
        return Math.max(Math.max(dp[1], dp[2]), dp[3]);
    }
}
