package leetCode.question;

public class leetCode343 {

    public int integerBreak(int n) {
        if (n <= 1)  return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i- j]));
            }

        }
        return dp[n];
    }
}
