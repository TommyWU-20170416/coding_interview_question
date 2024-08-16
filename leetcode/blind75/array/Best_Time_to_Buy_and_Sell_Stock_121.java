package array;

/**
 * 121.https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/15 17:05:44
 * @since JDK8.0
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_121 ss = new Best_Time_to_Buy_and_Sell_Stock_121();
        Best_Time_to_Buy_and_Sell_Stock_121.Solution s = ss.new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = s.maxProfit(prices);
        System.out.println(result);
    }

    class Solution {
        /**
         * Runtime: 2 ms, Beats 70.46%
         * 雖然比較慢，但 1 ms 的答案也是這樣
         *
         * 找最小的同時，也去看是不是最大 profit
         */
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            return maxProfit;
        }
    }
}
