package com.gsf.offer;

import com.gsf.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author shuaifeng.gao
 * @since 2020-06-17 10:37
 **/
public class D34 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(pathSum(root, 8));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        preorder(root, sum, stack, res);
        return res;
    }


    private static void preorder(TreeNode node, int tar, LinkedList<Integer> stack, List<List<Integer>> res){
        if (node == null){
            return;
        }
        stack.addLast(node.val);
        tar = tar - node.val;
        if (tar == 0 && node.left == null && node.right == null){
            res.add(new LinkedList<>(stack));
        }
        preorder(node.left, tar, stack, res);
        preorder(node.right, tar, stack, res);
        stack.removeLast();
    }
}
