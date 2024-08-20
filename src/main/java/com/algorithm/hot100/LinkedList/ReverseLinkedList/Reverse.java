package com.algorithm.hot100.LinkedList.ReverseLinkedList;
public class Reverse {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 public ListNode reverseList(ListNode head) {
        ListNode a = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = a;
            a = cur;
            cur = next;
        }
        return a;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode node5 = new ListNode(5); // 最后一个节点
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        // 实例化类
        Reverse reverse = new Reverse();

        // 调用 reverseKGroup 方法
        ListNode newHead = reverse.reverseList(head);

        // 打印反转后的链表
        printList(newHead);
    }

}