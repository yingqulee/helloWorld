package A_CodePlay.Tag_Math;

/**
 * 507. 完美数 简单
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 *  
 *
 * 示例：
 *
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *
 * 注意:
 *
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 */
public class LeetCode_CheckPerfectNumber {
    //暴力不可取
    public static boolean checkPerfectNumber01(int num) {
        int count = 0;
        for (int i = 1; i < num; i++) {
            if ( num % i == 0)
                count += i;
        }
        return count == num;
    }

    /**
     * 暴力遍历的话会超时。 所以我们只遍历到num的开平方，同时对遍历的每个能被num整除的数i加上num/i，
     * 就是另一个因子。这个地方要注意特殊条件“因子不能等于num”和特殊值“1”。 对所有因子求和后，比对是否和num相等
     */
    private static boolean checkPerfectNumber02(int num) {
        if(num == 1) return false;

        int n = (int)Math.ceil(Math.sqrt(num));
        int sum = 1;
        for (int i = 2; i < n; ++i) {
            if (num % i == 0) {
                sum += (i + num / i);
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber02(28));
    }
}
