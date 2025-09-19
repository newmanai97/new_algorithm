package leetCode.question;

import java.util.Stack;

public class leetCode232 {
    public class MyQueue {
        private Stack<Integer> instack;

        private Stack<Integer> outstack;

        public MyQueue() {
            instack = new Stack<>();
            outstack = new Stack<>();
        }

        public void push(int x) {
            instack.push(x);
        }

        public int pop() {
            if (outstack.empty()){
                while (!instack.empty()){
                    Integer elem = instack.pop();
                    outstack.push(elem);
                }
            }
            if (!outstack.empty()){
                return outstack.pop();
            }
            return 0;
        }

        public int peek() {
            if (outstack.empty()){
                while (!instack.empty()){
                    Integer elem = instack.pop();
                    outstack.push(elem);
                }
            }
            if (!outstack.empty()){
                return outstack.peek();
            }
            return 0;
        }

        public boolean empty() {
            return instack.empty() && outstack.empty();
        }
    }
}
