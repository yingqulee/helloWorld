package A_CodePlay.Tag_BitManipulation;

/**
 * 342. 4的幂 简单
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class LeetCode_IsPowerOfFour {

    /**
     * 思路:
     *
     * 4的幂一定是2的。
     * 4的幂和2的幂一样，只会出现一位1。但是，4的1总是出现在奇数位。
     *
     * 由于 4=3+1， 那么4的N次方就是（3+1）^N，尝试展开多项式，比如(3+1)^2 =(3+1)*(3+1)，
     * 除了1*1以外永远都有3相乘，再展开3次方，(3+1)*(3+1)*(3+1)，
     * 结论一致，除了结尾的1都有3相乘，因此可以有结论，一个数的N次方-1总能除尽比这个数小1的数。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && num % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
}
