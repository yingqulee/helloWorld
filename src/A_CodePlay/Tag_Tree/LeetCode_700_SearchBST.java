package A_CodePlay.Tag_Tree;

/**
 * 700. 二叉搜索树中的搜索 简单
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 */
public class LeetCode_700_SearchBST {

    /**
     * 思路：可以利用二叉搜索树的特点：
     * 若任意节点的左子树不空，
     * 则左子树上所有节点的值均小于它的根节点的值；若任意节点的右子树不空，
     * 则右子树上所有节点的值均大于或等于它的根节点的值；
     * 任意节点的左、右子树也分别为二叉查找树；
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
