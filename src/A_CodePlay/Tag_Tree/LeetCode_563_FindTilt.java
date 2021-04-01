package A_CodePlay.Tag_Tree;

/**
 * 563. 二叉树的坡度 简单
 *
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 */
public class LeetCode_563_FindTilt {

    int res563 = 0;
    public int findTilt(TreeNode root) {
        count(root);
        return res563;
    }
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        res563 += Math.abs(left - right);
        return root.val + left + right;
    }
}
