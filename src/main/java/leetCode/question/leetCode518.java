package leetCode.question;

public class leetCode518 {

    public int change1(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for (int i = coins[0]; i <= amount; i++){
            dp[0][i] = dp[0][i] + dp[0][i-coins[0]];
        }

        for (int i = 1; i < coins.length; i++){
            for (int j = 1; j <= amount; j++){
                if (j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
