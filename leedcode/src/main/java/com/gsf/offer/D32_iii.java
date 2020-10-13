package com.gsf.offer;

import com.gsf.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * @author shuaifeng.gao
 * @since 2020-06-15 13:03
 **/
public class D32_iii {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean rightFirst = false;
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            while (levelSize-- > 0){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            if (rightFirst){
                Collections.reverse(level);
            }
            res.add(level);
            rightFirst = !rightFirst;
        }
        return res;
    }
}
