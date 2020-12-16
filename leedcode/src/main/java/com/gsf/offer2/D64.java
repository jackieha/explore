package com.gsf.offer2;

import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-11-22 15:58
 **/
public class D64 {

    public static void main(String[] args) {
    }

    public static int sumNums(int n) {
        boolean f = n > 0 && ((n = n + sumNums(n - 1)) > 0);
        return n;
    }

    public static int sumNumsJdk8(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }


}
