package leetCode.question;

import java.util.Arrays;

public class leetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        if( nums == null || nums.length < 2){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
