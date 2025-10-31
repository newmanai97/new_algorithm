package leetCode.question;

public class leetCode516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 1) return s.length();
        char[] arr = s.toCharArray();
        int lenth = arr.length;
        int[][] dp = new int[lenth][lenth];
        for (int i = 0; i < lenth; i++) dp[i][i] = 1;

        int res = 0;
        for (int i = lenth-1; i >= 0; i--) {
            for (int j = i+1; j < lenth; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
