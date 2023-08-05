package monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Dayuu
 * @description: 503.下一个更大元素II
 */
public class leetcode503 {


    //方法1 两个nums数组进行拼接

    //方法2 i % nums.size()模拟循环数组
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length]; //存放结果
        Arrays.fill(res, -1);  //默认全部初始化为-1

        Deque<Integer> stack = new ArrayDeque<>(); //栈中存放的是nums中的元素下标
        stack.push(0);

        for (int i = 1; i < nums.length * 2; i++) {

            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
