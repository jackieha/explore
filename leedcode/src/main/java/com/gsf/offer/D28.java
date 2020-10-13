package com.gsf.offer;

import com.gsf.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-06-15 15:52
 **/
public class D28 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmetric(t1));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetricLR(root.left, root.right);
    }

    private static boolean isSymmetricLR(TreeNode l, TreeNode r){
        if (l == null && r == null){
            return true;
        }
        if (l == null || r == null){
            return false;
        }
        return l.val == r.val && isSymmetricLR(l.left, r.right) && isSymmetricLR(l.right, r.left);
    }
}
