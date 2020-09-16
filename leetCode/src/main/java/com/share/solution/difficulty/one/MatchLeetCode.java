package com.share.solution.difficulty.one;


/**
 * 206周
 *
 * @author Lgq create on 2020/9/13
 */
public class MatchLeetCode {


    public int numSpecial(int[][] mat) {


        int res = 0;
        int rowsLen = mat.length;

        int colsLen = mat[0].length -1 ;

        int[] col = new int[colsLen];
        for (int i = 0; i < rowsLen; i++) {
           int temp = 0 ;
            while (mat[i][temp] == 1){
                col[temp] = 1 ;
            }
        }


        return res;
    }
}
