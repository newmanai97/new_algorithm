package leetCode.question;

import java.util.Arrays;

public class leetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length <=1){
            return nums.length;
        }

        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=1;i<nums.length;i++){
            for(int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        leetCode300 leetCode300 = new leetCode300();
        System.out.println(leetCode300.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
