package com.demo.thinkinjava.algorithm.QueueAndStack;

import java.util.Stack;

/**
 * @author FBI
 * 逆波兰表达式求值
 *根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意 两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 */
public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        Stack<String> stackRpn = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(stackRpn.size()<=1){
                stackRpn.push(tokens[i]);
                continue;
            }
            switch (tokens[i]){
                case "+":{
                    Integer int2 = Integer.valueOf(stackRpn.pop());
                    Integer int1 = Integer.valueOf(stackRpn.pop());
                    stackRpn.push(String.valueOf(int1+int2));
                    break;
                }
                case "-":{
                    Integer int2 = Integer.valueOf(stackRpn.pop());
                    Integer int1 = Integer.valueOf(stackRpn.pop());
                    stackRpn.push(String.valueOf(int1-int2));
                    break;
                }
                case "*":{
                    Integer int2 = Integer.valueOf(stackRpn.pop());
                    Integer int1 = Integer.valueOf(stackRpn.pop());
                    stackRpn.push(String.valueOf(int1*int2));
                    break;
                }
                case "/":{
                    Integer int2 = Integer.valueOf(stackRpn.pop());
                    Integer int1 = Integer.valueOf(stackRpn.pop());
                    stackRpn.push(String.valueOf(int1/int2));
                    break;
                }
                default:{
                    stackRpn.push(tokens[i]);
                }
            }
        }
        return Integer.valueOf(stackRpn.pop());
    }

    public static void main(String[] args) {
        String[] evl = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(EvalRPN.evalRPN(evl));

    }
}
