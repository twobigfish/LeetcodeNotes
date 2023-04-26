package array;

/**
 * @author dayuu
 * @create 2023/4/26 17:57
 */
public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0, fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != nums[slowIndex]) {
                nums[slowIndex + 1] = nums[fastIndex];
                slowIndex++;
                fastIndex++;
            } else {
                fastIndex++;
            }
        }
        // 初始值相等的情况，leftIndex指向了最终数组末尾的下一个元素，不需要＋1
        // slowIndex=0和fastIndex=1初始值不等，不同于leetcode27的写法
        return slowIndex+1;
    }
}
