package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dayuu
 * @create 2023/5/6 16:51
 */
public class leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //  不符合条件，直接返回 （剪枝操作） 这一步可写可不写
            /*if (nums[i] > target && nums[i] > 0) {
                return result;
            }*/
            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                // 对nums[j]去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int right = nums.length - 1;
                int left = j + 1;
                while (right > left) {
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
