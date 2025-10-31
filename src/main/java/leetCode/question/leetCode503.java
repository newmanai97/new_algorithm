package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class leetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int lenth = nums.length;
        int[] res = new int[lenth*2];
        Arrays.fill(res, -1);


        List<Integer> list = Stream.concat(
                Arrays.stream(nums).boxed(),
                Arrays.stream(nums).boxed()
        ).collect(Collectors.toList());
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[stack.peek()]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    res[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return Arrays.copyOf(res, lenth);
    }
}
