package leetCode.question;

import java.util.Stack;

public class leetCode20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        if (sCharArray.length % 2 == 1){
            return false;
        }
        for (char c : sCharArray){
            if (c == '(' || c == '{' || c =='['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char b = stack.pop();
                if ((b == '('&& c == ')') || (b == '{'&& c == '}') || (b == '['&& c == ']')){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(";
        System.out.println(isValid(str));
    }
}
