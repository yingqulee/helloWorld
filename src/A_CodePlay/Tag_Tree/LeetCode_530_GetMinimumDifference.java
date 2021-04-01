package A_CodePlay.Tag_Tree;

/**
 * 530. 二叉搜索树的最小绝对差 简单
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 */
public class LeetCode_530_GetMinimumDifference {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    //二叉搜索树中序遍历得到的值序列是递增有序的
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMin(root);
        return min;
    }

    private void findMin(TreeNode root) {
        if (root == null) {
            return;
        }
        findMin(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        findMin(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node3;
        node3.left = node2;

        LeetCode_530_GetMinimumDifference l = new LeetCode_530_GetMinimumDifference();
        System.out.println(l.getMinimumDifference(node1));
    }
}
