package com.share.solution.difficulty.one;


/**
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * @author Lgq create on 2020/8/26
 */
public class SpiralOrder {


    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1}};

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }

    public int[] spiralOrder(int[][] matrix) {

        int slen = matrix.length;
        int hlen = matrix[0].length;
        int res[] = new int[slen * hlen];

        for (int i = 0; i < slen; i++) {
            for (int i1 = 0; i1 < hlen; i1++) {
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;

        ListNode a = dummy;
        ListNode b = pHead;

        while(b!=null) {
            if(a.next.val!=b.val) {
                a = a.next;
                b = b.next;
            }
            else {
                while(b!=null && a.next.val==b.val) {
                    b = b.next;
                }
                a.next = b;
                b = (b==null) ? null : b.next;
            }
        }
        return dummy.next;

    }


}
