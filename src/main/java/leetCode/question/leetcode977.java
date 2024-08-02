package leetCode.question;

public class leetcode977 {
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int split = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] <= 0){
                split = i;
            }else break;
        }
        int[] res = new int[len];
        int i = split, j = split+1, n =0;
        while (i >=0 || j < len){
            if (i < 0){
                res[n] = nums[j] * nums[j];
                j++;
            }else if (j >= len){
                res[n] = nums[i] * nums[i];
                i--;
            }else if (nums[i] * nums[i] <= nums[j] * nums[j]){
                res[n] = nums[i] * nums[i];
                i--;
            }else {
                res[n] = nums[j] * nums[j];
                j++;
            }
            ++n;
        }
        return res;
    }

    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j;){
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                result[k] = nums[i] * nums[i];
                k--;
                i++;
            }else {
                result[k] = nums[j] * nums[j];
                k--;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int []{-7,-3,2,3,11};

        nums = sortedSquares2(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
