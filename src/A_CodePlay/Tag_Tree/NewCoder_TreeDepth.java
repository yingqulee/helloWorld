package A_CodePlay.Tag_Tree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度 简单
 *
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class NewCoder_TreeDepth {

    public int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);

        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;

        NewCoder_TreeDepth t = new NewCoder_TreeDepth();
        System.out.println(t.treeDepth(root));
    }
}
