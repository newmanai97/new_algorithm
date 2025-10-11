package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetCode97 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            res.add(new ArrayList<>(path));
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[]nums, int start){
        res.add(new ArrayList<>(path));
        if (start >= nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i+1);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        leetCode97 so = new leetCode97();
        so.subsetsWithDup(new int[]{1,2,2});
    }
}
