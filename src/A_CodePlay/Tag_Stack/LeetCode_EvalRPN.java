package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值 中等
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 */
public class LeetCode_EvalRPN {

    //用栈模拟操作
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        String sign = "+-/*";
        for (int i = 0; i < tokens.length; i++) {
            if (sign.indexOf(tokens[i]) != -1) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (tokens[i].equals("+")) {
                    stack.push(num2 + num1);
                } else if (tokens[i].equals("-")) {
                    stack.push(num2 - num1);
                } else if (tokens[i].equals("*")) {
                    stack.push(num2 * num1);
                } else {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        LeetCode_EvalRPN l = new LeetCode_EvalRPN();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(l.evalRPN(tokens));
    }
}
