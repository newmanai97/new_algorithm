package leetCode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode78 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backttracking(nums,0);
        return res;
    }

    public void backttracking(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if (startIndex > nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backttracking(nums, i+1);
            path.removeLast();
        }
    }
}
