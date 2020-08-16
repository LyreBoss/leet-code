package com.share.solution.difficulty.one;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * @author Lgq create on 2020/8/14
 */
public class IsValid {


    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            private static final long serialVersionUID = -4928439567840979782L;

            {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        IsValid isValid = new IsValid();

        System.out.println(isValid.isValid("(({}[])))"));
    }
}
