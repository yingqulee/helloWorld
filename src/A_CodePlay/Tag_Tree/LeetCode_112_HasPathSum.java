package A_CodePlay.Tag_Tree;

/**
 * 112. 路径总和 简单
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 */
public class LeetCode_112_HasPathSum {

    //思路：递归调用会经过每一个节点, 所以每遇到一个节点都用sum - 当前节点; 当sum == 0 时 判断当前是否走到了叶子节点
    public boolean flag = false;

    public boolean hasPathSum1(TreeNode root, int sum) {
        helper112(root, sum);
        return flag;
    }//使用辅助函数
    public void helper112(TreeNode root, int sum) {
        if (null == root) {
            return;
        }
        sum -= root.val;
        if (sum == 0 && null == root.left && null == root.right) {
            flag = true;
        } else {
            helper112(root.left, sum);
            helper112(root.right, sum);
        }
    }

    //递归调用本身
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }
}
