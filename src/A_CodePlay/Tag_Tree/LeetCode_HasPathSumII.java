package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II 中等
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class LeetCode_HasPathSumII {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        backtrack(root, sum, new ArrayList<>());
        return res;
    }

    public void backtrack(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            backtrack(root.left, sum, list);
            backtrack(root.right, sum, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;

        node4.left = node11;
        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node44;

        node44.left = node55;
        node44.right = node1;

        LeetCode_HasPathSumII l = new LeetCode_HasPathSumII();
        System.out.println(l.pathSum(node5, 22));
    }
}
