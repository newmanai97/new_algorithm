package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode98 {
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

//    public boolean isValidBST(TreeNode root) {
//       List<Integer> res = new ArrayList<>();
//       preorder(root,res);
//       if (res.size() == 0){
//           return false;
//       }
//       if (res.size() == 1){
//           return true;
//       }
//       for (int i = 0, j=1; j < res.size(); i++, j++){
//           if (res.get(i) >= res.get(j)){
//               return false;
//           }
//       }
//       return true;
//    }
//
//    public static void preorder(TreeNode node, List<Integer> res){
//        if (node == null){
//            return;
//        }
//        res.add(node.val);
//        preorder(node.left,res);
//        preorder(node.right, res);
//    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long low, long up) {
        if (node == null){
            return true;
        }

        if (node.val <= low || node.val >= up){
            return false;
        }

        return dfs(node.left, low, node.val) && dfs(node.right, node.val, up);
    }
}
