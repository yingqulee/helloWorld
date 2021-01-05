package A_CodePlay.Tag_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树 中等
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class NewCoder_PrintFromTopToBottom {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-- > 0){
                TreeNode temp = queue.poll();
                if (temp == null)continue;
                list.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
