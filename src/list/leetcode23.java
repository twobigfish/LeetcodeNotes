package list;

import java.util.PriorityQueue;

/**
 * @author: Dayuu
 * @description: 23. 合并 K 个升序链表
 */
public class leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );
        // 把每个链表的第一个节点添加到que中
        for (ListNode head : lists) {
            if (head != null) {
                que.add(head);
            }
        }
        ListNode dummy = new ListNode(-1); //虚拟节点
        ListNode cur = dummy;
        while (!que.isEmpty()) {
            ListNode tmp = que.poll();// 从优先队列中取出的元素是按照从小到大的顺序取出的
            if (tmp.next != null) { //取出的节点如果有next节点，则加入que中
                que.add(tmp.next);
            }
            cur.next = tmp; // 加入新的链表中
            cur = cur.next;
        }
        return dummy.next;
    }
}
