package monotonicStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Dayuu
 * @description: 42. 接雨水
 */
public class leetcode42 {
    // 法1、双指针
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // 记录每个柱子右边柱子最大高度
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // 求和
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }

    // 法2、单调栈
    public int trap1(int[] height) {
        Stack<Integer> stack = new Stack<>(); // 存下标
        stack.push(0);

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            // 情况1
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }

            // 情况2
            if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }

            // 情况3
            if (height[i] > height[stack.peek()]) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop(); // 底的位置

                    if (!stack.isEmpty()) {
                        int left = stack.peek(); // 左边的位置

                        int high = Math.min(height[left], height[i]) - height[mid]; // 高
                        int weight = i - left - 1; // 宽
                        sum += high * weight;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
