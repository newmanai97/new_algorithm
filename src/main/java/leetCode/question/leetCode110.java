package leetCode.question;

public class leetCode110 {
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

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int res  = Math.abs(isBalancedRecursion(root.left) - isBalancedRecursion(root.right));
        return res<= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int isBalancedRecursion(TreeNode node) {
        if (node == null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }

        int leftdepth = isBalancedRecursion(node.left);
        int rightdepth = isBalancedRecursion(node.right);


        return leftdepth > rightdepth?leftdepth+1:rightdepth+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;
         System.out.println(isBalanced(node1));
    }
}
