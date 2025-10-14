package leetCode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode46 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        trackbacking(nums,new boolean[nums.length]);
        return res;
    }

    public void trackbacking(int[] nums,boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                trackbacking(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
