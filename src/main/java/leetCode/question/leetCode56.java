package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0] ,b[0]);
        });

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                int[] tmp = new int[]{start,end};
                res.add(tmp);
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        return  res.toArray(new int[res.size()][]);
    }
}
