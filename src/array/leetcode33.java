package array;

/**
 * @author: Dayuu
 * @description: 33. 搜索旋转排序数组
 */
public class leetcode33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 前一半是有序的（也存在5671234，两边都是有序的情况，但是不影响查找结果）
            //注意此处用小于等于，因为会出现只剩一个元素的情况
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {  // targrt和nums[mid]已经比较过了是否相等，只需要比较nums[start]、nums[end]和target的关系，所以这里是 >=
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {  // targrt和nums[mid]已经比较过了是否相等，只需要比较nums[start]、nums[end]和target的关系，所以这里是 <=
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
