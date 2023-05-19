package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Dayuu
 * @description: 二叉树的最小深度
 * 叶子节点是指没有子节点的节点，因此求最小深度的return的逻辑和最大深度不同。
 * 如果左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度。
 * 反之，右子树为空，左子树不为空，最小深度是 1 + 左子树的深度。
 * 最后如果左右子树都不为空，返回左右子树深度最小值 + 1 。
 */

public class leetcode111 {
    // 法1 递归 后序遍历
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftmindepth = minDepth(root.left);
        int rightmindepth = minDepth(root.right);
        // 当一个左子树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right != null) {
            return rightmindepth + 1;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if (root.left != null && root.right == null) {
            return leftmindepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftmindepth, rightmindepth) + 1;
    }

    // 法2 迭代 层序遍历 找到第一个左右子树都为空的叶子节点就返回此时的depth
    public int minDepth2(TreeNode root) {
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
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if (root.left == null && root.right == null) {
                    return depth;
                }
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
