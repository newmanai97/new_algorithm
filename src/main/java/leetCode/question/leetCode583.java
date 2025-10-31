package leetCode.question;

public class leetCode583 {

    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int res = 0;
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return arr1.length-res + arr2.length-res;
    }
}
