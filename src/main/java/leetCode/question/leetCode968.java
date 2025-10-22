package leetCode.question;

public class leetCode968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (min(root) == 0){
            res++;
        }
        return res;
    }

    public int min(TreeNode node){
        if (node == null) return 2;

        int left = min(node.left);
        int right = min(node.right);

        if (left == 2 && right == 2) {
            return 0;
        }else if (left == 0 || right == 0) {
            res++;
            return 1;
        }else {
            return 2;
        }
    }
}
