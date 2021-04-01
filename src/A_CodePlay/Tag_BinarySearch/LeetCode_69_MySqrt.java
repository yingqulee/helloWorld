package A_CodePlay.Tag_BinarySearch;

/**
 * 69. x 的平方根 简单
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class LeetCode_69_MySqrt {

    /**
     * 牛顿迭代法
     * 使用牛顿法可以得到一个正实数的算术平方根，因为题目中说“结果只保留整数部分”，因此，我们把使用牛顿法得到的浮点数转换为整数即可
     *
     * 在迭代过程中，以直线代替曲线，用一阶泰勒展式（即在当前点的切线）代替原曲线，求直线与 xx 轴的交点，重复这个过程直到收敛
     * @param x
     * @return
     */
//    public static int mySqrt(int x) {
//        if (x <= 1) return x;
//
//        long result = x;
//        while (result * result > x){
//            result = (result + x / result) / 2;
//        }
//        return (int)result;
//    }

    public static double mySqrt_Binary(int x) {
        if (x <= 1){
            return x;
        }
        double l = 1, r = x;
        double res = 0;
        while(l <= r) {
            double mid = (l + r) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt_Binary(8));
    }
}
