package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.List;

public class NewCoder_FindPath {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(root.left, target, path);
            dfs(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode p2 = new TreeNode(11);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(2);
        left.left = p2;
        p2.left = p3;
        p2.right = p4;

        TreeNode right = new TreeNode(8);
        TreeNode p6 = new TreeNode(13);
        TreeNode p7 = new TreeNode(4);
        TreeNode p8 = new TreeNode(5);
        TreeNode p9 = new TreeNode(1);
        right.left = p6;
        right.right = p7;
        p7.left = p8;
        p7.right = p9;

        root.left = left;
        root.right = right;

        NewCoder_FindPath f = new NewCoder_FindPath();
        List<List<Integer>> path = f.findPath(root, 22);
        System.out.println(path);
    }
}