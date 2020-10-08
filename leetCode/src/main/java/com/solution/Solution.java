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

    //public static void main(String[] args) {
    //
    //    int[] nums = new int[]{3, 2, 1, 6, 0, 5};
    //
    //    TreeNode tree = new TreeNode(10);
    //    tree.left = new TreeNode(12);
    //    tree.right = new TreeNode(6);
    //
    //    tree.left.left = new TreeNode(8);
    //    tree.left.right = new TreeNode(3);
    //
    //    tree.right.left = new TreeNode(11);
    //    //tree.right.right = new TreeNode(7);
    //    //
    //    //tree.left.left.left = new TreeNode(8);
    //    //tree.left.left.right = new TreeNode(9);
    //
    //    TreeNode tt = new TreeNode(10);
    //    tt.left = new TreeNode(12);
    //    tt.right = new TreeNode(6);
    //
    //    tt.left.left = new TreeNode(8);
    //tt.left.right = new TreeNode(3);

    //tt.right.left = new TreeNode(11);

    //tree.left.right = new TreeNode(5);
    //tree.left.left.left = new TreeNode(7);
    //tree.left.left.right = new TreeNode(2);
    //[10,12,6,8,3,11]
    //[10,12,6,8]

    //
    //    new Solution().isSubStructure(tree, tt);
    //}


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

        return res;
    }

    //board =
    //[
    //  ['A','B','C','E'],
    //  ['S','F','C','S'],
    //  ['A','D','E','E']
    //]
    //
    //给定 word = "ABCCED", 返回 true
    //给定 word = "SEE", 返回 true
    //给定 word = "ABCB", 返回 false

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;

        if (col == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            return 0;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //以 i 为中心
            String s1 = palindrome(s, i, i);
            //以 i 和 i+1 为中心
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res.length();
    }


    public String palindrome(String s, int l, int r) {
        // 防止数组越界
        char[] ss = s.toCharArray();

        while (l >= 0 && r < ss.length && ss[l] == ss[r]) {
            //向两边扩展
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public int longestPalindromeSubse1q(String s) {

        if (s == null) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return 1;
    }

    //输入: [1,2,3,4,5]
    //输出: [120,60,40,30,24]


    public int[] constructArr(int[] a) {
        if (a == null) {
            return new int[0];
        }
        int len = a.length;
        int[] n = new int[len];
        for (int i = 0; i < len; i++) {
            n[i] = cons(a, i);
        }
        return n;
    }

    public int cons(int[] nums, int i) {
        int res = 1;

        for (int j = 0; j < nums.length; j++) {
            if (j == i) {
                continue;
            }
            res = res * nums[j];
        }
        return res;
    }


    public int[] constructArr1(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }


    public ListNode[] splitListToParts(ListNode root, int k) {
        //计算长度

        int len = 0;

        ListNode temp = root;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        ListNode[] res = new ListNode[k];
        if (len == 0) {
            return res;
        }
        int div = k > len ? 1 : len / k;
        int mod = k < len ? k % len : 0;

        for (int i = 0; i < k; i++) {
            int tem = div;
            if (root != null) {
                res[i] = new ListNode(root.val);
                root = root.next;
            } else {
                res[i] = null;
            }
            ListNode node = res[i];
            while (tem > 1) {
                if (res[i] != null && root != null) {
                    res[i].next = new ListNode(root.val);
                    root = root.next;
                    res[i] = res[i].next;
                }
                tem--;
                if (tem == 0 && mod > 0 && res[i] != null && root != null) {
                    res[i].next = new ListNode(root.val);
                    root = root.next;
                }
            }
        }
        return res;
    }

    //public static void main(String[] args) {
    //    ListNode root = new ListNode(1);
    //    root.next = new ListNode(2);
    //    root.next.next = new ListNode(3);
    //    root.next.next.next = new ListNode(4);
    //    root.next.next.next.next = new ListNode(5);
    //    root.next.next.next.next.next = new ListNode(6);
    //    root.next.next.next.next.next.next = new ListNode(7);
    //    root.next.next.next.next.next.next.next = new ListNode(8);
    //    root.next.next.next.next.next.next.next.next = new ListNode(9);
    //    root.next.next.next.next.next.next.next.next.next = new ListNode(10);
    //    new Solution().splitListToParts(root, 3);
    //}


    public static void main1(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int be = 0;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            be = be + i + 2;
            while (be < arr.length) {
                int t = be;
                while (t - i >= 0) {
                    total = total + arr[t];
                    t--;
                }
                be = be + 2;
            }
            be = 0;
        }
        return total + sumArr(arr);
    }

    private int sumArr(int[] arr) {
        int res = 0;
        for (int value : arr) {
            res = res + value;
        }
        return res;

    }

    public int kSimilarity(String A, String B) {

        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();

        int res = 0;

        for (int i = 0; i < charA.length; i++) {

            //find b eq a
            int bi = i;
            while (bi < charB.length) {
                if (charA[i] == charB[bi] && i == bi) {
                    break;
                }
                if (charA[i] == charB[bi] && i != bi) {
                    char temp = charB[i];
                    charB[i] = charB[bi];
                    charB[bi] = temp;
                    res++;
                    break;
                }

                bi++;
            }


        }
        return res;
    }

    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }
            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }


    public int specialArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < nums.length + 1; i++) {
            int temp = 0;
            int len = nums.length;
            while (len > 0) {
                if (nums[len - 1] >= i) {
                    temp++;
                }
                len--;
            }
            if (i == temp) {
                return temp;
            }
        }
        return res;
    }


    public boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int jo = 0;

        while (!nodes.isEmpty()) {
            int temp = 0;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodes.poll();
                if (treeNode.left != null) {
                    nodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodes.offer(treeNode.right);
                }
                //2 层：[3,7,9]
                //3 层：[12,8,6,2]
                if (i == 0 && jo == 0 && treeNode.val % 2 == 0) {
                    return false;
                }
                if (size == 1) {
                    if (jo % 2 == 0 && treeNode.val % 2 == 0) {
                        return false;
                    }
                    if (jo % 2 != 0 && treeNode.val % 2 != 0) {
                        return false;
                    }

                } else if (i > 0 && jo % 2 == 0 && (temp >= treeNode.val || temp % 2 == 0 || treeNode.val % 2 == 0)) {
                    return false;
                } else if (i > 0 && jo % 2 != 0 && (temp <= treeNode.val || temp % 2 != 0 || treeNode.val % 2 != 0)) {
                    return false;
                }
                temp = treeNode.val;
            }
            jo++;
        }


        return true;
    }

    public static void main(String[] args) {
        //new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        //[1,10,4,3,null,7,9,12,8,6,null,null,2]

        //System.out.println(new Solution().specialArray(new int[]{3, 6, 7, 7, 0}));
        //System.out.println(new Solution().specialArray(new int[]{0, 0}));
        //System.out.println(new Solution().specialArray(new int[]{0, 4, 3, 0, 4}));
        //System.out.println(new Solution().specialArray(new int[]{3, 5}));
        //System.out.println(new Solution().specialArray(new int[]{2}));
        //[11,18,14,3,7,null,null,null,null,18,null,6]
        //[17,48,44,15,null,17,40]
        TreeNode node = new TreeNode(17);
        node.left = new TreeNode(48);
        node.left.left = new TreeNode(15);
        node.right = new TreeNode(44);
        node.right.left = new TreeNode(17);
        node.right.right = new TreeNode(40);
        System.out.println(new Solution().isEvenOddTree(node));

    }

}