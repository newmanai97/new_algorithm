package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePathsRecursion(root, res, "");
        return res;
    }

    public void binaryTreePathsRecursion(TreeNode node, List<String> list, String path) {
        if (node == null){
            return;
        }
        if (path == "") {
            path = path + node.val;
        }else {
            path = path + "->" + node.val;
        }
        if (node.left == null && node.right == null){
            list.add(path);
        }

        binaryTreePathsRecursion(node.left, list, path);
        binaryTreePathsRecursion(node.right, list, path);
    }

}
