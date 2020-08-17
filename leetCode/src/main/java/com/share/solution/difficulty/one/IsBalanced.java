package com.share.solution.difficulty.one;

/**
 * @author Lgq create on 2020/8/17
 */
public class IsBalanced {

    public int isBalanced(TreeNode root) {
        return getMaxDepth(root) - getMinDepth(root);
    }

    public int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(node.left) + 1;
        int rightDepth = getMaxDepth(node.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getMinDepth(node.left) + 1;
        int rightDepth = getMinDepth(node.right) + 1;
        return Math.min(leftDepth, rightDepth);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
