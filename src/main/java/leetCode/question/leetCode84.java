package leetCode.question;

import java.util.Stack;

public class leetCode84 {

    public int largestRectangleArea(int[] heights) {

        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < heights.length; i++){
            if (heights[i] > heights[stack.peek()]){
                stack.push(i);
            }else if (heights[i] == heights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int mid = stack.peek();
                    stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left-1;
                    int h = heights[mid];
                    res = Math.max(res,w*h);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
