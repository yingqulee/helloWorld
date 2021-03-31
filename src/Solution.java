import java.util.*;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Node {
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

    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    //700. 二叉搜索树中的搜索
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST1(root.left, val) : searchBST1(root.right, val);
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
        return root;
    }



    //290. 单词规律
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(str[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(str[i])) {
                    return false;
                } else {
                    map.put(key, str[i]);
                }
            }
        }
        return true;
    }

    //714. 买卖股票的最佳时机含手续费
    public static int maxProfit1(int[] prices, int fee) {
        int noKeep = 0, keep = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出。两者取较大值。
            noKeep = Math.max(noKeep, keep + prices[i] - fee);
            //对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入。两者取较大值。
            keep = Math.max(keep, noKeep - prices[i]);
        }
        return noKeep;
    }

    //714. 买卖股票的最佳时机含手续费
    public static int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    //387. 字符串中的第一个唯一字符
    public static int firstUniqChar(String str) {
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (s.indexOf(c) == s.lastIndexOf(c)) {
//                return i;
//            }
//        }
//        return -1;

        int[] cnts = new int[26];

        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i) - 'a']++;

        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    //188. 买卖股票的最佳时机 IV
    /**
     当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
     的贪心方法解决可以大幅提升时间性能, 对于其他的k, 可以采用 买卖股票的最佳时机 III
     的方法来解决, 在III中定义了两次买入和卖出时最大收益的变量, 在这里就是k组这样的
     变量, 即问题IV是对问题III的推广
     **/
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= (len/2)) {
            return maxProfitI(prices);
        }

        int[][] dp = new int[k+1][prices.length];
        for (int n = 1; n <= k; n++) {
            int curMax = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[n][i] = Math.max(dp[n][i-1], prices[i] + curMax);
                curMax   = Math.max(curMax, dp[n-1][i-1] - prices[i]);
            }
        }
        return dp[k][prices.length-1];
    }
    private int maxProfitI(int[] prices) {
        if(prices.length == 0) return 0;
        int cur = prices[0];
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    //98. 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return helper98(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper98(TreeNode root, long min, long max){
        if(root == null) return true;

        if(min >= root.val) return false;
        if(max <= root.val) return false;

        return helper98(root.right, root.val, max) && helper98(root.left, min, root.val) ;
    }

    //90. 子集 II
    List<List<Integer>> list90 = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return list90;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return list90;
    }

    public void backtrack(int[] nums, int start, List<Integer> list) {
        if (start == nums.length + 1) {
            return;
        }
        list90.add(new ArrayList<>(list));
        int visited = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (visited == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
            visited = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 4, 4, 1, 4};
        String str = "loveleetcode";
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(array));
    }
}
