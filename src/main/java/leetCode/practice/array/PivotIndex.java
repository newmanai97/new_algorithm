package leetCode.practice.array;

import java.util.Arrays;

public class PivotIndex {
    public static int solution(int[] nums) {
        int total = Arrays.stream(nums).sum();

        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            if (total == 2 * sum + nums[i]){
                return i;
            }
            else sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int result = PivotIndex.solution(nums);
        System.out.println(result);
    }
}