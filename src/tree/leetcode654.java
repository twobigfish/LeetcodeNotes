package tree;

/**
 * @author: Dayuu
 * @description: 最大二叉树
 */
public class leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    TreeNode construct(int[] nums, int start, int end) {
        // 1.终止条件
        if (end - start < 1) { // 没有元素
            return null;
        }
        if (end - start == 1) { // 只有一个元素，直接作为叶子节点返回
            return new TreeNode(nums[start]);
        }
        // 2.单次递归逻辑
        int maxnum = nums[start];
        int maxindex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > maxnum) {
                maxnum = nums[i];
                maxindex = i;
            }
        }
        TreeNode root = new TreeNode(maxnum);
        // 根据maxIndex划分左右子树 左开右闭
        root.left = construct(nums, start, maxindex);
        root.right = construct(nums, maxindex + 1, end);
        // 3.返回值
        return root;
    }
}
