package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dayuu
 * @create 2023/5/8 16:19
 */

/**
 * Queue：
 * 1. 向队列中添加元素：队列满 add抛异常，offer返回false
 * 2. 返回并删除队列的头元素：队列空 remove抛异常，poll返回null
 * 3. 返回队列的头元素，但不删除：队列空 element抛异常，peek返回null
 */
class MyStack {
    Queue<Integer> queue; // 和栈中保持一样元素的队列

    public MyStack() {
        queue = new LinkedList<>();
    }

    // 每 offer 一个数（A）进来，都重新排列，把这个数（A）放到队列的队首
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        // 移动除了A之外的其他数
        while (size-- > 1) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class leetcode225 {
}
