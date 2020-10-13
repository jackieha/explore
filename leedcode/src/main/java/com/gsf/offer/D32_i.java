package com.gsf.offer;

import com.gsf.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-06-15 12:34
 **/
public class D32_i {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(Arrays.toString(levelOrder(root)));
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()){
            // 将当前的节点移除，并放入其所有子节点
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        int[] intRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            intRes[i] = res.get(i);
        }
        return intRes;
    }
}
