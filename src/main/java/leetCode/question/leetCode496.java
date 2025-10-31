package leetCode.question;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class leetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int lenth = nums2.length;
        int[] temp = new int[lenth];
        Arrays.fill(temp, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < lenth; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    temp[stack.peek()] = nums2[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }

        Map<Integer, Integer> valueToIndex = IntStream.range(0, nums2.length)
                .boxed()
                .collect(Collectors.toMap(i -> nums2[i], i -> i));

        int[]res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = temp[valueToIndex.get(nums1[i])];
        }

        return res;
    }
}
