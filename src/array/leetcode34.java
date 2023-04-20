package array;

/**
 * @author dayuu
 * @create 2023/4/20 12:02
 */
public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int rightBorder = searchRightRange(nums, target);
        int leftBorder = searchLeftRange(nums, target);

        if (rightBorder == -2 || leftBorder == -2) // target不在数组的范围内
            return new int[]{-1, -1};
        /**
         * 我的写法和代码随想录（计算出来的右边界是不包含target的右边界，左边界同理。）不一致，
         * 我是直接找到target的左右边界。
         */
        // 若 右边界和左边界存在 且 右边界>=左边界，则返回两者的值
        if (rightBorder >= leftBorder)
            return new int[]{leftBorder, rightBorder};
        return new int[]{-1, -1}; // target在数组的范围内，但是不存在target的值
    }

    public int searchRightRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                left = mid + 1; // 增大搜索区间的下界
            } else if (target > nums[mid]) {
                left = mid + 1; // 同一般二分查找的设置
            } else if (target < nums[mid]) {
                right = mid - 1; // 同一般二分查找的设置
            }
            rightBorder = right; // 返回右边界
        }
        return rightBorder;
    }

    public int searchLeftRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                right = mid - 1; // 减小搜索区间的上界
            } else if (target < nums[mid]) {
                right = mid - 1; // 同一般二分查找的设置
            } else if (target > nums[mid]) {
                left = mid + 1; // 同一般二分查找的设置
            }
            leftBorder = left; // 返回左边界
        }
        return leftBorder;
    }
}
