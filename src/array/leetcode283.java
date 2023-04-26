package array;

/**
 * @author dayuu
 * @create 2023/4/26 19:14
 */
public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0, fastIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != 0) {
                //                版本1
//                nums[slowIndex] = nums[fastIndex];
//                版本2
                swap(nums, slowIndex, fastIndex);
                // 如果nums[fastIndex]==目标值，则slowIndex会一直指在第一次找到的目标值上，
                // 直到fastIndex找到下一个非目标值。
                slowIndex++;
            }
            fastIndex++;
        }
        //                版本1
//        for (int i = slowIndex; i < nums.length; i++) {
//            nums[i] = 0;
//        }
        System.out.println(nums.toString());
    }

    public void swap(int[] nums, int slowIndex, int fastIndex) {
        int temp = nums[slowIndex];
        nums[slowIndex] = nums[fastIndex];
        nums[fastIndex] = temp;
    }
}
