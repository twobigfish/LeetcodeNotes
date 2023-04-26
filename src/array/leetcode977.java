package array;

/**
 * @author dayuu
 * @create 2023/4/26 20:21
 */
public class leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int len = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int ll = nums[left] * nums[left];
            int rr = nums[right] * nums[right];
            if (ll >= rr) {
                result[len--] = ll;
                left++;
            } else {
                result[len--] = rr;
                right--;
            }
        }
        return result;
    }
}
