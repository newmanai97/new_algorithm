package leetCode.question;

import java.util.ArrayList;
import java.util.List;

import static leetCode.question.leetCode102.level;

public class leetCode104{
    public int maxDepth(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, res, 0);
        return res.size();
    }



}
