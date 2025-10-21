package leetCode.question;

import java.util.LinkedList;
import java.util.List;

public class leetCode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<Integer>();
        int[] farIndex = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            farIndex[charArray[i] - 'a'] = i;
        }

        int index = 0;
        int last = -1;
        for (int i = 0; i < charArray.length; i++) {
            index = Math.max(index, farIndex[charArray[i] - 'a']);
            if (index == i){
                res.add(i-last);
                last = i;
            }
        }
        return res;
    }
}
