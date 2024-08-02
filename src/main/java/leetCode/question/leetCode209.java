package leetCode.question;

import java.text.Collator;
import java.util.Arrays;
import java.util.stream.Collectors;

public class leetCode209 {
//    public static int minSubArrayLen(int target, int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        int len = 0;
//        for (int i = 0; i < nums.length; i++){
//            sum += nums[i];
//            if (sum >= target){
//                len = i + 1;
//                break;
//            }
//        }
//        if (len == 0){
//            return 0;
//        }
//        int minLen = len;
//        for (int i = 0, j = len-1; j <= nums.length-1 && i < j; ){
//            if (sum >= target){
//                sum -= nums[i];
//                i++;
//                len--;
//                if (len < minLen){
//                    minLen = len;
//                }
//            }else {
//                sum += nums[++j];
//                len++;
//            }
//        }
//
//        return len;
//    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int start = 0, end = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < len){
            sum += nums[end];
            while (sum >= target){
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};

        System.out.println(minSubArrayLen(15, nums));

    }
}
