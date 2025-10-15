package leetCode.question;

import java.util.Arrays;

public class leetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int starts = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (starts >= 0 && g[i] <= s[starts]) {
                res++;
                starts--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetCode455 so = new leetCode455();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{3};
        so.findContentChildren(g, s);
    }
}
