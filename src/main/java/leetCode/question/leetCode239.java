package leetCode.question;

import java.util.Deque;
import java.util.LinkedList;

public class leetCode239 {
    class MonotonicQueue{
        Deque<Integer> queue = new LinkedList<>();

        void poll(Integer val){
            if (!queue.isEmpty() && val == queue.peek()){
                queue.poll();
            }
        }

        void add(Integer val){
            while (!queue.isEmpty() && val > queue.getLast()){
                queue.removeLast();
            }
            queue.add(val);
        }

        int peek(){
            return queue.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }
        int length = nums.length-k+1;
        int[] res = new int[length];

        int num = 0;
        MonotonicQueue queue = new MonotonicQueue();
        for (int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        res[num++] = queue.peek();

        for (int i = k; i<nums.length; i++){
            queue.poll(nums[i-k]);
            queue.add(nums[i]);
            res[num++] = queue.peek();
        }
        return res;
    }

}
