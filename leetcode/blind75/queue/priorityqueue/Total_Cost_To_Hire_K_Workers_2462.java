package queue.priorityqueue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 2462.https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/19 17:22:48
 * @since JDK8.0
 */
public class Total_Cost_To_Hire_K_Workers_2462 {

    public static void main(String[] args) {
        Total_Cost_To_Hire_K_Workers_2462 s = new Total_Cost_To_Hire_K_Workers_2462();
        Total_Cost_To_Hire_K_Workers_2462.Solution solution = s.new Solution();

//        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int[] costs = {31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        int k = 11, candidates = 2;
        long reuslt = solution.totalCost(costs, k, candidates);
        System.out.println("result:" + reuslt);

    }

    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            int i = 0;
            int j = costs.length - 1;
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            long ans = 0;
            while (k-- > 0) {
                // get the candidates
                while (pq1.size() < candidates && i <= j) {
                    pq1.offer(costs[i++]);
                }
                while (pq2.size() < candidates && i <= j) {
                    pq2.offer(costs[j--]);
                }

                // 如果一邊已經沒有了，就是單純比對另一邊
                // EX: 左邊沒了，右邊受下 [81, 91]
                // 這樣比較就是 MAX_VALUE 跟 81 取 min
                int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
                int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

                if (t1 <= t2) {
                    ans += t1;
                    pq1.poll();
                } else {
                    ans += t2;
                    pq2.poll();
                }
            }
            return ans;
        }
    }
}
