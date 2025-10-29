package leetCode.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[]dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j =0; j < i && !dp[i];  j++) {
                if (set.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        leetCode139 so = new leetCode139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        so.wordBreak("leetcode", list);
    }
}
