package A_CodePlay.Tag_String;

/**
 * 38. 外观数列 简单
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class LeetCode_38_CountAndSay {

    /**
     * 本题的难点在于：报数的概念理解，至少我从题意中没有很清晰的理解，但是感觉像是个递推式
     * 从4->5分析，将4个每一位拆开看（个数+数字），4=1211 => 1=11，2=12，11=21，所以5=111221
     * 所以解题用循环，从1->n可求解出来
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String str = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();

            char pre = str.charAt(0);
            int count = 1;

            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }

            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
