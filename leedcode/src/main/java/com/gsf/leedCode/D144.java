package com.gsf.leedCode;

import com.gsf.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author shuaifeng.gao
 * @since 2020-06-15 16:14
 **/
public class D144 {

    public static void main(String[] args) {
       TreeNode root = TreeNode.init();
        System.out.println(preorderTraversal(root));
//        System.out.println(preorderTraversal2(root));
        System.out.println(inorderTraversal(root));
//        System.out.println(inorderTraversal2(root));
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, t ->res.add(t.val));
        return res;
    }

    public static void preorderTraversal2(TreeNode root, Consumer<TreeNode> c) {
        List<Integer> res = new LinkedList<>();
        if (root == null){
            return ;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            c.accept(temp);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    public static void inorderTraversal2(TreeNode root, Consumer<TreeNode> c) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(root);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                c.accept(temp);
                cur = temp.right;
            }
        }
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                root = temp.right;
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, t ->res.add(t.val));
        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root, t ->res.add(t.val));
        return res;
    }

    public static void preorderTraversal(TreeNode root, Consumer<TreeNode> c){
        if (root == null){
            return;
        }
        c.accept(root);
        preorderTraversal(root.left, c);
        preorderTraversal(root.right, c);
    }

    public static void inorderTraversal(TreeNode root, Consumer<TreeNode> c){
        if (root == null){
            return;
        }
        inorderTraversal(root.left, c);
        c.accept(root);
        inorderTraversal(root.right, c);
    }

    public static void postorderTraversal(TreeNode root, Consumer<TreeNode> c){
        if (root == null){
            return;
        }
        postorderTraversal(root.left, c);
        postorderTraversal(root.right, c);
        c.accept(root);
    }
}
