package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class leetCode349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        HashSet<Integer> result = new HashSet<Integer>();
        for (int i : nums2) {
            if (set.contains(i)){
                result.add(i);
            }
        }
        return Arrays.stream(result.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        int[] intersection = intersection(nums1, nums2);
        for (Object o : intersection) {
            System.out.println(o);
        }

    }
}
