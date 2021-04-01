package A_CodePlay.Tag_Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 222. 完全二叉树的节点个数 中等
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 */
public class LeetCode_222_CountNodes {

    //广度优先模板
    public int countNodesI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size --> 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    count++;
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    count++;
                    deque.offer(node.right);
                }
            }
        }
        return count;
    }

    /**
     * 完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     * 判断左右子树的高度:
     * 如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
     * 如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
     **/
    public int countNodesII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = search(root.left);
        int right = search(root.right);
        if (left == right) {
            return 1 + (1 << left) - 1 + countNodesII(root.right); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        }
        return 1 + (1 << right) - 1 + countNodesII(root.left); // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
    }

    public int search(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    /**
     * 利用完全二叉树的特性计算节点个数
     * 规定根节点位于第 0 层，完全二叉树的最大层数为 h。
     * 根据完全二叉树的特性可知，完全二叉树的最左边的节点一定位于最底层，因此从根节点出发，每次访问左子节点，
     * 直到遇到叶子节点，该叶子节点即为完全二叉树的最左边的节点，经过的路径长度即为最大层数 h。
     * 1.当最底层包含 1 个节点时，完全二叉树的节点个数是 2^h
     * 2.当最底层包含 2^h 个节点时，完全二叉树的节点个数是 2^(h+1) - 1
     * 因此对于最大层数为 hh 的完全二叉树，节点个数一定在 [2^h, 2^(h+1) - 1] 的范围内，可以在该范围内通过二分查找的方式得到完全二叉树的节点个数。
     * 具体做法是，根据节点个数范围的上下界得到当前需要判断的节点个数 k，
     * 如果第 k 个节点存在，则节点个数一定大于或等于 k，
     * 如果第 k 个节点不存在，则节点个数一定小于 k，由此可以将查找的范围缩小一半，直到得到节点个数。
     *
     * 如何判断第 k 个节点是否存在呢？如果第 k 个节点位于第 h 层，则 k 的二进制表示包含 h+1 位，其中最高位是 1，
     * 其余各位从高到低表示从根节点到第 k 个节点的路径，0 表示移动到左子节点，1 表示移动到右子节点。
     * 通过位运算得到第 k 个节点对应的路径，判断该路径对应的节点是否存在，即可判断第 k 个节点是否存在。
     */
    public int countNodesIII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (isExists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean isExists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
