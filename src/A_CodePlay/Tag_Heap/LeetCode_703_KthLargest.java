package A_CodePlay.Tag_Heap;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素 简单
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 */
public class LeetCode_703_KthLargest {
    /**
     * 维护一个最小堆，堆的元素个数为常量 k，新加入一个元素和堆顶比较，
     * 如果比堆顶元素小，丢弃，否则删除堆顶元素，插入新元素。
     *
     * 超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
     */

    final PriorityQueue<Integer> minHeap;
    final int size;

    public LeetCode_703_KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k);
        this.size = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size){
            minHeap.offer(val);
        } else if (val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        LeetCode_703_KthLargest KthLargest = new LeetCode_703_KthLargest(3,nums);
        System.out.println(KthLargest.add(3));
        System.out.println(KthLargest.add(5));
        System.out.println(KthLargest.add(10));
        System.out.println(KthLargest.add(9));
        System.out.println(KthLargest.add(4));
    }
}
