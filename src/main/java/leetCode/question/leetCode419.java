package leetCode.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class leetCode419 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        trackbacking(nums,0);
        return res;
    }

    public void trackbacking(int[] nums, int startIndex){
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        if (startIndex > nums.length){
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++){
            if (!path.isEmpty()&& path.getLast()>nums[i] || hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            trackbacking(nums, i+1);
            path.removeLast();
        }
    }

}
