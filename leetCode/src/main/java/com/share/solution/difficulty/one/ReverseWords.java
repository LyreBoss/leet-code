package com.share.solution.difficulty.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * @author Lgq create on 2020/8/30
 */
public class ReverseWords {

    public String reverseWords(String s) {

        if (s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();


        return "";
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";


        StringBuffer buffer = new StringBuffer();

        String[] split = s.split(" ");
        int length = split.length;
        for (int i1 = 0; i1 < split.length; i1++) {
            String subS = split[i1];
            char[] chars = subS.toCharArray();
            int be = 0;
            int en = chars.length - 1;
            for (int i = 0; i < chars.length; i++) {
                if (be >= en) {
                    break;
                }
                char temp = chars[i];
                chars[i] = chars[en];
                chars[en] = temp;
                be += 1;
                en -= 1;
            }
            if (i1 < length-1) {
                buffer.append(chars).append(" ");
            } else {
                buffer.append(chars);
            }
        }

        System.out.println(buffer.toString());
    }
}
