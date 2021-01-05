package A_LeetCodeContest;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果出现下述两种情况，交易 可能无效：
 *
 *  交易金额超过 ¥1000
 *  或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 *
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 */
public class Contest_InvalidTransactions {

    public static List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        boolean[] invalid = new boolean[n];

        String[] names = new String[n];
        int[] times = new int[n];
        int[] amounts = new int[n];
        String[] cites = new String[n];

        for (int i = 0; i < n; i++) {
            String[] s = transactions[i].split(",");
            names[i] = s[0];
            times[i] = Integer.parseInt(s[1]);
            amounts[i] = Integer.parseInt(s[2]);
            cites[i] = s[3];
        }
        for (int i = 0; i < n; i++){
            if (amounts[i] > 1000) {
                invalid[i] = true;
            }
            for (int j = i + 1; j < n; j++) {
                if (names[i].equals(names[j]) && !cites[i].equals(cites[j]) && Math.abs(times[i]-times[j]) <= 60){
                    invalid[i] = invalid[j] = true;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                res.add(transactions[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] transactions = {
                "alice,20,800,mtv","alice,50,1200,mtv"
        };
        System.out.println(invalidTransactions(transactions));
    }
}
