package A_CodePlay.Tag_Array;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子 简单
 *
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 *
 * 输入:[1,0,3,4,5]
 * 输出:true;
 *
 * 输入:[1,2,4,6,7]
 * 输出:false;
 */
public class NewCoder_IsContinuous {

    public static boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int num : numbers) {//统计可以变化的个数
            if (num == 0) {
                count++;
            }
        }
        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            System.out.println(numbers[i + 1] - numbers[i] - 1);
            count -= numbers[i + 1] - numbers[i] - 1;

        }
        return count >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,4,5};
        System.out.println(isContinuous(nums));
    }
}
