package com.gsf.offer;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-05-30 18:43
 **/
public class D35 {

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        travers(n1);
        System.out.println("*******");
        travers(copyRandomList(n1));

        System.out.println("********");
        travers(n1);

    }

    private static void travers(Node head){
        while (head != null){
            System.out.println("value:" +head.val + "   "  + head + "," + (head.random == null ? "null":head.random));
            head = head.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node tempHead = head;
        while (tempHead != null){
            Node copNode = new Node(tempHead.val);
            copNode.next = tempHead.next;
            copNode.random = tempHead.random;
            tempHead.next = copNode;
            tempHead = copNode.next;
        }
        tempHead = head;
        while (tempHead != null){
            if (tempHead.random != null){
                tempHead.next.random = tempHead.random.next;
            }
            tempHead = tempHead.next.next;
        }
        Node copyHead = head.next;
        tempHead = head.next;
        while (tempHead != null){
            head = head.next = tempHead.next;
            if (tempHead.next == null){
                tempHead = null;
            }else {
                tempHead = tempHead.next = tempHead.next.next;
            }
        }
        return copyHead;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


