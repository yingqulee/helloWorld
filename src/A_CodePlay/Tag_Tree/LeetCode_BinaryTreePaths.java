package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径 简单
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 */
public class LeetCode_BinaryTreePaths {

    static List<String> res257 = new ArrayList<>();
    //257. 二叉树的所有路径
    public static List<String> binaryTreePaths(TreeNode root) {
        dfs257(root, "");
        return res257;
    }
    public static void dfs257(TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (root.right == null && root.left == null) {
            res257.add(cur);
        }
        dfs257(root.left, cur + "->");
        dfs257(root.right, cur + "->");
    }
}
