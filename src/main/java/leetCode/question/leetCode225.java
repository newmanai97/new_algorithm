package leetCode.question;

import java.util.LinkedList;
import java.util.Queue;

public class leetCode225 {
    class MyStack {
        Queue<Integer> queue;
        Queue<Integer> queueBack;

        public MyStack() {
            queue = new LinkedList<>();
            queueBack = new LinkedList<>();
        }

        public void push(int x) {
            queueBack.offer(x);
            while (!queue.isEmpty()){
                Integer elem = queue.poll();
                queueBack.offer(elem);
            }
            Queue<Integer> temp = queue;
            queue = queueBack;
            queueBack = new LinkedList<>();
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
