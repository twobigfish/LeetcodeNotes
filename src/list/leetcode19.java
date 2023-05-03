package list;

/**
 * @author dayuu
 * @create 2023/5/3 15:22
 */
public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;

        ListNode slow = dummyhead;
        ListNode fast = dummyhead;

        while (fast.next != null) {
            fast = fast.next;
            if (n-- < 1) { //只要快慢指针相差 n 个结点即可
                slow = slow.next;
            }
        }
        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        slow.next = slow.next.next;
        return dummyhead.next;
    }
}
