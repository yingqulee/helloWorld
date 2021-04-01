package A_CodePlay.Tag_OrderedMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * 846. 一手顺子 中等
 * 爱丽丝有一手（hand）由整数数组给定的牌。 
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *  
 *
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 */
public class LeetCode_846_IsNStraightHand {

    //顺子原理(有bug 面对偶数连续数组过不了 8, 10, 12)
    public boolean isNStraightHand_BUG(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        int[] res = new int[W];
        for (int num : hand) { //每张牌在每组里都有对应的位置
            res[num % W]++;
        }
        for (int i = 0; i < W - 1; i++) {
            if (res[i] != res[i + 1]) {//如果都是顺子的话，每个位置上牌的数量应该相等
                return false;
            }
        }
        return true;
    }
    public boolean isNStraightHandI(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : hand) {
            list.add(num);
        }
        while (!list.isEmpty()) {
            int min = list.get(0);
            list.remove(new Integer(min)); //不是对象的话 默认是按下标移除
            for (int i = 1; i < W; i++) {
                int num = min + i;
                if (!list.contains(num)) {
                    return false;
                }
                list.remove(new Integer(num));
            }
        }
        return true;
    }

    public boolean isNStraightHandII(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int num: hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        while (count.size() > 0) {
            int start = count.firstKey();
            for (int i = 0; i < W; i++) {
                if (!count.containsKey(start + i)) { //没有则返回
                    return false;
                }
                if (count.get(start + i) == 1) { //用完了，移除
                    count.remove(start + i);
                }
                else if (count.get(start + i) > 1) { //消耗一次， 更新
                    count.put(start + i, count.get(start + i) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_846_IsNStraightHand l = new LeetCode_846_IsNStraightHand();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int W = 3;
        System.out.println(l.isNStraightHandII(hand, W));
    }
}
