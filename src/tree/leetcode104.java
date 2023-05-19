package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Dayuu
 * @description:二叉树的最大深度
 */
public class leetcode104 {
    // 法1 递归法 后序遍历
    // 因为代码的逻辑其实是求的根节点的高度，而根节点的高度就是这棵树的最大深度，所以才可以使用后序遍历。
    // 这个法1本质上是求根节点的最大高度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left); // 左
        int rightDepth = maxDepth(root.right); // 右
        int depth = Math.max(leftDepth, rightDepth) + 1; // 中 左右深度的最大值+1（1是中间节点）
        return depth;
    }

    //法2 迭代 层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len > 0) {
                root = queue.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                len--;
            }
        }
        return depth;
    }
}
