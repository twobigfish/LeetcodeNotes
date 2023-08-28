package array;

import java.util.Arrays;

/**
 * @author: Dayuu
 * @description: 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/solutions/577321/miao-dong-xi-lie-100-cong-xia-yi-ge-pai-gog8j/
 */
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length, k = n - 1;
        // 1.从后往前找，找到第一个下降的位置，记为 k，k右边的数值是降序的
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) {
            k--;
        }
        if (k == 0) {
            reverse(nums, 0, n - 1);
        } else {
            int tmp = k;
            while (tmp + 1 < n && nums[tmp + 1] > nums[k - 1]) {
                tmp++;
            }
            swap(nums, k - 1, tmp);
            reverse(nums, k, n - 1);
        }
    }

    void reverse(int[] nums, int i, int j) {
        int left = i, right = j;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
