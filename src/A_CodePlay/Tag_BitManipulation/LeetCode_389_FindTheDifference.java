package A_CodePlay.Tag_BitManipulation;

/**
 * 389. 找不同 简单
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_389_FindTheDifference {

    //计数方式
    public static char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += t.charAt(i);
            sum -= s.charAt(i);
        }
        sum += t.charAt(t.length() - 1);
        return (char)sum;
    }

    //位运算 拼接 s 和 t 问题等同与 136. 只出现一次的数字
    public static char findTheDifferenceI(String s, String t) {
        int sum = 0;
        String str = s + t;
        for (char c : str.toCharArray()) {
            sum ^= c;
        }
        return (char)sum;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifferenceI("abcd","abcde"));
    }
}
