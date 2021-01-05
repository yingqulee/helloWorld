package A_CodePlay.Tag_BinarySearch;

/**
 * 剑指 Offer 74. 搜索二维矩阵 中等
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class NewCoder_Find {

    /**
     * 思路:
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
     * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
     * 当前元素的查找区间为左下角的所有元素。
     */
    public static boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int r = 0, c = array[0].length - 1; // 从右上角开始
        while (r <= array.length - 1 && c >= 0) {
            if (target > array[r][c]) {
                r++;//下一行
            } else if (target == array[r][c]) {
                return true;
            } else {
                c--;//下一列
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(find(5,array));
    }
}
