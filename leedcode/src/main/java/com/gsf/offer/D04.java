package com.gsf.offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-05-24 16:25
 **/
public class D04 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int[][] m = {{1, 1}};

        System.out.println(findNumberIn2DArray(m, 2));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] > target){
                j--;
                continue;
            }
            if (matrix[i][j] < target){
                i++;
                continue;
            }
            return true;
        }
        return false;
    }
}
