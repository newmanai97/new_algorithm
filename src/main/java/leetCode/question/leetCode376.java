package leetCode.question;

public class leetCode376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        int prediff = 0;
        int currdiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            currdiff = nums[i] - nums[i-1];

            if ((prediff >= 0 && currdiff < 0) || (prediff <= 0 && currdiff > 0)){
                count++;
                prediff = currdiff;
            }
        }
        return count;
    }

}
