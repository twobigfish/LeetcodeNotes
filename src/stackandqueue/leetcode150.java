package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dayuu
 * @create 2023/5/12 21:03
 */
// 遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中
public class leetcode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String ch : tokens) {
            if (ch.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (ch.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (ch.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (ch.equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(ch));
            }
        }
        return stack.pop();
    }
}
