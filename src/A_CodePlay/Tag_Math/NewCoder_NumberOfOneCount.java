package A_CodePlay.Tag_Math;

/**
 * 剑指 Offer 43  1～n 整数中 1 出现的次数  困难
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NewCoder_NumberOfOneCount {

    public static int numberOf1Between1AndN_Solution(int n) {
//        StringBuffer ans = new StringBuffer();
//        for (int i = 1; i <= n; i++) {
//            ans.append(i);
//        }
//        String str = ans.toString();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '1')
//                count++;
//        }
//        return count;

        /**
         * 思路: 数学归纳
         *
         */
        int cnt = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            cnt += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN_Solution(13));
    }
}
