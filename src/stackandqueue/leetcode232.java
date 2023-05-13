package stackandqueue;

import java.util.Stack;

/**
 * @author dayuu
 * @create 2023/5/8 15:50
 */
class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    // 初始化数据
    public MyQueue() {
        stackIn = new Stack<>();    // 负责进栈
        stackOut = new Stack<>();   // 负责出栈
    }

    // 将元素 x 推到队列的末尾
    public void push(int x) {
        stackIn.push(x);
    }

    // 从队列的开头移除并返回元素
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    // 返回队列开头的元素
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpstackIn(){
        // 如果stackOut非空，那么直接拿出stackOut中的元素
        if (!stackOut.isEmpty()) return;
        // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}

public class leetcode232 {

}
