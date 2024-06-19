package queue.priorityqueue;


import java.util.PriorityQueue;

/**
 * 215.https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/19 11:08:31
 * @since JDK8.0
 */
public class Kth_Largest_Element_In_An_Array_215 {
    public static void main(String[] args) {
        Kth_Largest_Element_In_An_Array_215 s = new Kth_Largest_Element_In_An_Array_215();
        Kth_Largest_Element_In_An_Array_215.Solution solution = s.new Solution();
//        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 第一大的就是找到 priority queue 最後剩下的
         * 第二大的就是找到 priority queue 最後剩下的第一位 [5, 6]
         * 第三大的就是找到 priority queue 最後剩下的第一位 [4, 5, 6]
         * 第 K 大的就是找到 priority queue 最後剩下的第一位 [..., 4, 5, 6]
         */
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int num : nums) {
                if (minHeap.size() < k) {
                    minHeap.add(num);
                } else if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
            return minHeap.peek();
        }
    }
}
