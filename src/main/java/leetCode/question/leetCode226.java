package leetCode.question;

public class leetCode226 {
    public class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {
        invertTreeRecursion(root);
        return root;
    }

    public static void invertTreeRecursion(TreeNode node){
        if (node == null){
            return;
        }

        if (node.left!=null || node.right!=null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        invertTreeRecursion(node.left);
        invertTreeRecursion(node.right);
    }
}
