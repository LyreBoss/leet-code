package com.share.solution.search;

import com.share.solution.base.TreeNode;

import java.util.*;

/**
 * DFS（Deep First Search）深度优先搜索。
 * <p>
 * BFS（Breath First Search）广度优先搜索。
 *
 * @author Lgq create on 2020/9/6
 */
public class Dfs {


    public List<List<Integer>> leveOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int leveSize = q.size();
            List<Integer> currLevel = new ArrayList<>();


            for (int i = 0; i < leveSize; i++) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            res.set(0, currLevel);
        }
        return res;


    }

    public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    if (isLeafNode(curr.left)) {
                        sum = sum + curr.left.val;
                    }else {
                        queue.offer(curr.left);
                    }
                }
                if (curr.right != null) {
                    if (!isLeafNode(curr.right)) {
                        queue.offer(curr.right);
                    }
                }
            }
            return sum;
    }
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }



}
