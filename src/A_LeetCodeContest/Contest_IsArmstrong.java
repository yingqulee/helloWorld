package A_LeetCodeContest;

/**
 * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 *
 * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：153
 * 输出：true
 * 示例：
 * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 * 示例 2：
 *
 * 输入：123
 * 输出：false
 * 解释：
 * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 */
public class Contest_IsArmstrong {

    public static boolean isArmstrong(int N) {
        int num1 = N, sum = 0, count = 0;
        while(num1 != 0){
            count++;
            num1 /= 10;
        }
        int num2 = N;
        while(num2 != 0){
            sum += Math.pow(num2 % 10, count);
            num2 /= 10;
        }
        return sum == N;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(2));
    }
}
