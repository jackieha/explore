package com.gsf.offer;

import com.gsf.common.ListNode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-05-30 18:08
 **/
public class D24 {

    public static void main(String[] args) {
        ListNode head = ListNode.init(1,2,3,4,5);
        ListNode newHead = reverseList(head);
        ListNode.travers(newHead, n -> System.out.println(n.val));
    }

    /**
     * 中间变量法
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode former = head, latter = former.next;
        former.next = null;
        while (latter != null){
            ListNode temp = latter.next;
            latter.next = former;
            former = latter;
            latter = temp;
        }
        return former;
    }

    /**
     * 递归法
     */
//    public ListNode reverseList2(ListNode head) {
//
//    }

}
