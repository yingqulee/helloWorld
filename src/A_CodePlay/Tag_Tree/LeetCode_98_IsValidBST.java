package A_CodePlay.Tag_Tree;

/**
 * 98. 验证二叉搜索树 中等
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class LeetCode_98_IsValidBST {

    //二叉搜索树的特性
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        if (root == null) return true;

        if (null != min && min >= root.val) return false;
        if (null != max && max <= root.val) return false;

        return helper(root.right, root.val, max) && helper(root.left, min, root.val) ;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        LeetCode_98_IsValidBST l = new LeetCode_98_IsValidBST();
        System.out.println(l.isValidBST(node2));
    }
}
