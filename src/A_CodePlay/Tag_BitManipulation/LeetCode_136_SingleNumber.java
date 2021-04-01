package A_CodePlay.Tag_BitManipulation;


public class LeetCode_136_SingleNumber {
    /** 136. 只出现一次的数字 简单
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 异或运算和乘法一样，位置和运算顺序不影响最后结果：a^b^c = b^c^a
     * 两个相同的数做异或运算结果为零：a^a = 0
     * 任何数和零做异或结果还是这个数本身：a^0 = a
     */
    public static int singleNumber_01(int[] nums) {
        int result = 0;

        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    /** 137. 只出现一次的数字 II 中等
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     *
     * 位运算是基于位的，而不是基于数的，在这个问题中，所有的 bit 的出现次数只会有两种情况，3n，3n+1,
     * 这里的 n 是任意整数，假设你遍历数组，其实会有一个中间态就是 3n+2 存在，对于除这个数以外的其他数，
     * 过程大概是 3n+1 -> 3n+2 -> 3n，我们只要记录的就是 3n+1 和 3n+2 的情况，因为 3n 其实就是一个初始状态（n=0）,
     * 记不记录和我们最后要返回的答案无关，而记录 3n+2 是为了恢复一些 bit 从 3n+2 到 3n
     */
    public static int singleNumber_02(int[] nums) {
        int ones = 0, twos = 0;

        for (int n : nums) {
            //既不在出现一次的 ones ，也不在出现两次的 twos 里面，我们就记录下来，出现了一次，再次出现则会抵消
            ones = (n ^ ones) & (~twos);

            //既不在出现两次的 twos 里面，也不在出现一次的 ones 里面(不止一次了)，记录出现两次，第三次则会抵消
            twos = (n ^ twos) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,4,1};
        System.out.println(singleNumber_01(a));

        int[] b = {2,2,3,2};
        System.out.println(singleNumber_02(b));
    }
}
