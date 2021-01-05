package A_CodePlay.Tag_BitManipulation;

/**
 * 剑指 Offer 15. 二进制中1的个数 简单
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NewCoder_NumberOfOne {

    public static int numberOfOne01(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 思路:位操作
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     */
    public static int numberOfOne02(int n) {
        int count = 0;

        while(n != 0){
            count++;
            n &= n - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne02(-10));
    }
}
