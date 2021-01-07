package A_CodePlay.Tag_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 中等
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class LeetCode_BuildTree {
    // 缓存中序遍历数组每个值对应的索引
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++)
            map.put(in[i],i);
        return helper(pre, 0, pre.length - 1, 0);
    }

    private TreeNode helper(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = map.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = helper(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = helper(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
