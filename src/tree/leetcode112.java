package tree;

/**
 * @author: Dayuu
 * @description: 路径总和
 */
public class leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) { // 回溯隐含在其中 每次递归的targetSum不一致
                return true;
            }
        }

        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)){
                return true;
            }
        }

        return false;
    }
}
