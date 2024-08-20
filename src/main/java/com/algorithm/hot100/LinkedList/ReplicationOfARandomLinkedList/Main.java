package com.algorithm.hot100.LinkedList.ReplicationOfARandomLinkedList;

import java.util.HashMap;
import java.util.Map;

public  class Main {
    public static  class  Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        Node cur = head;
//        while(cur !=null){
//            Node newNode = new Node(cur.val);
//            newNode.next = cur.next;
//            cur.next = newNode;
//            cur = newNode.next;
//        }
//        cur = head;
//        while(cur != null){
//            if(cur.random !=null){
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//        /**拆链表 */
//        Node newHead = new Node(-1);
//        Node pre = newHead;
//        cur = head;
//        while(cur != null){
//            pre.next = cur.next;
//            pre = pre.next;
//            cur.next = pre.next;
//            cur = cur.next;
//
//        }
//        return newHead.next;
//    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            Node newNode = map.get(cur);//得到cur.value,即对应新节点
            if(cur.next != null){
                newNode.next = map.get(cur.next);
            }
            if(cur.random != null){
                newNode.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return map.get(head);

    }



    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node node5 = new Node(1,null);
        Node node4 = new Node(10,node5);
        Node node3 = new Node(11,node4);
        Node node2 = new Node(13,node3);
        Node head = new Node(7,node2);
        head.random = null;
        node2.random = head;
        node3.random = node5;
        node4.random = node3;
        node5.random = head;
        Main main = new Main();
        Node newhead = main.copyRandomList(head);
        printList(newhead);
    }
}
