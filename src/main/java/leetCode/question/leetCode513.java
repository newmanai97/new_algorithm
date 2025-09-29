package leetCode.question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class leetCode513 {
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

//    public int findBottomLeftValue(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        findBottomLeftValueRecursion(root, res, 0);
//        return res.get(res.size()-1).get(0);
//    }
//
//    public void findBottomLeftValueRecursion(TreeNode node, List<List<Integer>> res, int depth){
//        if (node == null){
//            return;
//        }
//        if (res.size() == depth){
//            res.add(new ArrayList<>());
//        }
//        res.get(depth).add(node.val);
//        findBottomLeftValueRecursion(node.left, res, depth+1);
//        findBottomLeftValueRecursion(node.right, res, depth+1);
//    }

    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.right != null){
                queue.offer(poll.right);
            }

            if (poll.left != null){
                queue.offer(poll.left);
            }

            res = poll.val;
        }
        return res;
    }
}
