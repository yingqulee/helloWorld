package A_CodePlay.Tag_Tree;

import java.util.*;

/**
 * 606. 根据二叉树创建字符串 简单
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 */
public class LeetCode_Tree2str {

    public String tree2strI(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    //递归
    private void dfs(TreeNode root,  StringBuilder sb){
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append("(");
            dfs(root.left, sb);
            sb.append(")");
            if (root.right != null) {
                sb.append("(");
                dfs(root.right, sb);
                sb.append(")");
            }
        }
    }

    //遍历
    public String tree2strII(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (set.contains(root)) {
                stack.pop();
                sb.append(")");
            } else {
                set.add(root);
                sb.append("(" + root.val);
                if (root.left == null && root.right != null) {
                    sb.append("()");
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return sb.substring(1, sb.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        LeetCode_Tree2str l = new LeetCode_Tree2str();
        System.out.println(l.tree2strII(node1));
    }
}
