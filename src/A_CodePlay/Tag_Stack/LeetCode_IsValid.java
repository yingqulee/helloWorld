package A_CodePlay.Tag_Stack;

import java.util.*;

/**
 * 20. 有效的括号 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode_IsValid {
    /**
     * 1. 初始化栈 S。
     * 2. 一次处理表达式的每个括号。
     * 3. 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
     * 4. 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 5. 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
     * @param s
     * @return
     */

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(isValid(str));
    }
}
