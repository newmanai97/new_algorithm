package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        res.add(node.val);
        preorder(node.left,res);
        preorder(node.right, res);
    }
}
