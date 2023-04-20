package array;

/**
 * @author dayuu
 * @create 2023/4/20 11:26
 */
public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // 当low==high，区间[low, high]依然有效
            int mid = (right + left) >> 1;  // 防止溢出
            if (nums[mid] == target) {
                // 1. 目标值等于数组中某一个元素  return mid;
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 2.目标值在数组所有元素之前
        // 3.目标值插入数组中
        // 4.目标值在数组所有元素之后 return right + 1;
        return right + 1;
    }
}
