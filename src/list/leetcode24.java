package list;

/**
 * @author dayuu
 * @create 2023/5/3 14:50
 */

/*class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/

public class leetcode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(-1); // 设置一个虚拟头结点
        dummyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dummyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null){
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode; // 步骤1
            secondnode.next = firstnode; // 步骤2
            firstnode.next = temp; // 步骤3
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dummyhead.next;
    }
}
