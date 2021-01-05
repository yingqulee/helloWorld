package A_CodePlay.Tag_Tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树 简单
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class NewCoder_IsBalancedTree {

    /**
     * 平衡二叉树左右子树高度差不超过 1。
     */
    public boolean isBalancedTree(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
