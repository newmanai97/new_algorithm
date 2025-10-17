package leetCode.question;

import java.util.Arrays;

public class leetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum = 0;
        int totalsum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            cursum += gas[i] -  cost[i];
            totalsum += gas[i] -  cost[i];
            if (cursum < 0){
                index = i + 1;
                cursum = 0;
            }
        }
        if (totalsum < 0){
            return -1;
        }
        return index;
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i] - cost[i];
            min = Math.min(min,sum);
        }
        if(sum<0) return -1;
        if (min >= 0) return 0;
        for (int i = gas.length-1; i >=0; i--) {
            min = min + gas[i] - cost[i];
            if (min >= 0) return i;
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int begin = 0;
        if (Arrays.equals(gas,cost)){
            return begin;
        }
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] > cost[i]){
                begin = i;
                if (isvalid(gas,cost,begin)) return begin;
            }
        }

        return -1;
    }

    public boolean isvalid(int[] gas, int[] cost, int begin){
        int cur = begin;
        int nextgas = gas[cur];
        int count = 0;
        while (count != gas.length){
            nextgas = nextgas - cost[cur];
            if (nextgas < 0){
                break;
            }
            if (cur != gas.length-1){
                cur++;
            }else {
                cur = 0;
            }
            nextgas = nextgas + gas[cur];
            count++;
        }
        return cur == begin;
    }
}
