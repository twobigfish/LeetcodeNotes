package list;

/**
 * @author: Dayuu
 * @description: 92. 反转链表 II
 */
public class leetcode92 {
    // 法1   另一个方法的节点转换太乱了
    // https://leetcode.cn/problems/reverse-linked-list-ii/solutions/2308619/92-fan-zhuan-lian-biao-ii-ti-jie-by-leer-pc2u/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp1 = dummy;
        ListNode end = dummy;
        while (left-- > 1) { // 遍历到left的前一个，因为要记录left-1的节点
            tmp1 = tmp1.next;
        }
        while (right-- > 0) { // 遍历到right，因为要记录right+1的节点
            end = end.next;
        }
        ListNode start = tmp1.next;
        ListNode tmp2 = end.next;
        // 切断 使reverse方法结束在right位置
        end.next = null;
        tmp1.next = reverse(start);
        start.next = tmp2;
        return dummy.next;
    }

    ListNode reverse(ListNode head) { // 返回的是反转后的头节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
