package A_LeetCodeContest;

/**5147. 递减元素使数组呈锯齿状
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 */
public class Contest_MovesToMakeZigzag {

    public static int movesToMakeZigzag(int[] nums) {
        int[] tmp = new int[nums.length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) tmp[i] = nums[i];

        int nres = 0;
        for (int i = 1; i < nums.length; i+=2) {
            if (i != nums.length - 1)
                nres += Math.max(0, Math.max(nums[i] - nums[i-1] + 1, nums[i] - nums[i+1] + 1));
            else {
                nres += Math.max(0, nums[i] - nums[i-1] + 1);
            }
        }
        res = nres;
        nres = 0;
        for (int i = 0; i < nums.length; i+=2) {
            if (i == 0) {
                nres += Math.max(0, nums[i] - nums[i+1] + 1);
            } else if (i == nums.length - 1) {
                nres += Math.max(0, nums[i] - nums[i-1] + 1);
            } else {
                nres += Math.max(0, Math.max(nums[i] - nums[i-1] + 1, nums[i] - nums[i+1] + 1));
            }
        }
        res = Math.min(res, nres);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[] {1,2,3}));
    }
}
