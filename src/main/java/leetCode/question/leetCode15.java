package leetCode.question;

import sun.security.util.Length;

import java.net.Inet4Address;
import java.util.*;

public class leetCode15 {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        // 枚举 a
//        for (int first = 0; first < n; ++first) {
//            // 需要和上一次枚举的数不相同
//            if (first > 0 && nums[first] == nums[first - 1]) {
//                continue;
//            }
//            // c 对应的指针初始指向数组的最右端
//            int third = n - 1;
//            int target = -nums[first];
//            // 枚举 b
//            for (int second = first + 1; second < n; ++second) {
//                // 需要和上一次枚举的数不相同
//                if (second > first + 1 && nums[second] == nums[second - 1]) {
//                    continue;
//                }
//                // 需要保证 b 的指针在 c 的指针的左侧
//                while (second < third && nums[second] + nums[third] > target) {
//                    --third;
//                }
//                // 如果指针重合，随着 b 后续的增加
//                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
//                if (second == third) {
//                    break;
//                }
//                if (nums[second] + nums[third] == target) {
//                    List<Integer> list = new ArrayList<Integer>();
//                    list.add(nums[first]);
//                    list.add(nums[second]);
//                    list.add(nums[third]);
//                    ans.add(list);
//                }
//            }
//        }
//        return ans;
//    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i > 0  && nums[i] == nums[i-1]){
                continue;
            }

            int l = i+1;
            int r = nums.length -1;
            int target = -nums[i];
            while (l < r){
                int sum = nums[l] + nums[r];
                if (sum == target){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while (l<r && nums[l] == nums[l-1]) l++;
                    while (l<r && nums[r] == nums[r+1]) r--;
                }else if (sum < target){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
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
