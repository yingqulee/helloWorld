package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 227. 基本计算器 II 中等
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 *
 * 提示:
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class LeetCode_227_Calculate {

    /* sign == '+', push(num) */
    /* sign == '-', push(-num) */
    /* sign == '*', push(top * num) */
    /* sign == '/', push(top / num) */
    /* 每个循环更新sign = ch, num清零 */
    /* 最后把栈里数据进行累加          */
    public int calculate(String s) {
        // 保存上一个符号，初始为 +
        char sign = '+';
        LinkedList<Integer> stack = new LinkedList<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 加减乘除空格的ASCII码都小于'0'
            if (chars[i] >= '0') {
                num = num * 10 - '0' + chars[i];
            }
            if ((chars[i] < '0' && chars[i] != ' ') || i == chars.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                // 记录当前符号
                sign = chars[i];
                // 数字清零
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_227_Calculate l = new LeetCode_227_Calculate();
        System.out.println(l.calculate(" 3+5 / 2 "));
    }
}
