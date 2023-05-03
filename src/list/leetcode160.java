package list;

/**
 * @author dayuu
 * @create 2023/5/3 15:42
 */
public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;

        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链的head（方便后续操作）
        if (lenB > lenA) {
            int tmplen = lenA;
            lenA = lenB;
            lenB = tmplen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        // 求长度
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
