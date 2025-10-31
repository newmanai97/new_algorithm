package leetCode.question;

public class leetCode392 {
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int res = 0;
        int[][] dp = new int[sArray.length+1][tArray.length+1];
        for (int i = 1; i <= sArray.length; i++) {
            for (int j = 1; j <= tArray.length; j++) {
                if(sArray[i-1]==tArray[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res==s.length();
    }
}
