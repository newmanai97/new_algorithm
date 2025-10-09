package leetCode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1,n,k);
        return res;
    }

    public void backtracking(int m, int n, int k){
        if (n < 0){
            return;
        }
        if (path.size() == k && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = m; i <= 9; i++){
            path.add(i);
            backtracking(i+1, n-i, k);
            path.removeLast();
        }
    }

}
