package leetCode.question;

public class leetCode108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }

        int index = (left + right)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, left, index -1);
        root.right = dfs(nums, index +1, right);
        return root;
    }
}
