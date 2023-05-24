package tree;

/**
 * @author: Dayuu
 * @description: 修剪二叉搜索树
 */
public class leetcode669 {
    // 法1 递归法
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        // 不符合范围条件
        if (root.val < low) {
            return trimBST(root.right, low, high); // 返回给上一层
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 符合范围条件
        root.left = trimBST(root.left, low, high); // 接入上一层返回的符合条件的左孩子
        root.right = trimBST(root.right, low, high); // 接入上一层返回的符合条件的右孩子
        return root;
    }
}
