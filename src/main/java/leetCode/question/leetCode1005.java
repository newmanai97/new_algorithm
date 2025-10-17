package leetCode.question;

import java.util.Arrays;

public class leetCode1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 0){
            return 0;
        }
        if (k == 0){
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k >0){
                nums[i] =  -nums[i];
                k--;
            }else {
                k = k % 2;
                break;
            }
        }
        Arrays.sort(nums);
        if (k != 0 && k % 2 != 0){
            nums[0] = - nums[0];
        }
        return Arrays.stream(nums).sum();
    }
}
