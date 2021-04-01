package A_CodePlay.Tag_Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀 简单
 *
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 */
public class LeetCode_1018_PrefixesDivBy5 {

    //如果每步计算 2 的幂，结果会越来越大，java 没有基本类型可以承受如此大的结果考虑采用每次结果的模进行计算
    //防止溢出的恒等式：(A*2+B)%5 == ((x+5*y)*2+B)%5 == (2*x+B)%5 == ((A%5)*2+B)%5
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur = ((cur % 5) * 2 + A[i]) % 5;
            res.add(cur % 5 == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0,1,1};
        System.out.println(prefixesDivBy5(A));
    }
}
