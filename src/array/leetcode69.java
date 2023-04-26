package array;

/**
 * @author dayuu
 * @create 2023/4/26 17:12
 */
public class leetcode69 {
    /**
     * 因为存在平方运算，使用int可能会溢出，所以使用long类型
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 定义左右边界
        long left = 0, right = x;
        // 当左边界小于等于右边界执行循环
        while (left <= right) {
            // 定义中点
            long mid = left + ((right - left) >> 1);
            // 中点值平方小于x，缩小范围至右区间
            if (mid * mid < x) {
                // 左边界更新为中点的右边元素
                left = mid + 1;
                // 中点值平方大于x，缩小范围至左区间
            } else if (mid * mid > x) {
                // 中点值平方大于x，缩小范围至左区间
                right = mid - 1;
                // 中点值平方等于x，即mid为x的平方根
            } else if (mid * mid == x) {
                return (int) mid;
            }
        }
        // 如果左边界平方大于x而右边界平方小于x，即右边界值符合条件
        if (right * right < x && left * left > x) {
            return (int) right;
        }
        return -1;
    }
}
