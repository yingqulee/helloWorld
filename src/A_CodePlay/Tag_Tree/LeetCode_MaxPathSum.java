package A_CodePlay.Tag_Tree;

/**
 * 124. 二叉树中的最大路径和 困难
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class LeetCode_MaxPathSum {

    /**
     * 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     * 1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     * 2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        LeetCode_MaxPathSum l = new LeetCode_MaxPathSum();
        System.out.println(l.maxPathSum(node1));
    }
}
