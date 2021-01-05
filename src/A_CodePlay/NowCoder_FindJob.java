package A_CodePlay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NowCoder_FindJob {

    private static void findJob(int n, int m){
        Scanner in = new Scanner(System.in);

        Map<Integer,Integer> map = new HashMap<>();
        int[] diff = new int[n+m];//工作的难度
        int[] power = new int[m];//能力值

        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            diff[i] = key;
            map.put(key,value);
        }


        for (int i = 0; i < m; i++) {
            power[i] = in.nextInt();
            diff[n+i] = power[i];

            if (!map.containsKey(power[i])){
                map.put(power[i],0);
            }
        }

        Arrays.sort(diff);

        int max = 0;
        for (int i = 0; i < n + m; i++) {//把能力值对应的报酬put进map
            max = Math.max(max,map.get(diff[i]));
            map.put(diff[i],max);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(map.get(power[i]));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        findJob(n,m);
    }
}
