package com.share.solution.difficulty.one.tree;

import com.share.solution.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一个树 是否是完全二叉树
 *
 * @author Lgq create on 2020/9/16
 */
public class BalancedBinaryTree {


    public BalancedBinaryTree() {

        TreeNode root = new TreeNode(-1);
        boolean a = IsBalance_Solution1(root);
        boolean b = IsBalance_Solution2(root);
        boolean c = IsBalance_Solution3(root);
        System.out.println(a & b);
    }

    /**
     * 递归调用 ，每个节点会访问两次
     *
     * @param treeNode treeNode
     * @return return
     */
    public boolean IsBalance_Solution1(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }

        int left = depth(treeNode.left);
        int right = depth(treeNode.right);

        return Math.abs(left - right) <= 0;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : rightDepth + 1;
    }



    public boolean IsBalance_Solution2(TreeNode root) {
        return etDepth(root) != -1;

    }

    /**
     * 从下往上 遍历
     *
     * @param root root
     * @return dept
     */
    private int etDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = etDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = etDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public boolean IsBalance_Solution3(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = null;
        queue.offer(root);

        while (root != null) {

            current = queue.poll();
            if (current != null) {
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                if (current.left == null && current.right != null) {
                    return false;
                }
                if (current.left != null && current.right == null) {
                    if ((current.left.left != null && current.right.right != null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null)
                return false;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }


    public boolean isFullBST(TreeNode root) {
        return isFullBST(root, root);
    }

    //  q 为左侧结构节点， p为右侧结构节点  p和q在结构上对称存在
    public boolean isFullBST(TreeNode q, TreeNode p) {
        //判断结构是否为左右对称
        if (q == null && p == null) {
            return true;
        }
        //判断结构是否为左右对称
        if (q == null || p == null) {
            return false;
        }
        //堆成的两个节点p和q都有子孩子时
        if (q.left != null && q.right != null && p.left != null && p.right != null) {
            // p和q的下一层节点全满或都为空，返回true
            if (q.left.left == null && q.left.right == null && q.right.left == null && q.right.right == null
                    && p.left.left == null && p.left.right == null && p.right.left == null && p.right.right == null) {
                return true;
            }
        }
        if (q.left == null || q.right == null || p.left == null || p.right == null) {  //q和p节点中不全为空
            return false;
        }
        return isFullBST(q.left, p.right) && isFullBST(q.right, p.left);  //递归
    }
}
