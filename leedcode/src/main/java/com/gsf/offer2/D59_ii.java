package com.gsf.offer2;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-12-16 08:54
 **/
public class D59_ii {


    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> maxStack = new LinkedList<>();

    public D59_ii() {

    }

    public int max_value() {
        return -1;
    }

    public void push_back(int v) {
        queue.push(v);    // 入栈|入队列，放入栈顶
        queue.offer(v);    // 入栈，放入栈底，有返回值，入栈成功则返回true
        queue.offerFirst(v); // 等于 push()
        queue.offerLast(v); // 入栈，放入栈底，有返回值，等于 offer();
        queue.addFirst(v); // 入栈，放入栈顶，等于 push()
        queue.addLast(v);  // 入栈，放入栈底，等于 offer() | offerLast()

        queue.pop();    // 弹出并返回栈顶元素，若为空则抛异常

        queue.removeLast();
        queue.removeFirst();
        queue.remove();

        queue.poll();   // 弹出并返回栈顶元素，若为空则返回null，不抛出异常
        queue.pollFirst(); // 等于 poll();
        queue.pollLast();  // 弹出并返回栈底元素，若为空则返回null，不抛出异常

        queue.peek();      // 返回但不弹出栈顶元素，若为空则返回null
        queue.peekFirst(); // 等于 peek()
        queue.peekLast();  // 返回但不弹出栈底元素，若为空则返回null
        queue.get(0);
        queue.getFirst();
        queue.getLast();



    }

    public int pop_front() {

        return -1;
    }
}
