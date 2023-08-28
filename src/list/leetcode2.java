package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 2. 两数相加
 */
public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int ten = 0; // 进位
        while (l1 != null || l2 != null || ten != 0) { // 注意进位为1也可以单独运算一次
            int i = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + ten;
            ListNode node = new ListNode(i % 10);
            cur.next = node;

            cur = cur.next;
            ten = i / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
