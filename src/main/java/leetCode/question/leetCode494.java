package leetCode.question;

public class leetCode494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum){
            return 0;
        }
        if ((target + sum) % 2 == 1){
            return 0;
        }

        int left = (target + sum)/2;
        int[][]dp = new int[nums.length][left+1];

        if (nums[0] < left){
            dp[0][nums[0]] = 1;
        }

        int numzero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                numzero++;
            }
            dp[i][0] = (int) Math.pow(2, numzero);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= left; j++) {
                if (nums[i] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[nums.length-1][left];
    }
}
