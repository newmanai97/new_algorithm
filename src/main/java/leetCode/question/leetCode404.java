package leetCode.question;

public class leetCode404 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRecursion(root, false);
    }

    public int sumOfLeftLeavesRecursion(TreeNode node, boolean isleft) {
        if (node == null){
            return 0;
        }

        if (isleft && node.left == null && node.right == null){
            return node.val;
        }
        int leftsum = sumOfLeftLeavesRecursion(node.left, true);
        int rightsum = sumOfLeftLeavesRecursion(node.right, false);
        return leftsum+rightsum;
    }
}
