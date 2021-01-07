package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//LeetCode上的 树的 前中后序遍历 非递归版
public class LeetCode_TreeTraversal {

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x){
            val = x;
        }
    }

    /**
     * 144. 二叉树的前序遍历 中等
     */
    static List<Character> res;
    static LinkedList<TreeNode> stack;

    public static List<Character> preoderTraversalI(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 94. 二叉树的中序遍历 中等
     */
    public static List<Character> inorderTraversalI(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 145. 二叉树的后序遍历 中等
     */
    public static List<Character> postorderTraversalI(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    /**
     * 统一模板
     */
    //前序遍历
    public static List<Character> preoderTraversalII(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //一直往左压入栈
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }

    //中序遍历
    public static List<Character> inorderTraversalII(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
             while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //后续遍历
    public static List<Character> postorderTraversalII(TreeNode root) {
        res = new ArrayList<>();
        stack = new LinkedList<>();
        TreeNode pre = null; //用来记录上一节点
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
//            后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
//            如果是从右边再返回根结点，应该回到上层。
            //主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list了
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                stack.pop();
                pre = root;
                root = null;
            } else {
                root = root.right;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode('A');
        TreeNode p2 = new TreeNode('B');
        TreeNode p3 = new TreeNode('C');
        TreeNode p4 = new TreeNode('D');
        TreeNode p5 = new TreeNode('E');
        TreeNode p6 = new TreeNode('F');
        TreeNode p7 = new TreeNode('G');
        TreeNode p8 = new TreeNode('H');
        TreeNode p9 = new TreeNode('I');
        p6.left = p2;
        p6.right = p7;

        p2.left = p1;
        p2.right = p4;

        p4.left = p3;
        p4.right = p5;

        p7.right = p9;
        p9.left = p8;
        System.out.println(preoderTraversalI(p6));
    }
}
