package list;

/**
 * @author: Dayuu
 * @description: 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solutions/678600/tong-yong-shan-chu-zhong-fu-jie-dian-lia-od9g/
 */
public class leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next == null || cur.val != cur.next.val) {
                pre.next = cur;
                pre = cur;
            }

            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            cur = cur.next; // cur取下一个继续判断 或 元素本身和上一个重复，因此也要删除
        }
        pre.next = null;
        return dummy.next;
    }
}
