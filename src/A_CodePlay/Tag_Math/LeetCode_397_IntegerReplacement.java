package A_CodePlay.Tag_Math;

/**
 * 397. 整数替换 中等
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 */
public class LeetCode_397_IntegerReplacement {

    //递归
    public int integerReplacementI(int n) {
        return (int)helper((long)n);
    }

    public long helper(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return helper(n / 2) + 1;
        }
        return Math.min(helper(n + 1), helper(n - 1)) + 1;
    }

    //位运算
    public int integerReplacementII(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 3) == 3 && n != 3) {
                n++;
            } else if ((n & 1) == 1) {
                n--;
            } else {
                n = n >>> 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_397_IntegerReplacement().integerReplacementI(12));
    }
}
