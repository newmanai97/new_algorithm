package leetCode.question;

import java.util.*;
import java.util.stream.Collectors;

public class leetCode39 {

    Set<List<Integer>> res = new HashSet<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target);
        return  new ArrayList<>(res);
    }

    public void backtracking(int[] candidates, int sum){
        if (sum < 0){
            return;
        }
        if (sum == 0){
            LinkedList<Integer> pathSort = path.stream()
                    .sorted()
                    .collect(Collectors.toCollection(LinkedList::new));
            res.add(new ArrayList<>(pathSort));
            return;
        }

        for (int i = 0; i < candidates.length; i++){
            path.add(candidates[i]);
            sum = sum - candidates[i];
            backtracking(candidates, sum);
            sum = sum + candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        leetCode39 so = new leetCode39();
        so.combinationSum(new int[]{2,3,5}, 8);
    }
}
