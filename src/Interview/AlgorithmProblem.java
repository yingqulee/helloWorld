package Interview;

/**
 * 常见的面试算法题
 */
public class AlgorithmProblem {

    //题目: 给定一个数num, 求大于该数的最小2的n次幂, 返回n
    public int minNofNum(int num) {
        int n = 1;
        while (Math.pow(2, n) <= num) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        AlgorithmProblem a = new AlgorithmProblem();
        System.out.println(a.minNofNum(15));
    }
}
