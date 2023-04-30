package list;

/**
 * @author dayuu
 * @create 2023/4/30 16:02
 */
/*class ListNode {
    int val; // 节点的值域
    ListNode next; // 节点的指针域

    // 节点的构造函数(无参)
    public ListNode(){
    }

    // 节点的构造函数(有1个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有2个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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
