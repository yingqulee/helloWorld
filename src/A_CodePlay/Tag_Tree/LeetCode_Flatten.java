package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表 中等
 *
 * 定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class LeetCode_Flatten {

    //在还没操作节点右子树前，不能破坏该节点的右子树指向。所以采用后序遍历。
    public static void flattenI(TreeNode root) {
        if (root == null) {
            return;
        }
        //先把左右子树捋直
        flattenI(root.left);
        flattenI(root.right);
        TreeNode node = root.right; //把捋直的右子树备份一下
        root.right = root.left; //把捋直的左子树放到右边
        root.left = null;     //记得把左子树置空
        while (root.right != null) { //找到现在右子树的最后一个node
            root = root.right;
        }
        root.right = node; //把捋直的原来的右子树接上去
    }

    //前序遍历和展开同步进行 在不丢失子节点的信息的情况下，将前序遍历和展开为单链表同时进行
    public static void flattenII(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.poll();
            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }
            TreeNode left = cur.left, right = cur.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            pre = cur;
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node4;

        node1.left = node2;
        node1.right = node3;

        node4.right = node5;
        flattenII(root);
    }
}
