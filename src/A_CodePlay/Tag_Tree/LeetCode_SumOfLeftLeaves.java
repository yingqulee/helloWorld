package A_CodePlay.Tag_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和 简单
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 */
public class LeetCode_SumOfLeftLeaves {
    //404. 左叶子之和
    //递归
    public static int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (null != root.left && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }
    //广度优先搜索
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);

        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;

        System.out.println(sumOfLeftLeaves2(root));
    }
}
