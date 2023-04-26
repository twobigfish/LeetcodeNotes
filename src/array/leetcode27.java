package array;

/**
 * @author dayuu
 * @create 2023/4/26 17:46
 */
public class leetcode27 {
    public int removeElement(int[] nums, int val) {
//        双指针
        int slowIndex = 0, fastIndex = 0;
        while (fastIndex < nums.length) {
//            版本1
            /*if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
                fastIndex++;
            } else {
                fastIndex++;
            }*/
//            版本2
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
//        leftIndex指向了最终数组末尾的下一个元素
        return slowIndex;
    }
}
