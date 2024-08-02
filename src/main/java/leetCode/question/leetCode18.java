package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4){
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n - 3; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] + nums[first+1] + nums[first+2] + nums[first+3] > target){
                break;
            }
            if ((long)nums[first] + nums[n -1] + nums[n-2] + nums[n-3] < target){
                continue;
            }
            for (int second = first+1; second < n - 2; ++second){
                if (second > first+1  && nums[second] == nums[second-1] ){
                    continue;
                }
                if (nums[first] + nums[second] + nums[second +1] + nums[second+2] > target){
                    break;
                }
                if (nums[first] + nums[second] + nums[n-1] + nums[n-2] < target){
                    continue;
                }
                int third = second + 1;
                int four = n - 1;
                while (third < four){
                    if (nums[first] + nums[second] + nums[third] + nums[four] < target){
                        third++;
                    }else if (nums[first] + nums[second] + nums[third] + nums[four] > target){
                        four--;
                    }else {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[four]));
                        while (third < four && nums[third]  == nums[third+1]){
                            third++;
                        }
                        third++;
                        while (third < four && nums[four] == nums[four-1]){
                            four--;
                        }
                        four--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = fourSum(nums, 1000000000);
        for (List<Integer> list : lists) {
            System.out.printf("{");
            for (Integer i : list) {
                System.out.printf("%d", i);
                System.out.printf(",");
            }
            System.out.println("}");
        }
    }
}
