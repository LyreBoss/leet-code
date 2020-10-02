package com.solution;


import com.share.solution.base.ListNode;
import com.share.solution.base.TreeNode;

import java.nio.IntBuffer;
import java.util.*;

/**
 * leeCode 算法
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> temp = new LinkedList<>();
        if (root != null) {
            dsf(root, sum, temp);
        }
        return res;
    }

    public void dsf(TreeNode node, int sum, LinkedList<Integer> temp) {
        if (node == null) {
            return;
        }
        temp.addLast(node.val);// 记录路径
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList(temp));
        }
        dsf(node.left, sum - node.val, temp);
        dsf(node.right, sum - node.val, temp);
        temp.removeLast();// 重点，遍历完后，需要把当前节点remove出去，因为用的是同一个list对象来存所有的路径
    }

    //public static void main(String[] args) {
    //    //[5,4,8,11,null,13,4,7,2,null,null,5,1]
    //    TreeNode tree = new TreeNode(5);
    //    tree.left = new TreeNode(4);
    //    tree.right = new TreeNode(8);
    //
    //    tree.left.left = new TreeNode(11);
    //    tree.left.left.left = new TreeNode(7);
    //    tree.left.left.right = new TreeNode(2);
    //
    //    tree.right.left = new TreeNode(13);
    //    tree.right.right = new TreeNode(4);
    //
    //    tree.right.right.left = new TreeNode(5);
    //    tree.right.right.right = new TreeNode(1);
    //
    //
    //    //new Solution().pathSum(tree, 9);
    //
    //
    //    new Solution().Mirror(tree);
    //}

    /**
     * @param root -
     */
    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();

                TreeNode ln = poll.left;
                TreeNode rn = poll.right;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                poll.right = ln;
                poll.left = rn;
            }

        }
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                res.add(index++, matrix[top][column]);
                //order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(index++, matrix[row][right]);
                //order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    //order[index++] = matrix[bottom][column];
                    res.add(index++, matrix[bottom][column]);

                }
                for (int row = bottom; row > top; row--) {
                    //order[index++] = matrix[row][left];
                    res.add(index++, matrix[row][left]);

                }

            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }


    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int temp = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < temp) {
            temp = node;
        }
    }

    public void pop() {
        stack.pop();
        if (stack.isEmpty()) {
            temp = -1;
            return;
        }
        int temp2 = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int temp3 = stack.pop();
            if (temp3 < temp2) {
                temp = temp3;
            }
            stack2.push(temp3);
        }
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return temp;
    }
//输入：head = [4,5,1,9], node = 5

    // 4 1 5 9
    // 4 1 9 5
    // 4 9 1 5

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int begin = 0;
        int len = nums.length;

        int res = Integer.MAX_VALUE;
        while (begin + 1 < len) {

            if (target - nums[begin] - nums[len - 1] == 0) {
                res = 0;
                break;
            }
            int a = target - (nums[begin] + nums[len - 1]);
            if (a > 0) {
                len--;
            }
            if (a < 0) {
                begin++;
            }
            res = Math.min(a, res);

        }

        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> que = new Stack<>();
        que.push(root);

        while (!que.isEmpty()) {

            TreeNode peek = que.peek();

            if (peek.left != null) {
                que.push(peek.left);
                continue;
            }
            if (peek.right != null) {
                que.push(peek.right);
            }


        }

        return null;

    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int index = maxIndex(nums);
        TreeNode root = new TreeNode(nums[index]);

        int[] left = new int[index];
        System.arraycopy(nums, 0, left, 0, index);

        root.left = constructMaximumBinaryTree(left);
        int[] right = new int[nums.length - index - 1];

        System.arraycopy(nums, index + 1, right, 0, nums.length - index - 1);

        root.right = constructMaximumBinaryTree(right);

        return root;
    }

    public int maxIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res] < nums[i]) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(12);
        tree.right = new TreeNode(6);

        tree.left.left = new TreeNode(8);
        tree.left.right = new TreeNode(3);

        tree.right.left = new TreeNode(11);
        //tree.right.right = new TreeNode(7);
        //
        //tree.left.left.left = new TreeNode(8);
        //tree.left.left.right = new TreeNode(9);

        TreeNode tt = new TreeNode(10);
        tt.left = new TreeNode(12);
        tt.right = new TreeNode(6);

        tt.left.left = new TreeNode(8);
        //tt.left.right = new TreeNode(3);

        //tt.right.left = new TreeNode(11);

        //tree.left.right = new TreeNode(5);
        //tree.left.left.left = new TreeNode(7);
        //tree.left.left.right = new TreeNode(2);
        //[10,12,6,8,3,11]
        //[10,12,6,8]


        new Solution().isSubStructure(tree, tt);
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        Queue<TreeNode> node = new LinkedList<>();
        node.offer(A);
        boolean res = false;
        while (!node.isEmpty()) {

            for (int i = 0; i < node.size(); i++) {
                TreeNode poll = node.poll();

                res = isSameTree(poll, B);

                if (poll.left != null) {
                    node.offer(poll.left);
                }
                if (poll.right != null) {
                    node.offer(poll.right);
                }
                if (res) {
                    break;
                }
            }
        }

        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }


    //输入: J = "aA", S = "aAAbbbb"
    //输出: 3

    public int numJewelsInStones(String J, String S) {

        if (J == null || S == null) {
            return 0;
        }

        HashMap<Character, Integer> count = new HashMap<>();
        char[] ton = S.toCharArray();

        char[] bs = J.toCharArray();

        for (char c : ton) {
            count.merge(c, 1, Integer::sum);
        }
        int res = 0;
        for (char b : bs) {
            Integer ss = count.get(b);
            if (ss != null) {
                res += ss;
            }
        }

        return res ;
    }
}