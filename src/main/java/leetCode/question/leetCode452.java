package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;

public class leetCode452 {
    public int findMinArrowShots(int[][] points) {
        int count = 1;
        Arrays.sort(points, (a,b) -> {
            return Integer.compare(a[0] ,b[0]);
        });

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            }else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
