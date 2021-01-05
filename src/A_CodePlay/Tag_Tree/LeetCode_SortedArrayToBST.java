package A_CodePlay.Tag_Tree;

/**
 * 108. 将有序数组转换为二叉搜索树 简单
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class LeetCode_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : reBuildTree(nums, 0, nums.length - 1);
    }

    /**
     * 思路:  左右等分建立左右子树，中间节点作为子树根节点，递归该过程
     * (求中点不要用 int mid = (l + r)/2，有溢出风险，稳妥的方法是 int mid = l + (r-l)/2)
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode reBuildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = reBuildTree(nums, left, mid - 1);
        root.right = reBuildTree(nums, mid + 1, right);
        return root;
    }
}
