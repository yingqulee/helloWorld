package A_CodePlay.Tag_HashTable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 454. 四数相加 II 中等 (标签: 哈希表)
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class LeetCode_FourSumCount {

    /**
     * 思路:
     * 将数组A，B 任意组合的和存入查找表中， key是和，value 是出现的次数。
     * 记录C，D 任意组合的和的负值，然后在查找表中查找是否有对应的值 时间复杂度：O(n^2)
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> ans = new LinkedHashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                ans.put(A[i]+B[j],ans.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j= 0; j < D.length; j++) {
                count += ans.getOrDefault( -C[i]-D[j],0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
