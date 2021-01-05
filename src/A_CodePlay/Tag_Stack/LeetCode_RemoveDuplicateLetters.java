package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 316. 去除重复字母 中等
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class LeetCode_RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            //当前字符在栈顶元素之前，且栈顶元素在后面还有
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static String removeDuplicateLetters1(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26]; //记录字母最后一次出现的位置
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        LinkedList<Character> stack = new LinkedList<>();
        boolean[] visited = new boolean[26]; //字母是否在栈中出现过
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > chars[i] && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;

            }
            stack.push(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters1("cbacdcbc"));
    }
}
