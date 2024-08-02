package leetCode.question;

import java.util.HashMap;
import java.util.Map;

public class leetCode454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for (Integer i : nums1) {
            for (Integer j : nums2) {
                resultMap.put(i + j, resultMap.get(i +j) == null ? 1: resultMap.get(i +j) + 1);
            }
        }
        int ans = 0;
        for (Integer i : nums3) {
            for (Integer j : nums4) {
                Integer value = resultMap.get(-(i + j));
                if (value != null && value > 0){
                    ans += value;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, -1};
        int[] nums2 = new int[]{-1, 1};
        int[] nums3 = new int[]{-1, 1};
        int[] nums4 = new int[]{1, -1};
        int i = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i);


    }


}
