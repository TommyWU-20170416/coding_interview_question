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
         * test1
         * 解法:
         * dp[i] 表示從第 i 個開始到 TOP 要花多少費用
         * 前兩個 0 跟 1，因為是可以直接算所以放入到 dp[i] 內，並從第 2 個開始算
         */
//        public int minCostClimbingStairs(int[] cost) {
//            int n = cost.length;
//            int[] dp = new int[n];
//            dp[0] = cost[0];
//            dp[1] = cost[1];
//
//            for (int i = 2; i < n; i++) {
//                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
//            }
//
//            return Math.min(dp[n - 1], dp[n - 2]);
//        }

        /**
         * test2:
         * <p>反向思考，從頂端開始回推</p>
         * 若從頂端開始，就是從 0 開始，往前找到每一次的最小並加總
         */
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n + 1];
            dp[n] = 0; // 從頂部到頂部的花費是 0
            dp[n - 1] = cost[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
            }

            return Math.min(dp[0], dp[1]);
        }
    }
}
