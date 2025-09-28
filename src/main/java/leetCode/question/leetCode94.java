package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
