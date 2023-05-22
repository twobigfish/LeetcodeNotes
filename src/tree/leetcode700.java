package tree;

/**
 * @author: Dayuu
 * @description: 二叉搜索树中的搜索
 */
public class leetcode700 {
    // 法1 递归法
    public TreeNode searchBST(TreeNode root, int val) {
        // 如果root为空，或者找到这个数值了，就返回root节点。
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode res;
        if (val < root.val) {
            res = searchBST(root.left, val);
        } else {
            res = searchBST(root.right, val);
        }
        return res; // 返回的就是以这个搜索数值所在的节点。
    }

    // 法2 迭代法
    // 对于二叉搜索树，不需要回溯的过程，因为节点的有序性就帮我们确定了搜索的方向。
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
