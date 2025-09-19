package leetCode.question;

public class leetCode704 {

    public static int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int mid = 0;
        int left = 0, right = nums.length-1;
        while (left <= right){
            mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]>target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int result = search(arr,target);
        System.out.println("result is "+result);

    }
}
