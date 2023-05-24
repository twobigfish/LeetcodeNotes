package tree;

/**
 * @author: Dayuu
 * @description: 将有序数组转换为二叉搜索树
 */
public class leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    TreeNode buildBST(int[] nums, int left, int right) {
        // 终止条件
        // 左闭右闭区间[left, right]
        if (left > right) return null;

        // 单层逻辑
        //int mid = (left + right) / 2; // 如果left和right都取最大int值，则溢出。（同二分法）
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
