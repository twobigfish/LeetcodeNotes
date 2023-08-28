package list;

/**
 * @author: Dayuu
 * @description: 25. K 个一组翻转链表
 */
public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //单链表只有一个节点，直接返回原单链表
        if (head.next == null) {
            return head;
        }
        //虚拟节点
        //TODO 涉及到删除节点时，设置dummy节点会更方便，不需要为头节点单独写逻辑，其他情况，是否设置头节点需要单独分析。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode tmp = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = tmp;
            end = start;
            pre = start;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        // 链表没有节点或者只有1个节点时，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
