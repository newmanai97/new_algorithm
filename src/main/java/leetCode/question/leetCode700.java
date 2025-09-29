package leetCode.question;

public class leetCode700 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        while (root != null){
            if (root.val == val){
                return root;
            }else if (root.val > val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return null;
    }
}
