package array;

/**
 * @author dayuu
 * @create 2023/4/29 21:20
 */
public class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0; // 起始位置
        int sum = 0; // 滑动窗口数值之和
        int result = Integer.MAX_VALUE; // 滑动窗口的长度
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start++]; // 从起始位置开始递减，寻找符合条件的最小长度
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
