package list;

import java.util.PriorityQueue;

/**
 * @author: Dayuu
 * @description: 148. 排序链表
 */
public class leetcode148 {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // O(nlogn)    O(1)<O(logn)<O(n)<O(nlogn)<O(n^2)
        PriorityQueue<ListNode> list = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        while (!list.isEmpty()) {
            cur.next = list.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
