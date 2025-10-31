package leetCode.question;

public class leetCode53 {
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];
            if (count > res ){
                res = count;
            }
            if (count <= 0){
                count = 0;
            }
        }
        return res;
    }

    public int maxSubArray(int[] nums) {

        int[] dp =  new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i] > res){
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetCode53 leetCode53 = new leetCode53();
        System.out.println(leetCode53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
