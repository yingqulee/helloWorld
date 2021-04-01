package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历 简单
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class LeetCode_589_PreorderOfNTree {

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
    }

    List<Integer> res = new ArrayList<>();

    //使用递归解法
    public List<Integer> preorderI(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            helper(child);
        }
    }

    //非递归解法
    public List<Integer> preorderII(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i > 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
