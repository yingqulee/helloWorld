package A_CodePlay.Tag_Math;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字  本题与LeetCode 169 题相同
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NewCoder_MoreThanHalfNum {

    /**
     * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
     *
     * 使用 j 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 j++，否则令 j--。
     * 如果前面查找了 i 个元素，且 j == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，
     * 因为如果多于 i / 2 的话 j 就一定不会为 0 。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     *
     */
    public static int moreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];

        for (int i = 0, j = 0; i < nums.length; i++) {
            j = nums[i] == majority ? j + 1 : j - 1;
            if (j == 0) {
                majority = nums[i];
                j = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum_Solution(nums));

    }
}
