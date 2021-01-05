package A_LeetCodeContest;

/**
 * 给你一棵二叉树的根节点 root，找出这棵树的每一棵子树的平均值中的最大值。
 *
 * 子树是树中的任意节点和它的所有后代构成的集合。
 *
 * 树的平均值是树中节点值的总和除以节点数。
 *
 * 输入：[5,6,1]
 * 输出：6.00000
 * 解释：
 * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
 * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
 * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
 * 所以答案取最大值 6。
 */
public class Contest_MaximumAverageSubtree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return res;
    }
    private int[] helper(TreeNode root){
        int[] ans = new int[2];
        ans[0] = 1;//节点数
        ans[1] = root.val;

        if (root.left != null){
            int[] temp = helper(root.left);
            ans[0] += temp[0];
            ans[1] += temp[1];
        }
        if (root.right != null){
            int[] temp = helper(root.right);
            ans[0] += temp[0];
            ans[1] += temp[1];
        }
        res = Math.max(res,1.0 * ans[1] / ans[0]);//最大平均值
        return ans;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(1);
        r1.left = r2;
        r1.right = r3;

        Contest_MaximumAverageSubtree test = new Contest_MaximumAverageSubtree();
        System.out.println(test.maximumAverageSubtree(r1));
    }
}
