package leetCode.question;

import java.util.*;

public class leetCode47 {
    private HashSet<List<Integer>> res = new HashSet<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        trackbacking(nums, new boolean[nums.length]);
        return new ArrayList<>(res);
    }

    public void trackbacking(int[] nums,boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
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
