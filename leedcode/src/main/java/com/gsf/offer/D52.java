package com.gsf.offer;

import com.gsf.common.ListNode;

/**
 * @author shuaifeng.gao
 * @since 2020-06-10 18:09
 **/
public class D52 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(-1);
        ListNode headB = new ListNode(-1);
        ListNode tempA = headA;
        ListNode tempB = headB;
        int[] va = {0,1,2};
        int[] vb = {10,11, 12};
        for (int value : va) {
            tempA.next = new ListNode(value);
            tempA = tempA.next;
        }
        for (int i : vb) {
            tempB.next = new ListNode(i);
            tempB = tempB.next;
        }

        int[] comV = {-3, -4};
        ListNode com = new ListNode(-2);
        ListNode comTemp = com;
        for (int i : comV) {
            comTemp.next = new ListNode(i);
            comTemp = comTemp.next;
        }

//        tempA.next = com;
//        tempB.next = com;

        ListNode.travers(headA, node -> System.out.print(node + ","));
        System.out.println("");
        System.out.println("****");
        ListNode.travers(headB, node -> System.out.print(node + ","));
        System.out.println();

        System.out.println("+++++++++++");
        ListNode.travers(getIntersectionNode(headA, headB), node -> System.out.print(node + ","));

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }


}
