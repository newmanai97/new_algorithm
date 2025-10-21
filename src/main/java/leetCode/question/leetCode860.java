package leetCode.question;

import java.util.HashMap;
import java.util.Map;

public class leetCode860 {

    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;

        for(int bill:bills){
            if (bill==5){
                five++;
            }else if (bill==10){
                if (five<=0) return false;
                five--;
                ten++;
            }else if (bill==20){
                if (five > 0 && ten>0){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five = five - 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if(bill == 5){
                map.put(bill, map.getOrDefault(bill, 0) + 1);
                continue;
            }else if (bill == 10){
                map.put(bill, map.getOrDefault(bill, 0) + 1);
                int num = map.getOrDefault(5, 0);
                if (num > 0){
                    map.put(5, num - 1);
                }else {
                    return false;
                }
            } else if (bill == 20){
                map.put(bill, map.getOrDefault(bill, 0) + 1);
                int num1 = map.getOrDefault(10, 0);
                int num2 = map.getOrDefault(5, 0);
                if (num1 * 10 + num2 * 5 < 20){
                    return false;
                }else if (num1 >= 1 && num2 >= 1){
                    map.put(10, num1 -1);
                    map.put(5, num2 - 1);
                    continue;
                }else if (num2 >= 3){
                    map.put(5, num2 - 3);
                    continue;
                }else {
                    return false;
                }
            }

        }
        return true;
    }
}
