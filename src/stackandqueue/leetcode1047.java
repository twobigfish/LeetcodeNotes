package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dayuu
 * @create 2023/5/12 20:00
 * Java 为什么推荐用Deque实现Stack
 * https://blog.csdn.net/Dlgdlgd/article/details/125768706
 * Deque用法  https://blog.csdn.net/weixin_42488513/article/details/120233456
 */
public class leetcode1047 {
    // 法一
    /*public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        String s2 = "";
        // 剩余的元素即为不重复的元素
        // 注意：因为从栈里弹出的元素是倒序的，所以再对字符串进行反转一下
        while (!stack.isEmpty()) {
            s2 = stack.pop() + s2;
        }
        return s2;
    }*/


    // 法二 字符串本身作为栈
    public String removeDuplicates(String s) {
        // StringBuilder速度快，线程不安全；StringBuffer线程安全，但开销大
//        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        char ch;
        int top = -1; // 指向stringBuilder的指针

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && ch == stringBuilder.charAt(top)) {
                stringBuilder.deleteCharAt(top);
                top--;
            // 否则，将该字符 入栈，同时top++
            } else {
                stringBuilder.append(ch);
                top++;
            }
        }
        return stringBuilder.toString();
    }
}
