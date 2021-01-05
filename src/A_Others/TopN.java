package A_Others;

/**
 * 如何在10亿个数中找到前1000大的数: 大数据的TopN问题
 *
 * 建立小顶堆,剩下的与堆顶相比,如果比堆顶小的就直接舍去,如果比堆顶大就替换堆顶并调整最小堆
 */
public class TopN {

    // 父节点
    private int parent(int n) {
        return (n - 1) / 2;
    }

    // 左孩子
    private int left(int n) {
        return 2 * n + 1;
    }

    // 右孩子
    private int right(int n) {
        return 2 * n + 2;
    }

    // 构建堆
    private void buildHeap(int n, int[] data) {
        for(int i = 1; i < n; i++) {
            int t = i;
            // 调整堆
            while(t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    private void adjust(int i, int n, int[] data) {
        if(data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶
        int t = 0;
        while( (left(t) < n && data[t] > data[left(t)])
                || (right(t) < n && data[t] > data[right(t)]) ) {
            if(right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public void findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for(int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }

        print(n,data);
    }

    // 打印前N个大的数
    public void print(int n,int[] data) {

        for(int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {19,23,45,76,234,46,33,4,12,465,23,56,79,124,34,62,12,6,58,13,67,112,35};
        TopN topN = new TopN();
        topN.findTopN(10,a);
    }
}
