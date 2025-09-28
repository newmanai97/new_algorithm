package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewLevel(root, res, 0);
        return res;
    }

    public static void rightSideViewLevel(TreeNode node, List<Integer> list, int depth){
        if (node == null){
            return;
        }

        if (list.size() == depth){
            list.add(node.val);
        }else {
            list.set(depth, node.val);
        }

        rightSideViewLevel(node.left, list, depth+1);
        rightSideViewLevel(node.right, list, depth+1);
    }
}
