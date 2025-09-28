package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        connectlevel(root, list, 0);
        for (Node node : list) {
            node.next = null;
        }
        return root;
    }

    public static void connectlevel(Node node, List<Node> list, int depth){
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
