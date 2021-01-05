package A_CodePlay.Tag_Math;

/**
 * 剑指 Offer  16. 数值的整数次方  中等
 *
 * 给定一个double类型的浮点数 base 和 int类型的整数exponent。求base的exponent次方。
 */
public class NewCoder_Power {

    /**
     * 思路:
     * base^n = (base * base)^n/2 base%2==0
     * base^n = base * (base * base)^n/2 base%2==1
     * 因为 (base * base)n/2 可以通过递归求解，并且每次递归 base 都减小一半，因此整个算法的时间复杂度为 O(logN)。
     */
    public static double power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;

        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;

        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        System.out.println(power(2.00,-2));
    }
}
