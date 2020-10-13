package com.gsf.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author shuaifeng.gao
 * @since 2020-05-24 16:16
 **/
public class D03 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums){
            if (s.contains(i)){
                return i;
            }
            s.add(i);
        }
        return -1;
    }
}
