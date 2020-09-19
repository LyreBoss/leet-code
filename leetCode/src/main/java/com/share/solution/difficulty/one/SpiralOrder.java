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
