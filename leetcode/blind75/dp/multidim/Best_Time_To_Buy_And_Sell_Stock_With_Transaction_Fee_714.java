package dp.multidim;

/**
 * 714.https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/29 23:19:05
 * @since JDK8.0
 */
public class Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_714 {
    public static void main(String[] args) {
        Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_714 s = new Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_714();
        Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_714.Solution solution = s.new Solution();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = solution.maxProfit(prices, fee);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 20 ms, Beats 44.82%
         * 解法:
         * 把 dp[i][0] 表尚未買股票當前的價值，dp[i][1] 表已持有股票當前的價值
         * 初始化第 0 天尚未買股票就是 0, 第 0 天若持有股票就是 -prices[0]
         * <p>
         * 從第一天開始
         * dp[i][0] = MAX( 第 i - 1 天繼續未持有股票價值, 第 i - 1 天持有股票  ，第 i 天賣掉，手續費 )
         * dp[i][1] = MAX( 第 i - 1 天繼續　持有股票價值, 第 i - 1 天不持有股票，第 i 天買 )
         */
//        public int maxProfit(int[] prices, int fee) {
//            int n = prices.length;
//            int[][] dp = new int[n][2];
//
//            dp[0][0] = 0;
//            dp[0][1] = -prices[0];
//
//            for (int i = 1; i < n; i++) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//            }
//
//            return dp[n - 1][0];
//        }

        /**
         * Runtime: 5 ms, Beats 77.70%
         * 改變 dp table
         * 由於只在意最後的輸出，所以我們可以簡化 dp[][] 改成 dp[]
         */
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
                dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            }
            return dp[0];
        }
    }
}
