package leetCode.question;

import java.util.Stack;

public class leetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int lenth = temperatures.length;
        int[] res = new int[lenth];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < lenth; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i -stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
