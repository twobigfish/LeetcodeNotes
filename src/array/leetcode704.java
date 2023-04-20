package array;

/**
 * @author dayuu
 * @create 2023/4/20 10:26
 */
public class leetcode704 {
    public int search1(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
//            << : 左移运算符(低位补0)，num << 1,相当于num乘以2
//            >> : 右移运算符(若符号为正，则在高位插入0；若符号为负，则在高位插入1)，num >> 1,相当于num除以2
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
//            int mid = (left + right) >> 1;  不推荐，left+right可能会溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}
