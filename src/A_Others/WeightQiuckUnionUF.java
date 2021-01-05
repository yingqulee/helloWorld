package A_Others;

//加权quick-union + 路径压缩
public class WeightQiuckUnionUF {

    private int[] parent; //父链接数组
    private int[] weight; //各个根节点锁对应的分量的大小
    private int count;    //连通分量的个数

    public WeightQiuckUnionUF(int VERTICES){
        count = VERTICES;

        parent = new int[VERTICES];
        for (int i = 0; i < VERTICES; i++) {
            parent[i] = i;
        }

        weight = new int[VERTICES];
        for (int i = 0; i < VERTICES; i++) {
            weight[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int x){ //路径压缩
        int root = x;
        //如果该节点不是根节点,就循环找到根节点
        while (root != parent[root]){
            root = parent[root];
        }
        while (x != parent[x]) {
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }
        return root;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }
        if (weight[pRoot] < weight[qRoot]){
            parent[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        }else {
            parent[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        WeightQiuckUnionUF uf = new WeightQiuckUnionUF(10);
        int[][] edges = {
                {4,3},{3,8},{6,5},{9,4},{2,1},
                {5,0},{7,2},{6,1}
        };
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            if (uf.connected(p,q))continue;
            uf.union(p,q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }
}
