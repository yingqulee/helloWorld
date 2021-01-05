package A_CodePlay.Tag_Stack;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列 中等
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 *
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
 * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class NewCoder_IsPopOrder {

    public static boolean IsPopOrder(int[] pushNums, int[] popNums) {
        int n = pushNums.length;
        Stack<Integer> stack = new Stack<>();

        for (int pushIdx = 0, popIdx = 0; pushIdx < n; pushIdx++) {
            stack.push(pushNums[pushIdx]);
            while (popIdx < n && !stack.isEmpty() && stack.peek() == popNums[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushSequence = {1,2,3,4,5};
        int[] popSequence = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushSequence,popSequence));
    }
}
