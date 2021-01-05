package A_LeetCodeContest;

/**
 * 5117. IP 地址无效化
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 */
public class Contest_DefangIPaddr {

    public static String defangIPaddr(String address) {

        int n = address.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            result = address.replace(".","[.]");
        }
        return result;
    }

    public static void main(String[] args) {
        String address = "234.45.5.0";
        System.out.println(defangIPaddr(address));
    }
}
