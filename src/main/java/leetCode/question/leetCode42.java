package leetCode.question;

import java.util.Stack;

public class leetCode42 {
    public int trap(int[] height) {
        int lenth = height.length;
        if (lenth <= 2)return 0;
        int[] res = new int[lenth];

        int ans = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < lenth; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left],height[i]) - height[mid];
                        int w = i- left - 1;
                        int area = h * w;
                        if (area > 0) {
                            ans += area;
                        }
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        leetCode42 leetCode42 = new leetCode42();
        System.out.println(leetCode42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
