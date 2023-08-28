package array;

/**
 * @author: Dayuu
 * @description: 88. 合并两个有序数组
 */
public class leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int size = nums1.length - 1;
        int curNum;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                curNum = nums2[j];
                j--;
            } else if (j == -1) {
                curNum = nums1[i];
                i--;
            } else if (nums1[i] >= nums2[j]) {
                curNum = nums1[i];
                i--;
            } else {
                curNum = nums2[j];
                j--;
            }
            nums1[size] = curNum;
            size--;
        }
    }
}
