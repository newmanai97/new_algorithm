package leetCode.question;

public class leetCode701 {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = dfs(root,val);
        if(node == null){
            return new TreeNode(val);
        }
        if (node.val > val){
            node.left = new TreeNode(val);
        }else {
            node.right = new TreeNode(val);
        }
        return root;
    }

    public TreeNode dfs(TreeNode node, int val) {
        if (node == null){
            return node;
        }

        if (node.val > val){
            if (node.left == null){
                return node;
            }else {
                return dfs(node.left,val);
            }
        }

        if (node.val < val){
            if (node.right == null){
                return node;
            }else {
                return dfs(node.right, val);
            }
        }
        return node;
    }
}
