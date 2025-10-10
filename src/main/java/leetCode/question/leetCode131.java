package leetCode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int index){
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
            }else {
                continue;
            }
            backtracking(s, i+1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; i <= j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        leetCode131 so = new leetCode131();
        so.partition("aab");
    }
}
