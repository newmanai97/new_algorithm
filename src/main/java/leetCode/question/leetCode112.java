package leetCode.question;

public class leetCode112 {
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return dfs(root, targetSum);
    }

    public static boolean dfs(TreeNode node, int targetSum) {
        if (node == null){
            return false;
        }
        targetSum = targetSum - node.val;
        if (node.left == null && node.right == null && targetSum == 0){
            return true;
        }
        boolean left = dfs(node.left, targetSum);
        boolean right = dfs(node.right, targetSum);
        return left||right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(hasPathSum(node1,1));
    }

}
