package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode101 {
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

    public boolean isSymmetric(TreeNode root) {
        return checkIsSymmetricRecursion(root.left, root.right);
    }

    public boolean checkIsSymmetricRecursion(TreeNode leftnode, TreeNode rightnode) {
        if (leftnode == null && rightnode == null){
            return true;
        }

        if (leftnode == null || rightnode == null){
            return false;
        }
        return leftnode.val == rightnode.val && checkIsSymmetricRecursion(leftnode.left, rightnode.right) && checkIsSymmetricRecursion(leftnode.right, rightnode.left);
    }
}
