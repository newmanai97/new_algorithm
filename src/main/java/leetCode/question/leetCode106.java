package leetCode.question;

import java.util.HashMap;
import java.util.Map;

public class leetCode106 {
    public class TreeNode {
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

    private int[]inorder;
    private int[]postorder;
    private int rootindex;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        rootindex = postorder.length-1;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length-1);
    }

    public TreeNode dfs(int start, int end){
        if (start > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootindex]);

        int index = map.get(postorder[rootindex]);
        rootindex--;
        root.right = dfs(index+1, end);
        root.left = dfs(start, index-1);
        return root;
    }

}
