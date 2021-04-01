package A_CodePlay.Tag_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果棒交换 简单
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 */
public class LeetCode_888_FairCandySwap {

    /**
     * 记爱丽丝的糖果棒的总大小为 sumA，鲍勃的糖果棒的总大小为 sumB。设答案为 {x,y}，
     * 即爱丽丝的大小为 x 的糖果棒与鲍勃的大小为 y 的糖果棒交换，则有如下等式：
     *                      sumA − x + y = sumB + x − y
     *                  ==> x = y + (sumA - sumB) / 2;
     * 即对于 B 中的任意一个数 y', 即对于 B 中的任意一个数 x', 满足 x' = y' + (sumA - sumB) / 2, 那么 {x', y'} 即为一组可行解。
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwapI(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            sumA += num;
            set.add(num);
        }
        for (int num : B) {
            sumB += num;
        }
        int diff = (sumA - sumB) / 2;
        for (int num : B) {
            if (set.contains(diff + num)) {
                return new int[] {diff + num, num};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] fairCandySwapII(int[] A, int[] B) {
        boolean[] flag = new boolean[100001];
        int diff = 0;
        for (int num : A) {
            diff -= num;
        }
        for (int num : B) {
            diff += num;
            flag[num] = true;
        }
        diff /= 2;
        for (int num : A) {
            int numb = num + diff;
            if (flag[numb]) {
                return new int[]{num, numb};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] A = {1,1};
        int[] B = {2,2};
        LeetCode_888_FairCandySwap leetCode_fairCandySwap = new LeetCode_888_FairCandySwap();
        System.out.println(Arrays.toString(leetCode_fairCandySwap.fairCandySwapII(A, B)));
    }
}
