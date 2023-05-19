package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Dayuu
 * @description: N叉树的最大深度
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class leetcode559 {
    // 法1 递归
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }
       /*for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }*/
        return depth + 1;
    }

    // 法2 层序遍历
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len > 0) {
                root = queue.poll();
                for (Node node : root.children) {
                    queue.offer(node);
                }
                len--;
            }
        }
        return depth;
    }
}
