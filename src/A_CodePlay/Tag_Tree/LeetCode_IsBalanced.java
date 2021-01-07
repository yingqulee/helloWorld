package A_CodePlay.Tag_Tree;

import static A_CodePlay.Tag_Tree.LeetCode_MaxDepth.maxDepth;

/**
 * 110. 平衡二叉树 简单
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class LeetCode_IsBalanced {

    //110. 平衡二叉树
    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        //调用104题的最大深度代码
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
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

        System.out.println(isBalanced(root));
    }
}
