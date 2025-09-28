package leetCode.question;

import java.util.ArrayList;
import java.util.List;

public class leetCode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, res, 0);
        return res;
    }

    public static void level(Node node, List<List<Integer>> res, int depth){
        if (node == null){
            return;
        }
        if (res.size() == depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);

        for (int i = 0; i < node.children.size(); i++) {
            level(node.children.get(i), res, depth+1);
        }
    }
}
