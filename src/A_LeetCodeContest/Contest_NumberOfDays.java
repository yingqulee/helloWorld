package A_LeetCodeContest;

import java.util.HashMap;
import java.util.Map;

/**
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 *
 * 示例 1：
 *
 * 输入：Y = 1992, M = 7
 * 输出：31
 * 示例 2：
 *
 * 输入：Y = 2000, M = 2
 * 输出：29
 * 示例 3：
 *
 * 输入：Y = 1900, M = 2
 * 输出：28
 */
public class Contest_NumberOfDays {

    public static int numberOfDays(int Y, int M) {
        if (M == 2){
            if (((Y % 100 != 0) && (Y % 4 == 0)) || ( Y % 400 == 0) ){
                return 29;
            }
            else return 28;
        }
        if (M == 4 || M == 6 || M == 9 || M == 11)
            return 30;
        return 31;
    }

    public static void main(String[] args) {
        System.out.println(numberOfDays(2000,1));
    }
}
