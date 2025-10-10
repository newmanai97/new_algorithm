package leetCode.question;

import java.util.*;
import java.util.stream.Collectors;

public class leetCode40 {
    Set<List<Integer>> res = new HashSet<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtracking(candidates, target ,0);
        return  new ArrayList<>(res);
    }

    public void backtracking(int[] candidates, int sum, int index){
        if (index == candidates.length && sum > 0){
            return;
        }
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

        for (int i = index; i < candidates.length; i++){
            sum = sum - candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, sum, i+1);
            path.removeLast();
            sum = sum + candidates[i];
        }
    }
}
