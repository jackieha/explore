package com.gsf.offer;


import com.gsf.common.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-05-24 23:35
 **/
public class D18 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head = deleteNode(n1, 5);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode newHead = pre;
        while (head != null){
            if (head.val == val){
                pre.next = head.next;
                head.next = null;
                break;
            }
            pre = head;
            head = head.next;
        }
        return newHead.next;
    }
}
