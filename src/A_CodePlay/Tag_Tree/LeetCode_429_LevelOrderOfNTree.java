package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历 中等
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class LeetCode_429_LevelOrderOfNTree {
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
    //广度优先遍历 模板
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevelList = new ArrayList<>();

            while (size --> 0) {
                Node node = queue.poll();
                curLevelList.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(curLevelList);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
