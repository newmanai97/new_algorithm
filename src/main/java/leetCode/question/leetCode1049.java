package leetCode.question;

public class leetCode1049 {
    public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int num : stones) {
                sum += num;
            }

            int target = sum / 2;
            int[][] dp = new int[stones.length][target+1];
            for(int j = stones[0]; j <= target; j++) {
                dp[0][j] = stones[0];
            }


            for(int i = 1; i < stones.length; i++){
                for (int j = 1; j <= target; j++) {
                    if (j >= stones[i]) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }

                }
            }
            return dp[stones.length-1][target];
    }
}
