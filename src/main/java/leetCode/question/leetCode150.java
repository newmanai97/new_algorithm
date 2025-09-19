package leetCode.question;

import java.util.Stack;

public class leetCode150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens){
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")){
                stack.push(Integer.valueOf(str));
            }else{
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                switch (str){
                    case "+":
                        stack.push(num1+num2);
                        continue;
                    case "-":
                        stack.push(num2-num1);
                        continue;
                    case "*":
                        stack.push(num1*num2);
                        continue;
                    case "/":
                        stack.push(num2/num1);
                        continue;
                }

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(arr));
    }
}
