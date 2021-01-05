package A_LeetCodeContest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 */
public class Contest_NumEquivDominoPairs {

    public static int numEquivDominoPairs(int[][] dominoes) {
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            int temp = dominoes[i][0]*10+dominoes[i][1];
            if (map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }
            else map.put(temp,1);
        }
        for (int key : map.keySet()){
            int value = map.get(key);
            if (value >= 2){
                cnt += (value * (value - 1) / 2);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }
}
