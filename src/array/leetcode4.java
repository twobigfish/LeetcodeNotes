package array;

/**
 * @author: Dayuu
 * @description: 4. 寻找两个正序数组的中位数
 */
public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;  // 当len为偶数时，需要中间两个值计算
        int start1 = 0, start2 = 0; // 表示当前指向nums1和nums2的位置
        for (int i = 0; i <= len / 2; i++) {
            left = right; // left保存right的上一个元素
            // 如果 start1没有超过边界，且nums1的当前元素小于nums2的当前元素 或者 start2已经超过边界
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else { // 否则移动 start2
                right = nums2[start2++];
            }
        }

        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
