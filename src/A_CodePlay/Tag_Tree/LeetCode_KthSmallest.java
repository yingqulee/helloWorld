package A_CodePlay.Tag_Tree;

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
public class LeetCode_KthSmallest {

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

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        find(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        LeetCode_KthSmallest test = new LeetCode_KthSmallest();
        System.out.println(test.kthSmallest(treeNode1,1));

    }
}
