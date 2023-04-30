package list;

/**
 * @author dayuu
 * @create 2023/4/30 17:30
 */
/*class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class leetcode206 {
    // 双指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode tmp = cur.next;
        cur.next = pre;
        // 下面这两步赋值操作在reverse方法中实现
        *//* pre = cur;
        cur = tmp;*//*
        return reverse(tmp, cur);
    }
}*/
