package A_CodePlay.Tag_Tree;

/**
 * 剑指 Offer 26. 树的子结构 中等
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class NewCoder_HasSubtree {
    public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return helper(root1,root2) || hasSubtree(root1.left,root2) || hasSubtree(root1.right,root2);
    }

    private static boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return helper(root1.left,root2.left) && helper(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);

        TreeNode sub1 = new TreeNode(8);
        TreeNode sub2 = new TreeNode(9);
        TreeNode sub3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        sub1.right = sub3;
        sub1.left = sub2;

        System.out.println(hasSubtree(t1,sub1));
    }
}
