package leetCode.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class leetCode530 {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public int getMinimumDifference(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preorder(root, res);
//        int num = Integer.MAX_VALUE;
//        if (res.size() > 1){
//            for (int i=0, j=1; j < res.size(); i++,j++){
//                if (num > res.get(j) - res.get(i)){
//                    num = res.get(j) - res.get(i);
//                }
//            }
//        }
//        return num;
//    }
//
//
//    public static void preorder(TreeNode node, List<Integer> res){
//        if (node == null){
//            return;
//        }
//        preorder(node.left,res);
//        res.add(node.val);
//        preorder(node.right, res);
//    }

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        leetCode530 so = new leetCode530();

    }

}
