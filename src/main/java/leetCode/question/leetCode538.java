package leetCode.question;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

public class leetCode538 {
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

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        int sum = 0;
        for (int i = list.size()-1; i >=0; i--){
            sum = sum + list.get(i).val;
            list.get(i).val = sum;
        }

        return root;
    }

    public void inorder(TreeNode node, List<TreeNode> res){
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node);
        inorder(node.right, res);
    }
}
