package com.gsf.leedCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-06-17 17:26
 **/
public class D40 {

    public static void main(String[] args) {
        int[] arr = {2,5,3,8,21,23,0};
        System.out.println(Arrays.toString(getLeastNumbers(arr,3)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (i < k){
                bigHeap.offer(arr[i]);
            }else if (arr[i] < bigHeap.peek()){
                bigHeap.poll();
                bigHeap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int num : bigHeap) {
            res[i++] = num;
        }
        return res;
    }
}
