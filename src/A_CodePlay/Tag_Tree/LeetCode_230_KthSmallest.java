package A_CodePlay.Tag_Tree;

import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素 中等
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 */
public class LeetCode_230_KthSmallest {

    private int count = 0;
    private int ans = 0;
    //使用递归“中序遍历”
    private void find(TreeNode node){
        if (node == null){
            return;
        }

        find(node.left);
        count--;
        if (count == 0){
            this.ans = node.val;
        }
        find(node.right);
    }

    public int kthSmallestI(TreeNode root, int k) {
        count = k;
        find(root);
        return ans;
    }

    /** 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     *
     * 在栈的帮助下，可以将方法一的递归转换为迭代，这样可以加快速度，因为这样可以不用遍历整个树，可以在找到答案后停止。
     */
    public int kthSmallestII(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        LeetCode_230_KthSmallest test = new LeetCode_230_KthSmallest();
        System.out.println(test.kthSmallestII(treeNode1,1));

    }
}
