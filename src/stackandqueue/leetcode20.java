package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dayuu
 * @create 2023/5/12 19:41
 *  Java 为什么推荐用Deque实现Stack
 *  https://blog.csdn.net/Dlgdlgd/article/details/125768706
 *  Deque用法  https://blog.csdn.net/weixin_42488513/article/details/120233456
 *
 * 在匹配左括号的时候，右括号先入栈，就只需要比较当前元素和栈顶相不相等就可以了，
 * 比左括号先入栈代码实现要简单的多了！
 */

public class leetcode20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if(stack.isEmpty() || stack.peek() != c){
                return false;
            } else { //如果是右括号判断是否和栈顶元素匹配
                stack.pollFirst();
            }
        }
        // 如果栈为空，说明栈中的括号都被匹配上了
        return stack.isEmpty();
    }
}
