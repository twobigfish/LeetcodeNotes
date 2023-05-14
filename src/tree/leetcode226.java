package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dayuu
 * @create 2023/5/14 19:54
 */
public class leetcode226 {
    // 法1 DFS递归 前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {  // 递归停止条件
            return null;
//            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapNode(root);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
//                swapNode(node); 先交换和后交换都可以
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                swapNode(node);
                len--;
            }

        }
        return root;
    }

    void swapNode(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
