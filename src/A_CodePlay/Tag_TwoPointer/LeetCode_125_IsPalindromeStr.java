package A_CodePlay.Tag_TwoPointer;

/**
 * 125. 验证回文串 简单
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class LeetCode_125_IsPalindromeStr {

    //使用StringBuilder
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    //双指针法
    public static boolean isPalindromes(String s) {
        s = s.toLowerCase();
        int head = 0, tail = s.length()-1;
        while(head < tail){
            while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) head++;
            while (head < tail && !Character.isLetterOrDigit(s.charAt(tail))) tail--;
            if (s.charAt(head) != (s.charAt(tail))) return false;
            head++;
            tail--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromes(s));
    }
}
