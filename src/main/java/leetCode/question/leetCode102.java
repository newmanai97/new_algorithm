package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, res, 0);
        return res;
    }

    public static void level(TreeNode node, List<List<Integer>> res, int depth){
        if (node == null){
            return;
        }
        if (res.size() == depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        level(node.left, res, depth+1);
        level(node.right, res, depth+1);
    }
}
