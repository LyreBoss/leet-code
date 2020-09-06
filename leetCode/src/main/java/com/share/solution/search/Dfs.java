package com.share.solution.search;

import com.share.solution.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


}
