package list;

/**
 * @author: Dayuu
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 */
public class leetcode22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
