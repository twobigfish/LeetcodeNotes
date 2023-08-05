package monotonicStack;

import java.util.Stack;

/**
 * @author: Dayuu
 * @description: 84. 柱状图中最大的矩形
 */
public class leetcode84 {
    // 法1 双指针
    public int largestRectangleArea(int[] heights) {
        int[] minleft = new int[heights.length];
        int[] minright = new int[heights.length];

        minleft[0] = -1;
        // 记录每个柱子 左边第一个小于该柱子的下标
        for (int i = 1; i < heights.length; i++) {
            int t = i - 1;
            // 这里不用if，因为要不断向左寻找，找到第一个小于当前高度的。
            // 左边柱子的minleft[i-1]有可能高于当前柱子i，所以不断向左寻找。
            while (t >= 0 && heights[i] <= heights[t]) { // 是 <= ，不是 <，因为要找到第一个小于当前高度的。
                t = minleft[t];
            }
            minleft[i] = t;
        }

        // 记录每个柱子 右边第一个小于该柱子的下标
        minright[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int t = i + 1;
            // 这里不用if，因为要不断向右寻找，找到第一个小于当前高度的。
            while (t < heights.length && heights[i] <= heights[t]) { // 是 <= ，不是 <，因为要找到第一个小于当前高度的。
                t = minright[t];
            }
            minright[i] = t;
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int w = minright[i] - minleft[i] - 1;
            int h = heights[i];
            res = Math.max(res, w * h);
        }
        return res;
    }

    // 法2 单调栈
    public int largestRectangleArea1(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 数组扩容，在头和尾各插入一个元素
        int[] newheights = new int[heights.length + 2];
        newheights[0] = 0;
        newheights[newheights.length - 1] = 0;
        for (int i = 0; i < newheights.length - 2; i++) {
            newheights[i + 1] = heights[i]; // newheights[0]已经初始化了
        }

        heights = newheights; //heights重新指向newheights
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1; //-1：不包含边界
                    int h = heights[mid];
                    res = Math.max(w * h, res);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
