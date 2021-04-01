package A_CodePlay.Tag_TwoPointer;

/**
 * 27. 移除元素 简单
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode_27_RemoveElement {

    /**
     * 双指针
     * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j] != val，
     * 我们就复制 nums[j]到 nums[i] 并同时递增两个索引。重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
     *
     * @param nums
     * @param value
     * @return
     */
    public static int removeElement(int[] nums,int value) {
        if (nums == null) return 0;

        int index = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != value){
                nums[index++] = nums[j];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(a,2));
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
