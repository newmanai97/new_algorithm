package leetCode.question;

import java.util.Stack;

public class leetCode1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        for (char c : sCharArray){
            if (stack.empty() || stack.peek() != c){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        return stack.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

}
