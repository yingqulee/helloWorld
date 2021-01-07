package A_LeetCodeContest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**5052. 最大层内元素和 (1161)
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 */
public class Contest_MaxLevelSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //dfs
    int[] tree = new int[201];
    public int maxLevelSumI(TreeNode root) {
        dfs(root, 1);
        int res = 0, max = 0;
        for (int i = 1; i < 201; i++) {
            if (tree[i] > max) {
                max = tree[i];
                res = i;
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        tree[level] += root.val;
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

    //bfs
    public int maxLevelSumII(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = Integer.MIN_VALUE;
        int res = -1;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            int curSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                curSum += curNode.val;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            if (curSum > sum) {
                sum = curSum;
                res = level;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
