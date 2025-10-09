package leetCode.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetCode77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1,n,k);
        return res;
    }

    public void backtracking(int m, int n, int k){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = m; i <= n - (k - path.size()) +1; i++){
            path.add(i);
            backtracking(i+1, n, k);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        leetCode77 solution = new leetCode77();
        solution.combine(4,2);
    }
}
