package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        postorder(node.left,res);
        postorder(node.right, res);
        res.add(node.val);
    }
}
