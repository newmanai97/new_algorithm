package leetCode.question;

public class leetCode115 {
    public int numDistinct(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 0; i <= arr1.length; i++) dp[i][0] = 1;
        for (int j = 1; j <= arr2.length; j++) dp[0][j] = 0;
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }
}
