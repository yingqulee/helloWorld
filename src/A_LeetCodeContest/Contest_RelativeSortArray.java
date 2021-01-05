package A_LeetCodeContest;

import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 
 */
public class Contest_RelativeSortArray {

    public static int[] relativeSortArray01(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int index = 0;

        Map<Integer,Integer> help = new HashMap<>();
        for (int num : arr2) {
            help.put(num,0);
        }

        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++){
                if (arr1[j] == arr2[i]){
                    ans[index++] = arr2[i];
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if (help.containsKey(arr1[i]))
                help.put(arr1[i],1);
            else ans[index++] = arr1[i];
        }

        return ans;
    }
    
    public static int[] relativeSortArray02(int[] arr1, int[] arr2) {
        /**
         * 思路: 桶排序
         */
        int[] count = new int[1010];
        for (int num : arr1) {
            count[num]++;
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while(count[arr2[i]] > 0){
                ans[index++] = arr2[i];
                count[arr2[i]]--;
            }
        }
        //没有在arr2数组中的
        for (int i = 0; i < 1010; i++) {
            while(count[i] > 0){
                ans[index++] = i;
                count[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray01(arr1,arr2)));
    }
}
