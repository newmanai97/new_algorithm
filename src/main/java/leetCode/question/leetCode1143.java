package leetCode.question;

public class leetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int res = 0;
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return res;
    }

}
