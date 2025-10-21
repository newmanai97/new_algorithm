package leetCode.question;

import java.util.Arrays;

public class leetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[1] ,b[1]);
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                intervals[i][1] = intervals[i - 1][1];
                intervals[i][0] = intervals[i - 1][0];
                continue;
            }else {
                count++;
            }
        }
        return count;
    }
}
