package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode93 {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12)return res;
        backtracking(s, 0, 0);
        return res;
    }

    public void backtracking(String s,  int startIndex, int pointNum){
        if (pointNum == 3){
            if (isvalid(s, startIndex, s.length()-1)){
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++){
            if (isvalid(s, startIndex, i)){
                s =s.substring(0, i+1)+'.'+s.substring(i+1);
                pointNum++;
                backtracking(s, i+1, pointNum);
                pointNum--;
                s = s.substring(0, i+1)+s.substring(i+2);
            }else {
                break;
            }
        }

    }


    public boolean isvalid(String s, int start, int end){
        if (start > end){
            return false;
        }

        if (s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;

        for (int i = start; i<=end; i++){
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        return true;
    }


}
