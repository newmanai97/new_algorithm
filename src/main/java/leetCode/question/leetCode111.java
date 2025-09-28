package leetCode.question;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class leetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return levelMinDepth(root, 1);
    }

    public static int levelMinDepth(TreeNode node, int depth ){
        if (node !=  null && node.left == null && node.right == null){
            return depth;
        }
        int leftdepth = Integer.MAX_VALUE;
        int rightdepth = Integer.MAX_VALUE;
        if (node.left != null){
            leftdepth = levelMinDepth(node.left, depth+1);
        }
        if (node.right != null){
            rightdepth = levelMinDepth(node.right, depth+1);
        }
        return leftdepth <= rightdepth ? leftdepth:rightdepth;
    }
}
