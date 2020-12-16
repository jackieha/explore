package com.gsf.offer2;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author shuaifeng.gao
 * @since 2020-12-16 08:10
 **/
public class D30 {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> min = new LinkedList<>();

    /** initialize your data structure here. */
    public D30() {
    }

    public static void main(String[] args) {
        D30 d = new D30();
        d.push(-2);
        d.push(0);
        d.push(-3);
        System.out.println(d.min());
        d.pop();
        System.out.println(d.top());
        System.out.println(d.min());
    }

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min.peek())){
            min.pop();
        }
    }

    public int top() {
        return stack.peek() != null ? stack.peek() : -1;
    }

    public int min() {
        return min.peek() != null ? min.peek() : -1;
    }
}
