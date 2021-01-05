package A_LeetCodeContest;

import java.util.*;

public class test {

    private static void split01(String str){

    }

    //a-z的所有组合
    public static List<List<Character>> subset(char[] alphabet) {
        int len = alphabet.length;
        int n = 1 << len;
        List<List<Character>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Character> cur = new ArrayList<>();

            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(alphabet[j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    //找出不大于n的最大质数
    private static int prime(int n){
        if (n < 2)return 0;
        int res = 1;
        boolean[] temp = new boolean[n];
        Arrays.fill(temp,true);
        for (int i = 2; i < n; i++) {
            if (temp[i] == true){
                res = Math.max(res, i);
                for (int j = i + i; j < n; j += i) {
                    temp[j] = false;
                }
            }
        }
        return res;
    }

    //无序数组中的最大值,最小值
    private static int[] maxMin(int[] nums) {
        int[] res = new int[2];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        res[0] = max;
        res[1] = min;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2,7,100,9,10};
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
        };
        List<List<Character>> res = subset(alphabet);
//        System.out.println(res.size()-1);
//        System.out.println(prime(10));
        long round = Math.round(-10.6);
//        System.out.println(Arrays.toString(maxMin(nums)));
    }

}
