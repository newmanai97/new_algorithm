package leetCode.question;

public class leetCode45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int count = 0;
        int curdis = 0;
        int maxdis = 0;

        for (int i = 0; i < nums.length; i++) {
            maxdis = Math.max(maxdis, i + nums[i]);
            if (maxdis >= nums.length-1){
                count++;
                break;
            }

            if (i == curdis){
                curdis = maxdis;
                count++;
            }
        }
        return count;
    }
}
