package A_CodePlay.Tag_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树 中等
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class NewCoder_ReConstructBinaryTree {

    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> map = new HashMap<>();
    /**
     * 思路:前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = map.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    private void printTree(TreeNode treeNode) {
        if (treeNode == null) return;
        printTree(treeNode.left);
        System.out.print(treeNode.val+" ");
        printTree(treeNode.right);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        NewCoder_ReConstructBinaryTree tree = new NewCoder_ReConstructBinaryTree();
        TreeNode treeNode = tree.reConstructBinaryTree(pre, in);
        tree.printTree(treeNode);
    }
}
