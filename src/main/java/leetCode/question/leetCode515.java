package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestValuesLevel(root, res, 0);
        return res;
    }

    public static void largestValuesLevel(TreeNode node, List<Integer> list, int depth){
        if (node == null){
            return;
        }

        if (list.size() == depth){
            list.add(node.val);
        }else {
            if (list.get(depth) < node.val){
                list.set(depth, node.val);
            }
        }
        largestValuesLevel(node.left, list, depth+1);
        largestValuesLevel(node.right, list, depth+1);
    }

}
