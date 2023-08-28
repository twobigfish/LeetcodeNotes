package list;

/**
 * @author dayuu
 * @create 2023/4/30 16:46
 */

// 单链表  链表的索引也是从0开始，dummy对应的下标为-1，实际的头节点下标为0
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;  // size存储链表元素的个数
    ListNode dummy;  // dummy头节点，dummy对应的下标为-1

    //初始化链表
    public MyLinkedList() {
        size = 0;
        dummy = new ListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = dummy;
        // 包含1个虚拟头节点，所以查找到第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        // 如果 index<0，则作为新的head节点
        if (index < 0) {
            index = 0;
        }
        // 找到要插入节点的前驱节点
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
        size++;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            dummy = dummy.next;
            size--;
            return;
        }
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

//双链表
/*class ListNode{
    int val;
    ListNode next,prev;
    ListNode() {};
    ListNode(int val){
        this.val = val;
    }
}


class MyLinkedList {

    //记录链表中元素的数量
    int size;
    //记录链表的虚拟头结点和尾结点
    ListNode head,tail;

    public MyLinkedList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        //判断index是否有效
        if(index<0 || index>=size){
            return -1;
        }
        ListNode cur = this.head;
        //判断是哪一边遍历时间更短
        if(index >= size / 2){
            //tail开始
            cur = tail;
            for(int i=0; i< size-index; i++){
                cur = cur.prev;
            }
        }else{
            for(int i=0; i<= index; i++){
                cur = cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        //index大于链表长度
        if(index>size){
            return;
        }
        //index小于0
        if(index<0){
            index = 0;
        }
        size++;
        //找到前驱
        ListNode pre = this.head;
        for(int i=0; i<index; i++){
            pre = pre.next;
        }
        //新建结点
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;

    }

    public void deleteAtIndex(int index) {
        //判断索引是否有效
        if(index<0 || index>=size){
            return;
        }
        //删除操作
        size--;
        ListNode pre = this.head;
        for(int i=0; i<index; i++){
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
    }
}*/
public class leetcode707 {

}
