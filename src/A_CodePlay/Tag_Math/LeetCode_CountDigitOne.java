package A_CodePlay.Tag_Math;

/**
 * 233. 数字 1 的个数 困难
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：6
 * 解析: 1, 10, 11, 12, 13 包含 6 个 1
 *
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 */
public class LeetCode_CountDigitOne {

    public int countDigitOne(int n) {
        int num = n, i = 1, sum = 0;
        while(num > 0){
            if(num % 10 == 0){
                sum += (num/10)*i;
            }
            if(num % 10 == 1){
                sum += ((num / 10) * i + (n % i) + 1);
            }
            if(num%10>1){
                sum += Math.ceil(num/10.0)*i;
            }
            num=num/10;
            i=i*10;
        }
        return sum;

        /**
         * 思路: 数学归纳
         *
         */
//        int cnt = 0;
//        for (int i = 1; i <= n; i *= 10) {
//            int a = n / i, b = n % i;
//            cnt += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
//        }
//        return cnt;
    }


    public static void main(String[] args) {
        LeetCode_CountDigitOne l = new LeetCode_CountDigitOne();
        System.out.println(l.countDigitOne(13));
    }
}
