package A_LeetCodeContest;

/**5128. 最深叶节点的最近公共祖先
 *
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，<font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">S</font>
 * 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 */
public class Contest_LcaDeepestLeaves {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 思路:
     * 如果该节点的左右子树的深度相等，且左右子树的深度均为最大深度，则该节点为目标节点，返回该节点即可，时间复杂度O(n).
     * 另外一种解法，将从根节点到所有最大深度的叶子节点路径存储起来，找到所有路径的最后一个相同的节点，该节点即为最近的父节点
     */
    private static int depth (TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }


    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) return root;
        if (left > right) return lcaDeepestLeaves(root.left);
        return lcaDeepestLeaves(root.right);
    }

    public static void main(String[] args) {

    }
}
