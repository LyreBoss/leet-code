package com.share.solution.difficulty.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数
 * ，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author Lgq create on 2020/9/6
 */
public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen("", result, n, n);

        return result;
    }

    private void gen(String subString, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.println(subString);
            result.add(subString);
            return;
        }
        if (left > 0) {
            gen(subString + "(", result, left - 1, right);
        }
        if (right > left) {
            gen(subString + ")", result, left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
