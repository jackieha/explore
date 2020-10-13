package com.gsf.offer;

import com.gsf.common.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @author shuaifeng.gao
 * @since 2020-06-17 17:46
 **/
public class D55 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(levelOrder(root));
    }
    public static int maxDepth1(TreeNode root) {
       int[] maxDepth = new int[1];
       int depth = 0;
       preorder(root, depth, maxDepth);
       return maxDepth[0];
    }

    public static int maxDepth2(TreeNode root) {
        int depth = 0;
        return postorder(root, depth);
    }

    private static void preorder(TreeNode root, int depth, int[] maxDepth){
        if (root == null){
            return;
        }
        depth = depth + 1;
        if (root.left == null && root.right == null){
            maxDepth[0] = Math.max(depth, maxDepth[0]);
        }
        preorder(root.left, depth, maxDepth);
        preorder(root.right, depth, maxDepth);
    }

    private static int postorder(TreeNode root, int depth){
        if (root == null) {
            return 0;
        }
        int depthL = postorder(root.left, depth);
        int depthR = postorder(root.right, depth);
        return Math.max(depthL, depthR) + 1;
    }

    private static int levelOrder(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth += 1;
        }
        return depth;
    }
}
