package A_CodePlay.Tag_Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化 中等
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 */
public class LeetCode_331_IsValidSerialization {

    //使用栈 https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-h-jghn/

    /**
     * 我们可以定义一个概念，叫做槽位。一个槽位可以被看作「当前二叉树中正在等待被节点填充」的那些位置。
     * 二叉树的建立也伴随着槽位数量的变化。每当遇到一个节点时：
     * 如果遇到了空节点，则要消耗一个槽位；
     * 如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。
     */
    public boolean isValidSerializationI(String preorder) {
        int len = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < len) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字 因为数字可能是多位数 例如:123
                while (i < len && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    //不需要栈
    public boolean isValidSerializationII(String preorder) {
        int num = 0; //记录#的个数
        char[] chars = preorder.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ',') {
                continue;
            }
            if (chars[i] == '#') {
                num++;
            } else {
                while (i >= 0 && preorder.charAt(i) != ',') {
                    i--;
                }
                if (num >= 2) { // #的个数>=2，消除2个#，消除一个节点数字并转换成#
                    num--;
                } else {
                    return false; // #的个数不足2，证明false
                }
            }
        }
        return num == 1; // 最终#的个数须==1
    }

    public static void main(String[] args) {
        LeetCode_331_IsValidSerialization l = new LeetCode_331_IsValidSerialization();
        System.out.println(l.isValidSerializationII("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
