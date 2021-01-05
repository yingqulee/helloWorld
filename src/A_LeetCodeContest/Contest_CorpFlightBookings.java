package A_LeetCodeContest;

import java.util.Arrays;

/**
 * 5118. 航班预订统计
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */
public class Contest_CorpFlightBookings {

    /**
     * 处理区间端点，把每个区间上的起点 + 对应的订座数，
     * 终点的下一位 - 对应的订座数，即可表示整个区间的值,
     * 然后利用前缀和数组计算答案
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] temp = new int[n+1];

        for (int i = 0; i < bookings.length; i++){
            int one = bookings[i][0];
            int two = bookings[i][1];

            temp[one-1] += bookings[i][2];
            temp[two] -= bookings[i][2];
        }

        for (int i = 1; i < n ; i++)
            temp[i] += temp[i-1];

        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = temp[i];

        return result;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] a = corpFlightBookings(bookings,5);
        System.out.println(Arrays.toString(a));
    }
}
