package com.demo.thinkinjava.algorithm.QueueAndStack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 简单
 * 3.6K
 * 相关企业
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class EffectiveBrackets {


    /**
     * 有效括号
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> inStack = new Stack<>();

        char[] brackets = s.toCharArray();
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(') {
                inStack.push(')');
            } else if (brackets[i] == '{') {
                inStack.push('}');
            } else if (brackets[i] == '[') {
                inStack.push(']');
            } else {
                if (inStack.empty()) {
                    return false;
                }
                if (inStack.pop() != brackets[i]) {
                    return false;
                }
            }
        }
        //如果只有左括号进去 则为false
        if (!inStack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "()[]{}";
        String s = "{[]}";
        boolean valid = EffectiveBrackets.isValid(s);
        System.out.println(valid);
    }
}
