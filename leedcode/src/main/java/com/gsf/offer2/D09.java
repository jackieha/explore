package com.gsf.offer2;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-12-15 23:45
 **/
public class D09 {

    private LinkedList<Integer> s1 = new LinkedList<>();
    private LinkedList<Integer> s2 = new LinkedList<>();

    public D09() {

    }

    public void appendTail(int value) {
       s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if (!s2.isEmpty()){
            return s2.pop();
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
}
