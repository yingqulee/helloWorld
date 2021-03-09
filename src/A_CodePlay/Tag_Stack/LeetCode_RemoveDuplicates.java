package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项 简单
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class LeetCode_RemoveDuplicates {

    //使用栈
    public String removeDuplicatesI(String S) {
        char[] chars = S.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    //不用栈
    public String removeDuplicatesII(String S) {
        char[] chars = S.toCharArray();
        int index = -1;
        for (char c : chars) {
            if (index > -1 && chars[index] == c) {
                index--;
            } else {
                chars[++index] = c;
            }
        }
        return String.valueOf(chars, 0, index + 1);
    }
    public static void main(String[] args) {
        LeetCode_RemoveDuplicates l = new LeetCode_RemoveDuplicates();
        System.out.println(l.removeDuplicatesII("abbaca"));
    }
}
