package A_CodePlay.Tag_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树 简单
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class LeetCode_101_IsSymmetric {
    /**
     * 递归思想:
     *
     * 它们的两个根结点具有相同的值。
     * 每个树的右子树都与另一个树的左子树镜像对称。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric01(TreeNode root) {
        if(root == null)return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val ) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    /**
     * 迭代思想:
     *
     * 算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。
     * 然后，将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，
     * 或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束
     *
     * @param root
     * @return
     */
    public boolean isSymmetric02(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
