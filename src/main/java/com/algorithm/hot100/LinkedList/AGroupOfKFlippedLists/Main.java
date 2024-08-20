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
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;

        while (true) {
            ListNode start = pre;
            for (int i = 0; i < k; i++) {
                if (end == null) return dummy.next;
                end = end.next;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start.next);
            start.next = next;
            pre = start;
            end = pre;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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