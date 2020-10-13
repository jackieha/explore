package com.gsf.offer;

import com.gsf.common.ListNode;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author shuaifeng.gao
 * @since 2020-05-30 17:22
 **/
public class D22 {

    public static void main(String[] args) {
        ListNode head = ListNode.init(1,2,3,4,5);
        ListNode newHead = getKthFromEnd2(head, 1);
        ListNode.travers(newHead, n -> System.out.println(n.val));
    }

    public static ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k <= 0){
            return null;
        }

        ListNode first = head, second = head;
        for (int i = 0; i < k; i++) {
            if (first == null){
                return null;
            }
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0){
            return null;
        }
        ListNode first = head, second = head;
        while (first != null){
            first = first.next;
            k--;
            if (k < 0){
                second = second.next;
            }
        }
        return k > 0 ? null : second;
    }
}
