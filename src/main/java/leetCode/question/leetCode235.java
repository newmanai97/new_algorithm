package leetCode.question;

public class leetCode235 {

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
        if (node == null){
            return node;
        }

        if (node.val > p.val && node.val > q.val){
            TreeNode left = dfs(node.left, p, q);
            if (left != null){
                return left;
            }
        }

        if (node.val < p.val && node.val < q.val){
            TreeNode right = dfs(node.right, p, q);
            if (right != null){
                return right;
            }
        }

        return node;
    }
}
