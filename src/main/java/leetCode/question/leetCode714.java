package leetCode.question;

public class leetCode714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;

        int[]dp = new int[2];
        dp[0] = -prices[0]-2;
        dp[1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1]-prices[i]-2);

            dp[1] = Math.max(dp[1], dp[0]+prices[i]);
        }
        return Math.max(dp[0], dp[1]);
    }
}
