package leetCode.question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static leetCode.question.leetCode102.level;

public class leetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, res, 0);
        Collections.reverse(res);
        return res;
    }
}
