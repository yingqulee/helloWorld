package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1022. 从根到叶的二进制数之和 简单
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 示例 1：
 *         1
 *       / \
 *     0    1
 *   / \  / \
 *  0  1 0   1
 *
 *  输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers*/
public class LeetCode_1022_SumRootToLeaf {

    List<String> res = new ArrayList<>();

    public int sumRootToLeafI(TreeNode root) {
        helper(root, new StringBuilder());
        int ans = 0;
        for (String s : res) {
            ans += Integer.valueOf(s, 2);
        }
        return ans;
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            helper(root.left, sb);
            helper(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumRootToLeafII(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        LeetCode_1022_SumRootToLeaf l = new LeetCode_1022_SumRootToLeaf();
        System.out.println(l.sumRootToLeafII(node1));
    }
}
