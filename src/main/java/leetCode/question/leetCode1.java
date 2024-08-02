package leetCode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leetCode1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])){
                return new int[]{resultMap.get(target - nums[i]), i};
            }else resultMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] ints = twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
