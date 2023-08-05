package monotonicStack;

import java.util.*;

/**
 * @author: Dayuu
 * @description: 496.下一个更大元素 I
 */
public class leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        // nums1 转为 map
        HashMap<Integer, Integer> nums1map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // key: nums[i]元素值，value:对应的下标
            nums1map.put(nums1[i], i);
        }
        // 结果res
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

/*        for (int i = 1; i < nums2.length; i++) {
            // 情况1、2 当前元素 <= 栈顶元素
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    // TODO 处理结果res
                    // 找到nums2[i]中的下一个更大元素，如果nums1中存在该元素，则更新res
                    if (nums1map.containsKey(nums2[stack.peek()])) {
                        int index = nums1map.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }


                    // 和 leetcode739. 每日温度 一样的处理逻辑，不同点在于 “处理结果res”
                    stack.pop();
                }
                stack.push(i);
            }
        }*/
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                // TODO 处理结果res
                // 找到nums2[i]中的下一个更大元素，如果nums1中存在该元素，则更新res
                if (nums1map.containsKey(nums2[stack.peek()])) {
                    int index = nums1map.get(nums2[stack.peek()]);
                    res[index] = nums2[i];
                }

                // 和 leetcode739. 每日温度 一样的处理逻辑，不同点在于 “处理结果res”
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
