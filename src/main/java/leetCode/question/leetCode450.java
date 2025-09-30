package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        return findDeleteNode(root, key);
    }

    public TreeNode findDeleteNode(TreeNode node, int key){
        if (node == null){
            return node;
        }
        if (node.val == key){
            List<Integer> deleteList = new ArrayList<>();
            inorder(node, deleteList);
            deleteList.remove(Integer.valueOf(node.val));
            TreeNode newNode = buildTree(deleteList.stream().mapToInt(Integer::intValue).toArray(), 0, deleteList.size()
            -1);
            return newNode;
        }else if (node.val > key){
            node.left = findDeleteNode(node.left, key);
        }else {
            node.right =  findDeleteNode(node.right, key);
        }
        return node;
    }

    public void inorder(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right, res);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }

        int index = (left + right)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, left, index -1);
        root.right = buildTree(nums, index +1, right);
        return root;
    }

}
