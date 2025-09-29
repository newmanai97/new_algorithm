package leetCode.question;

public class leetCode222 {
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

    public int countNodes(TreeNode root) {
        return countNodesRecursion(root);
    }

    public int countNodesRecursion(TreeNode node) {
        if (node == null ){
            return 0;
        }
        int nodeNum = 1;
        if (node.left != null){
            nodeNum += countNodesRecursion(node.left);
        }
        if (node.right != null){
            nodeNum += countNodesRecursion(node.right);
        }
        return nodeNum;
    }
}
