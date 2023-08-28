package list;

/**
 * @author dayuu
 * @create 2023/4/30 16:02
 */
/*//TODO 涉及到删除节点时，设置dummy节点会更方便，不需要为头节点单独写逻辑，其他情况，是否设置头节点需要单独分析。
public class leetcode203 {
    *//**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param val
     * @return
     *//*
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy（虚拟）头节点，统一操作
        ListNode dummy = new ListNode(-1, head); // dummy节点值为-1，指向head
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    *//**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param val
     * @return
     *//*
    public ListNode removeElements2(ListNode head, int val) {
        // 如果头节点=val，则一直寻找到第一个不等于val的节点作为head
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 放在第一个while之后，因为第一个while结束，head可能会为null
        if (head == null) {
            return head;
        }
        // 当前head != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    *//**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param val
     * @return
     *//*
    public ListNode removeElements3(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null) {
            // 找到下一个不等于val的节点作为新的cur
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}*/
