package monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Dayuu
 * @description: 739. 每日温度
 */
// 通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了

public class leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // 栈中存放数组下标
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            // 情况1、2 当前元素 <= 栈顶元素
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                // 情况3  当前元素 > 栈顶元素
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                // 当前元素入栈
                stack.push(i);
            }
        }
        return res;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // 栈中存放数组下标
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); // 不论大于小于还是等于，都要入栈操作
        }
        return res;
    }
}
