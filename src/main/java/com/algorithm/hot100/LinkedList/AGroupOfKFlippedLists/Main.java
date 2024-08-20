package com.algorithm.hot100.LinkedList.AGroupOfKFlippedLists;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hnode = new ListNode(0,head);
        ListNode pre = hnode;
        ListNode a = hnode;
        ListNode b = hnode;
        ListNode next = null;
        while (b != null){
            for(int i = 0; i<k && (b != null);i++) b = b.next;
            if(b == null) break;
            next = b.next;
            pre = a;
            a = a.next;
            pre.next = b;
            b.next = null;
            reverse(a);
            a.next = next;
            pre.next = b;
            b = a;
        }
        return hnode.next;
    }
    public void reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
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
        // 创建链表节点
        ListNode node5 = new ListNode(5); // 最后一个节点
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // 实例化 Main 类
        Main main = new Main();

        // 调用 reverseKGroup 方法
        ListNode newHead = main.reverseKGroup(head, 2);

        // 打印反转后的链表
        printList(newHead);
    }
}