package tree;

/**
 * @author: Dayuu
 * @description: 平衡二叉树
 * 求高度和深度是不一样的
 */
public class leetcode110 {
    // 递归 后序遍历
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    // 1.明确递归函数的参数和返回值
    public int getHeight(TreeNode root) {
        // 2.明确终止条件
        // 递归的过程中依然是遇到空节点了为终止，返回0，表示当前节点为根节点的树高度为0
        if (root == null) {
            return 0;
        }
        // 3.明确单层递归的逻辑
        int leftHeight = getHeight(root.left); // 左
        int rightHeight = getHeight(root.right); // 右

        if (leftHeight == -1) {
            return -1;
        }

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1; // 中，左右高度最大值+1（加上中间节点自身）
        }
    }
}
