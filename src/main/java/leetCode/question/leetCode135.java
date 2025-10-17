package leetCode.question;

import java.util.Arrays;

public class leetCode135 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] cadies =new int[len];
        Arrays.fill(cadies,1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                cadies[i] = cadies[i-1] + 1;
            }
        }

        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                cadies[i] = Math.max(cadies[i], cadies[i+1] + 1);
            }
        }
        return Arrays.stream(cadies).sum();
    }
}
