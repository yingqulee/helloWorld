package A_CodePlay.Tag_DynamicProgramming;

/**
 * 509. 斐波那契数 简单
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 */
public class LeetCode_509_Fibonacci {

    public static int fib(int N) {
        if (N == 0 || N == 1)
            return N;
        /*int[] f = new int[31];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i < f.length; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        return f[N];*/


        /*int tempX = 0, tempY = 1, ans = 1, index = 0, end = N-2;
        while (index++ <= end) {
            ans = tempX + tempY;
            tempX = tempY;
            tempY = ans;
        }
        return ans;*/

        int a = 0, b = 1;
        int res = 1;
        while (N --> 1) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
    }
}
