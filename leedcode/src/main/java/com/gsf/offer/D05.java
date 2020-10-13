package com.gsf.offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author shuaifeng.gao
 * @since 2020-05-24 16:49
 **/
public class D05 {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] ns = new char[s.length() * 3];
        char[] os = s.toCharArray();
        int size = 0;
        for (int i = 0; i < os.length; i++) {
            if (os[i] == ' '){
                ns[size++] = '%';
                ns[size++] = '2';
                ns[size++] = '0';
                continue;
            }
            ns[size++] = os[i];
        }
        return new String(ns, 0, size);
    }

}
