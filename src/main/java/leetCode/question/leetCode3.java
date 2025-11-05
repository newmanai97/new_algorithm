package leetCode.question;

import java.util.HashSet;

public class leetCode3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int res = 0;
        while (j < s.length()) {
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                if (set.size() > res) {
                    res = set.size();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetCode3 leetCode3 = new leetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("pwwkew"));
    }
}
