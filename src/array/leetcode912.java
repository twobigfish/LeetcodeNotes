package array;

import java.util.Random;

/**
 * @author: Dayuu
 * @description: 912. 排序数组 补充题4. 手撕快速排序
 */
// https://leetcode.cn/problems/sort-an-array/solutions/178305/pai-xu-shu-zu-by-leetcode-solution/
class Solution {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r); // pos是分界值的下标
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个下标作为分界值
        swap(nums, r, i); // 将分界值的下标放到区间末尾
        return partition(nums, l, r);
    }

    // 划分函数
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r]; // 分界值
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] < pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r); // 把分界值放到中间的位置
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


