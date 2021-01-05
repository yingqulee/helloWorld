package A_CodePlay.Tag_Tree;

/**
 * 剑指 Offer 27. 二叉树的镜像 简单
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class NewCoder_MirrorTree {

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {

    }
}
