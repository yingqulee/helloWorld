package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 155. 最小栈 简单
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 链接：https://leetcode-cn.com/problems/min-stack
 */
public class LeetCode_155_MinStack {

    static class MinStack {

        LinkedList<Integer> stack;
        int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            int x = stack.pop();
            if (x == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int a = minStack.min();
        minStack.pop();
        int b = minStack.top();
        int c = minStack.min();
        System.out.println(a + " " + b + " " + c);
    }
}
