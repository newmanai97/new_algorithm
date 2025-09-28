package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode117 {
    class Node {
        public int val;
        public leetCode116.Node left;
        public leetCode116.Node right;
        public leetCode116.Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, leetCode116.Node _left, leetCode116.Node _right, leetCode116.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public leetCode116.Node connect(leetCode116.Node root) {
        List<leetCode116.Node> list = new ArrayList<>();
        connectlevel(root, list, 0);
        for (leetCode116.Node node : list) {
            node.next = null;
        }
        return root;
    }

    public static void connectlevel(leetCode116.Node node, List<leetCode116.Node> list, int depth){
        if (node == null){
            return;
        }

        if (list.size() == depth){
            list.add(node);
        }else {
            list.get(depth).next = node;
            list.set(depth, node);
        }
        connectlevel(node.left, list, depth+1);
        connectlevel(node.right, list, depth+1);
    }
}
