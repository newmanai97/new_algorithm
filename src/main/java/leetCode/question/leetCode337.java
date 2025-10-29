package leetCode.question;

public class leetCode337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int[]dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0,0};

        int[] cur = new int[2];

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        cur[1] = node.val + left[0] + right[0];

        return cur;
    }
}
