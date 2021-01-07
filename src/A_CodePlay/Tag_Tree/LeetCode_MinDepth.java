package A_CodePlay.Tag_Tree;

import java.util.*;

/**
 * 111. 二叉树的最小深度 简单
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class LeetCode_MinDepth {

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    //广度优先搜索 定义 QueueNode
    //当找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
    public int minDepthI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }

    //广度优先搜索模板
    public int minDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return 0;
    }

    //递归
    public int minDepthIII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepthIII(root.right) + 1;
        }
        if (root.right == null) {
            return  minDepthIII(root.left) + 1;
        }
        return Math.min(minDepthIII(root.left), minDepthIII(root.right)) + 1;
    }
}
