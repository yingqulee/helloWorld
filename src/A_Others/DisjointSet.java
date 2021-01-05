package A_Others;

import java.util.Arrays;

//并查集
public class DisjointSet {

    private static int VERTICES = 6;

    private static int findRoot(int[] parent, int x){//查找一个图的顶点并返回
        int xRoot = x;
            while(parent[xRoot] != -1){//如果该节点不是根节点,就循环找到根节点
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    /**
     * 1 union successfully
     * -1 union failed
     */
    private static int union(int p, int q, int[] parent, int[] size){//合并两个节点
        int pRoot = findRoot(parent,p);
        int qRoot = findRoot(parent,q);

        if (pRoot == qRoot){
            return 0;
        }else {
            if (size[pRoot] > size[qRoot]){
                parent[qRoot] = pRoot;
            }else {
                parent[pRoot] = qRoot;
                size[qRoot]++;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] parent = new int[VERTICES];
        int[] size = new int[VERTICES];//加权
        //所有的点更新为-1;
        Arrays.fill(parent,-1);
        Arrays.fill(size,0);

        int[][] edges = {
            {0,1},{1,2},
            {3,4},{4,5}
        };

        boolean cycle = false;
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            if (union(p,q,parent,size) == 0){
                cycle = true;
                break;
            }
        }
        if (cycle == true){
            System.out.println("Have Cycle");
        }else {
            System.out.println("No Cycle");
        }
    }
}
