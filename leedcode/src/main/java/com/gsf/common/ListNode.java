package com.gsf.common;

import java.util.function.Consumer;

/**
 * @author shuaifeng.gao
 * @since 2020-05-24 23:35
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode init(int... values){
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        for (int value : values) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return pre.next;
    }

    public static void travers(ListNode head, Consumer<ListNode> consumer){
        ListNode temp = head;
        while (temp != null){
            consumer.accept(temp);
            temp = temp.next;
        }
    }
}
