package leetCode.question;

public class leetCode647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 1) return s.length();

        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (arr[i] == arr[j]) {
                    if (j-i <= 1){
                        count++;
                        dp[i][j] = true;
                    }else {
                        if (dp[i+1][j-1]) {
                            count++;
                            dp[i][j] = true;
                        }
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }
}
