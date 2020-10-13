package com.gsf.offer;

import com.gsf.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuaifeng.gao
 * @since 2020-05-24 16:59
 **/
public class D06 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
//        System.out.println(Arrays.toString(reversePrint2(n1)));
        reversePrint3(n1);
    }

    /**
     * 递归
     */
    public static int[] reversePrint3(ListNode head) {
        if (head == null){
            return new int[0];
        }
        List<Integer> l = new ArrayList<>();
        digui(head, l);
        System.out.println(l);
        return new int[0];
    }


    private static void digui(ListNode head, List<Integer> list){
        if (head == null) return;
        digui(head.next, list);
        list.add(head.val);
    }


    /**
     * 栈 或者 数组
     */
    public static int[] reversePrint2(ListNode head) {
        if (head == null){
            return new int[0];
        }
        Stack<Integer> s = new Stack<>();
        while (head != null){
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        int i = 0;
        while (!s.isEmpty()){
            res[i++] = s.pop();
        }
        return res;
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        ListNode placeHold = new ListNode(-1);
        ListNode pre = placeHold;
        int length = 0;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            length++;
        }
        int[] res = new int[length];
        int i = 0;
        while (pre != null && pre != placeHold){
            res[i++] = pre.val;
            pre = pre.next;
        }
        return res;
    }


}

