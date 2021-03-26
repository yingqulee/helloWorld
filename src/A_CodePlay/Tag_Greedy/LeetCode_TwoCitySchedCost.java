package A_CodePlay.Tag_Greedy;

import java.util.Arrays;

/**
 * 1029. 两地调度 中等
 *
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 *
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class LeetCode_TwoCitySchedCost {

    public int twoCitySchedCost(int[][] costs) {
        int res = 0, len = costs.length;
        //假设都去A;
        for (int i = 0; i < len; i++) {
            res += costs[i][0];
        }

        // 再从其中找出去b市比较便宜的n个
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(arr);
        for (int i = 0; i < len / 2; i++) {
            res += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        LeetCode_TwoCitySchedCost l = new LeetCode_TwoCitySchedCost();
        System.out.println(l.twoCitySchedCost(costs));
    }
}
