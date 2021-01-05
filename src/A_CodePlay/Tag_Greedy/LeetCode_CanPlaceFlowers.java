package A_CodePlay.Tag_Greedy;

/**
 * 605. 种花问题 简单
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 */
public class LeetCode_CanPlaceFlowers {

    /**
     * 防御式编程思想：在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，
     * 任意位置处只要连续出现三个 0 就可以栽上一棵花。
     *
     * 优化 : 数0的时候给两边多加一就行了,
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0, zero = 1; //假设在数组左边添加0，以解决边界问题，令zero初始为1
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zero++;
            } else {
                zero = 0;
            }
            if (zero == 3) {//连续三个零可以种一朵花
                sum++;
                zero = 1;
            }
        }
        if (zero == 2) {//遍历完 如果还有两个零即意味着边际可以种一朵花
            sum++;
        }
        return sum >= n;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(array, 2));
    }
}
