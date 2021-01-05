package A_CodePlay.Tag_Math;

/**
 * 	剑指 Offer 64 求1+2+…+n  中等
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B:C）。
 */
public class NewCoder_SumSolution {

    /**
     * 使用递归解法最重要的是指定返回条件，但是本题无法直接使用 if 语句来指定返回条件。
     *
     * 条件与 && 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句。
     * 利用这一特性，将递归的返回条件取非然后作为 && 的第一个条件语句，递归的主体转换为第二个条件语句，
     * 那么当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回。
     *
     * 本题的递归返回条件为 n <= 0，取非后就是 n > 0；递归的主体部分为 sum += sumSolution(n - 1)，
     * 转换为条件语句后就是 (sum += Sum_Solution(n - 1)) > 0。
     */
    public static int sumSolution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }

    //等差数列求和
    public static int sumSolution01(int n) {
        return (int) (Math.pow(n, 2) + n) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sumSolution01(10));
    }
}
