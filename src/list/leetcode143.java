package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 143. 重排链表
 */
public class leetcode143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        // 把链表放入list列表数组中
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            //偶数个节点的情况，会提前相遇
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
