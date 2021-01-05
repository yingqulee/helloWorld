package A_CodePlay.Tag_BFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 433. 最小基因变化 中等
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 *
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 返回值: 1
 *
 * 示例 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 返回值: 2
 *
 * 示例 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 返回值: 3
 */
public class LeetCode_MinMutation {
    /**
     * 从start字符开始进行广度优先搜索，每次从队列中取出一个字符串，遍历bank，
     * 将与字符串仅差一个字符的字符串加入到队列中，并将加入后的字符标记为已探索，
     * 时间复杂度为(O(n^2) ，空间复杂度O(n)。
     */
    public static int minMutation(String start, String end, String[] bank) {
        // 使用队列进行广度优先搜索，分别记录探索的字符串与此时探索的深度
        Queue<String> queue_s = new LinkedList<String>();
        Queue<Integer> queue_times = new LinkedList<Integer>();
        int bank_length = bank.length;
        queue_s.offer(start);
        queue_times.offer(0);
        while (queue_s.peek() != null) {
            String last_s = queue_s.poll();
            int last_time = queue_times.poll();
            for (int k = 0; k < bank_length; k++){
                String s = bank[k];
                if (s == null){
                    continue;
                }
                int gap_num = 0;
                for (int i = 0; i < 8; i++){
                    if (last_s.charAt(i) != s.charAt(i)){
                        if (gap_num++ == 1){
                            break;
                        }
                    }
                }
                if (gap_num > 1){
                    continue;
                }else if (s.equals(end)){
                    return last_time + 1;
                }
                bank[k] = null;
                queue_s.offer(s);
                queue_times.offer(last_time + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        System.out.println(minMutation(start,end,bank));
    }
}
