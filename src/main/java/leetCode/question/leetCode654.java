package leetCode.question;

public class leetCode654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return dfs(nums, 0, nums.length-1);
    }

    public static TreeNode dfs(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }

        int max = nums[start];
        int index = start;
        int i = start;
        while (i <= end){
            if (nums[i] > max){
                index = i;
                max = nums[i];
            }
            i++;
        }

        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, start, index-1);
        root.right = dfs(nums, index+1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println("hello");
    }

}
