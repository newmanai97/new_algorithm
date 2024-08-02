package leetCode.question;

import java.util.HashSet;

public class leetCode202 {

    public static boolean isHappy(int n) {
        HashSet<Integer> resultSet = new HashSet<>();
        int result = 0;
        while (!resultSet.contains(n)){
            resultSet.add(n);
            result = dealNum(n);
            if (result == 1){
                return true;
            }else {
                n = result;
            }
        }
        return false;
    }

    public static int dealNum(int n){
        if (n < 10){
            return n*n;
        }
        int sum = 0;
        int remainder = 0;
        while (n > 0){
            remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(2);
        System.out.println(happy);
    }
}
