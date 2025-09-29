package leetCode.question;

public class leetCode617 {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    public TreeNode dfs (TreeNode root1, TreeNode root2){
        TreeNode node;
        if (root1 != null && root2 != null){
            node = new TreeNode(root1.val + root2.val);
            node.left = dfs(root1.left, root2.left);
            node.right = dfs(root1.right, root2.right);
        }else if (root1 == null && root2 != null){
            node = new TreeNode(root2.val);
            node.left = dfs(null, root2.left);
            node.right = dfs(null, root2.right);
        }else if (root2 == null && root1 != null){
            node = new TreeNode(root1.val);
            node.left = dfs(root1.left, null);
            node.right = dfs(root1.right, null);
        }else {
            return null;
        }
        return node;
    }
}
