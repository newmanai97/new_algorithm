package leetCode.question;

public class leetcode27 {
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right){
            if (nums[left] == val){
                nums[left] = nums[right - 1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums = new int []{0,1,2,2,3,0,4,2};
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, 2);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
