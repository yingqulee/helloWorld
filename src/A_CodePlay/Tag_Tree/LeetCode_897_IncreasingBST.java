package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 897. 递增顺序查找树 简单
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 */
public class LeetCode_897_IncreasingBST {

    //lee215大佬的解法 https://leetcode.com/problems/increasing-order-search-tree/discuss/165885/C%2B%2BJavaPython-Self-Explained-5-line-O(N)
    public TreeNode increasingBSTI(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode node = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return node;
    }

    //把这些节点的对应的值存放在数组中，它们已经有序。接着我们直接根据数组构件题目要求的树即可。
    public TreeNode increasingBSTII(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int value : list) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //辅助栈模拟中序遍历，并将原树重排，理解起来比较容易
    public TreeNode increasingBSTIII(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode pre = dummy;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                pre.right = cur;
                pre = pre.right;
            }
        }
        return dummy.right;
    }
}
