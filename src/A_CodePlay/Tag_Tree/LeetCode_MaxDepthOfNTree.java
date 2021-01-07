package A_CodePlay.Tag_Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. N 叉树的最大深度 简单
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class LeetCode_MaxDepthOfNTree {

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //递归
    public int maxDepthI(Node root) {
        if (null == root) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int res = 0;
        for (Node node : root.children) {
            res = Math.max(res, maxDepthI(node));
        }
        return res + 1;
    }

    //广度遍历
    public int maxDepthII(Node root) {
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         int dept = 0;
         while (!queue.isEmpty()) {
             dept += 1;
             int level = queue.size();
             while (level --> 0) {
                 Node node = queue.poll();
                 if (node.children != null) {
                     queue.addAll(node.children);
                 }
             }
         }
         return dept;
    }

    public static void main(String[] args) {

    }
}
