import java.util.*;

public class main {

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

    //746. 使用最小花费爬楼梯
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len <= 1) {
            return cost[0];
        }
        for (int i = 2; i < len; i++) {
            cost[i] = Math.min(cost[i - 1] + cost[i], cost[i - 2] + cost[i]);
        }
        return Math.min(cost[len - 1], cost[len - 2]);
    }

    //103. 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size --> 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0,node.val);
                }
            }
            level += 1;
            res.add(list);
        }
        return res;
    }

    static List<String> res257 = new ArrayList<>();
    //257. 二叉树的所有路径
    public static List<String> binaryTreePaths(TreeNode root) {
        dfs257(root, "");
        return res257;
    }
    public static void dfs257(TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (root.right == null && root.left == null) {
            res257.add(cur);
        }
        dfs257(root.left, cur + "->");
        dfs257(root.right, cur + "->");
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

    //135. 分发糖果 总体思路: 每个孩子的左右边都要考虑;
    public static int candy(int[] ratings) {
        int res = 0;
        int[] candies = new int[ratings.length]; //记录每位学生的糖果数
        candies[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }

    //455. 分发饼干
    //贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) { //当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
                child++;
            }
            cookie++; // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
        }
        return child;
    }

    //559. N 叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
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

    static List<List<Integer>> res46 = new ArrayList<>();
    //46. 全排列
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return res46;
        }
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>());
        return res46;
    }

    public static void backtrack(int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            res46.add(new ArrayList<>(list)); //我们需要的是其中的在某个特定时期的内容，所以一定要进行拷贝。
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
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

    //102. 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size --> 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    //107. 二叉树的层序遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size --> 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(0,list);
        }
        return res;
    }

    //100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }

    //563. 二叉树的坡度
    int res563 = 0;
    public int findTilt(TreeNode root) {
        count(root);
        return res563;
    }
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        res563 += Math.abs(left - right);
        return root.val + left + right;
    }

    //653. 两数之和 IV - 输入 BST
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int target = list.get(left) + list.get(right);
            if (target == k) {
                return true;
            } else if (target < k){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
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

    //404. 左叶子之和
    //递归
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (null != root.left && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }
    //广度优先搜索
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

    //110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        //调用104题的最大深度代码
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return helper101(root.left, root.right);
    }
    public boolean helper101(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper101(left.left, right.right) && helper101(left.right, right.left);
    }

    //112. 路径总和
    public boolean flag = false;
    public boolean hasPathSum1(TreeNode root, int sum) {
        helper112(root, sum);
        return flag;
    }//使用辅助函数
    public void helper112(TreeNode root, int sum) {
        if (null == root) {
            return;
        }
        sum -= root.val;
        if (sum == 0 && null == root.left && null == root.right) {
            flag = true;
        } else {
            helper112(root.left, sum);
            helper112(root.right, sum);
        }
    }
    //递归调用本身
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        int[] array = {1, 0, 0, 0, 1};
        String str = "loveleetcode";
        System.out.println((array));
    }
}
