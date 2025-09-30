package leetCode.question;

public class leetCode236 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == p || node == q || node == null){
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if (left != null && right != null) return node;
        if (left == null) return  right;
        else return left;
    }
}
