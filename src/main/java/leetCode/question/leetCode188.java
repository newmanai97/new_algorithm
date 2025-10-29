package leetCode.question;

public class leetCode188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int length = k*2;
        int[]dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) dp[i] = -prices[0];
            else dp[i] = 0;
        }

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j < length; j++) {
                if (j % 2 == 0){
                    if (j >=2){
                        dp[j] = Math.max(dp[j-1]-prices[i-1], dp[j]);
                    }else {
                        dp[j] = Math.max(dp[j], -prices[i-1]);
                    }
                }else {
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[i-1]);
                }
            }
        }
        return dp[length-1];
    }
}
