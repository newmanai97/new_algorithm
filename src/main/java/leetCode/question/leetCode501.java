package leetCode.question;

import java.util.*;

public class leetCode501 {
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

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        dfs(root);

        int maxtime = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxtime && res.size() >= 0){
                res = new ArrayList<>();
                res.add(key);
                maxtime = map.get(key);
            }else if (map.get(key) == maxtime){
                res.add(key);
            }
        }
        return  res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode node){
        if (node == null){
            return;
        }

        int num = map.getOrDefault(node.val, 0);
        map.put(node.val, num+1);
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        leetCode501 q = new leetCode501();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);

        node1.right = node2;
        node2.left = node3;

        q.findMode(node1);

    }
}
