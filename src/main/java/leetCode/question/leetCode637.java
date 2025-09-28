package leetCode.question;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class leetCode637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        level(root, levelList, 0);

        List<Double> res = new ArrayList<>();
        for (List<Integer> list : levelList) {
            BigDecimal sum = new BigDecimal(0d);
            for (Integer i : list) {
                sum = sum.add(new BigDecimal(i));
            }
            BigDecimal b = sum.divide(new BigDecimal(list.size()),5, RoundingMode.HALF_UP);
            res.add(b.doubleValue());
        }
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
