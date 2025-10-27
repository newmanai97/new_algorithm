package leetCode.question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetCode416 {

    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public boolean canPartition1(int[] nums) {
        int numSum = Arrays.stream(nums).sum();
        if (numSum % 2 == 1) return false;

        int res =  numSum / 2;
        return backtracking(nums, 0, res);
    }

    public boolean backtracking(int[] nums, int k, int target) {
        if (sum == target) return true;

        if (k >= nums.length) return false;

        for (int i = k; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            if (backtracking(nums, i+1, target)) return true;
            sum -= nums[i];
            path.removeLast();
        }
        return false;
    }


    public boolean canPartition(int[] nums) {
        int numSum = Arrays.stream(nums).sum();
        if (numSum % 2 == 1) return false;

        int res =  numSum / 2;
        boolean[][]dp = new boolean[nums.length][res+1];
        if (nums[0] < res){
            dp[0][nums[0]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= res;  j++) {
                dp[i][j] = dp[i-1][j];

                if (nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }else if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][res];
    }

    public boolean canPartition3(int[] nums) {
        int numSum = Arrays.stream(nums).sum();
        if (numSum % 2 == 1) return false;

        int res =  numSum / 2;
        boolean[]dp = new boolean[res+1];

        if (nums[0] < res){
            dp[nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = res; j >= nums[i]; j--) {
                if (nums[i] == j){
                    dp[j] = true;
                    continue;
                }else if (nums[i] < j){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }
        return dp[res];
    }
}
