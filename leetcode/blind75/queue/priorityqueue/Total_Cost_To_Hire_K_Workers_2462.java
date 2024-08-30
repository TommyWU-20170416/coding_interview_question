package queue.priorityqueue;

import java.util.*;

/**
 * 2462.https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/19 17:22:48
 * @since JDK8.0
 * <p>
 * 這題一開始會看不懂 candidates 意思，candidates 意思就是從頭或尾取出的數量，假設 costs 長度為 7，如果 candidates = 3 就是在頭 3 跟 尾 3 的費用中挑出便宜的
 */
public class Total_Cost_To_Hire_K_Workers_2462 {

    public static void main(String[] args) {
        Total_Cost_To_Hire_K_Workers_2462 s = new Total_Cost_To_Hire_K_Workers_2462();
        Total_Cost_To_Hire_K_Workers_2462.Solution solution = s.new Solution();

        // practice the empty
//        int[] costs = {1, 2, 4, 1};
//        int k = 3, candidates = 3;
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3, candidates = 4;
//        int[] costs = {31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
//        int k = 11, candidates = 2;
        long reuslt = solution.totalCost(costs, k, candidates);
        System.out.println("result:" + reuslt);

    }

    class Solution {
        /**
         * Runtime: 21 ms, Beats 95.50%
         */
        public long totalCost(int[] costs, int k, int candidates) {
            long result = 0;
            // 如果 candidates * 2 + k > costs.length，因為超出整個範圍，所以等同排序後由小到大挑 k 個出來看
            if (candidates * 2 + k > costs.length) {
                Arrays.sort(costs);
                for (int i = 0; i < k; i++) {
                    result += costs[i];
                }
                return result;
            }
            // 添加候選人到 pq 內
            PriorityQueue<Integer> pqLeft = new PriorityQueue<>(), pqRight = new PriorityQueue<>();
            int left = 0, right = costs.length - 1;
            for (int i = 0; i < candidates; i++) {
                pqLeft.offer(costs[left++]);
                pqRight.offer(costs[right--]);
            }
            // 如果 pq 是空的，代表接下來就無限取對方，所以回傳 Integer.MAX_VALUE
            while (k-- > 0) {
                int numLeft = pqLeft.size() > 0 ? pqLeft.peek() : Integer.MAX_VALUE;
                int numRight = pqRight.size() > 0 ? pqRight.peek() : Integer.MAX_VALUE;
                // 如果cost一樣，要挑小的，<= 這樣就可以挑出最小的
                if (numLeft <= numRight) {
                    result += pqLeft.poll();
                    pqLeft.offer(costs[left++]);
                } else {
                    result += pqRight.poll();
                    pqRight.offer(costs[right--]);
                }
            }
            return result;
        }
    }
}