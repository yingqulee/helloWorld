package A_CodePlay.Tag_Tree;

/**
 * 235. 二叉搜索树的最近公共祖先 中等
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近
 */
public class LeetCode_235_LowestCommonAncestor {

    public static TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorI(root.left, p, q);
        TreeNode right = lowestCommonAncestorI(root.right, p, q);
        if(left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

    //思路:利用二叉搜索树的特点，如果p、q的值都小于root，说明p q 肯定在root的左子树中；
    //如果p q都大于root，说明肯定在root的右子树中，如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先
    public static TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorII(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorII(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        t5.left = t8;
        t5.right = t9;

        TreeNode root = t1;
        System.out.println(lowestCommonAncestorI(root,t2,t3).val);
    }
}
