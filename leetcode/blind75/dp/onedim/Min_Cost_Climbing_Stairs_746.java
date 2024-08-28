package dp.onedim;

/**
 * 746.https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/27 16:35:50
 * @since JDK8.0
 */
public class Min_Cost_Climbing_Stairs_746 {
    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs_746 s = new Min_Cost_Climbing_Stairs_746();
        Min_Cost_Climbing_Stairs_746.Solution solution = s.new Solution();
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 2, 3, 4, 5};
        int result = solution.minCostClimbingStairs(cost);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 解法:
         * dp[i] 表示從第 i 個開始到 TOP 要花多少費用
         *
         * EX: 如果是 [5, 10, 15] 對於要抵達 15 就要選擇前兩位最小的費用
         * 要抵達 TOP 就要選擇 dp[n-1] 和 dp[n-2] 中最小的費用，他是用這樣慢慢推上去，每次都去找前兩位 min 最後就可以得到最小費用
         */
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < n; i++) {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }

            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }
}
