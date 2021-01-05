package A_CodePlay.Tag_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 763. 划分字母区间 中等
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 */
public class LeetCode_PartitionLabels {

    /**
     * 遍历字符串 找到和起点相同的最后一个字母
     * 查看此区间里的字母最后的index是否超出区间
     * 超出则更新区间 直至找到最大的index
     * 则index - i + 1就是所求区间长度 使用chars来存储每个字母的最后出现位置
     *
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() == 0 || S == null) {
            return res;
        }
        int[] chars = new int[26];// record the last index of the each char
        for (int i = 0; i < S.length(); i++) {
            chars[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        System.out.println(Arrays.toString(chars));
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, chars[S.charAt(i)-'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }
}
