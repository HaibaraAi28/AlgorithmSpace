package com.fcd.interview.huawei;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class t4 {

    public static void main(String[] args) {

    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int scoreOfParentheses(String S) {
        char[] chars = S.toCharArray();

        Stack<Integer> stack = new Stack<>();
        int index = 1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                int pair = stack.pop();
                map.put(pair, i);
                index++;
            }
        }

        return process(chars, 0, chars.length - 1);
    }

    public int process(char[] chars, int left, int right) {
        if (left + 1 == right) {
            return 1;
        }

        if (chars[left] == '(' && chars[left+1] == '(') {
            int pair = map.get(left); //获得对应右括号下标
            if (pair < right) {
                return 2 * process(chars, left + 1, map.get(left) - 1) + process(chars, pair + 1, right);
            } else {
                return 2 * process(chars, left + 1, map.get(left) - 1);
            }
        } else if (chars[left] == '(' && chars[left+1] == ')') {
            if (left + 1 < right) {
                return 1 + process(chars, left + 2, right);
            }
        }

        return 0;
    }
}
