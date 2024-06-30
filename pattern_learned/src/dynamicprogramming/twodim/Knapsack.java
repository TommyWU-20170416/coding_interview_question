package dynamicprogramming.twodim;

import dynamicprogramming.onedim.Climbing_Stairs_70;

/**
 * 沒有 leetcode 題目
 * DP 經典背包題目
 */
public class Knapsack {
    public static void main(String[] args) {
        Knapsack s = new Knapsack();
        Knapsack.Solution solution = s.new Solution();
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int w = 7;

        int result = solution.knapsack(weights, values, w);
        System.out.print(result);// Output: 9
    }

    /**
     * <h3>Example:</h3>
     *
     * <pre>
     * {@code
     *
     * int[] weights = {1, 3, 4, 5};
     * int[] values = {1, 4, 5, 7};
     * int w = 7;
     *
     * // DP Table:
     * //   --0 1 2 3 4 5 6 7
     * // 0  0 0 0 0 0 0 0 0 0
     * // 1  0 1 1 1 1 1 1 1 1
     * // 2  0 1 1 4 5 5 5 5 5
     * // 3  0 1 1 4 5 6 6 9 9
     * // 4  0 1 1 4 5 7 8 9 9
     * }
     * </pre>
     * <ul>隨機挑選解讀
     * <ol>
     *     <li>dp[2][3] 載重為 3 的時候，價值為 4，同等載重dp[1] 卻只有 1</li>
     *     <li>dp[2][4] 載重為 4 的時候，價值為 5 = 1 + 4</li>
     *     <li>dp[3][5] 載重為 5 的時候，價值為 6 = 1 + 5</li>
     *     <li>dp[4][6] 載重為 6 的時候，價值為 8 = 1 + 7</li>
     * </ol>
     * <p>
     * 依據這樣的設計，希望可以在 0 ~ W 的重量中，去尋找哪些商品相加會有最大值
     * 把 weights 本來只有四個，變成五個，他要做 i - 1，代表未放置之前，同理 w 也會多一 col, 代表重量為 0 的時候
     * i 從 1 開始看，因為 i = 0 的 row 都是 0 ，因為都沒有放東西也就沒有價值
     * </p>
     * </ul>
     *
     * <h3>步驟說明:</h3>
     *
     * <ul>
     *      <li>i = 1, 物品重量 1, 價值 1</li>
     *      <p>遍歷 重量時，從 w = 1 後才開始可以挑選該物品，否則都跟 dp[0][w] 一樣都是 0</p>
     *      <li>w = 0: 不能選擇物品，dp[1][0] = dp[0][0] = 0</li>
     *      <li>w = 1: 可以選擇物品，dp[1][1] = max(dp[0][1], dp[0][0] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 2: 可以選擇物品，dp[1][2] = max(dp[0][2], dp[0][1] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 3: 可以選擇物品，dp[1][3] = max(dp[0][3], dp[0][2] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 4: 可以選擇物品，dp[1][4] = max(dp[0][4], dp[0][3] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 5: 可以選擇物品，dp[1][5] = max(dp[0][5], dp[0][4] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 6: 可以選擇物品，dp[1][6] = max(dp[0][6], dp[0][5] + 1) = max(0, 0 + 1) = 1</li>
     *      <li>w = 7: 可以選擇物品，dp[1][7] = max(dp[0][7], dp[0][6] + 1) = max(0, 0 + 1) = 1</li>
     *      <p>在"可以選擇物品"取 max 的時候，觀察 max 第二個參數，他是用 dp[i-1][w-weights[i-1]]，這邊意思是 去找到上一個物品且重量在限制內的物品。等 i = 2 會比較了解</p>
     * </ul>
     * <ul>
     *      <li>i = 2, 物品重量 3, 價值 4</li>
     *      <li>w = 0: 不能選擇物品，dp[2][0] = dp[1][0] = 0</li>
     *      <li>w = 1: 不能選擇物品，dp[2][1] = dp[1][1] = 1</li>
     *      <li>w = 2: 不能選擇物品，dp[2][2] = dp[1][2] = 1</li>
     *      <li>w = 3: 可以選擇物品，dp[2][3] = max(dp[1][3], dp[1][0] + 4) = max(1, 0 + 4) = 4</li>
     *      <li>w = 4: 可以選擇物品，dp[2][4] = max(dp[1][4], dp[1][1] + 4) = max(1, 1 + 4) = 5</li>
     *      <li>w = 5: 可以選擇物品，dp[2][5] = max(dp[1][5], dp[1][2] + 4) = max(1, 1 + 4) = 5</li>
     *      <li>w = 6: 可以選擇物品，dp[2][6] = max(dp[1][6], dp[1][3] + 4) = max(1, 1 + 4) = 5</li>
     *      <li>w = 7: 可以選擇物品，dp[2][7] = max(dp[1][7], dp[1][4] + 4) = max(1, 1 + 4) = 5</li>
     *      <p>因為重量是 3 所以當 w = 3 的時後才開始挑選</p>
     *      <p>w = 3，會去找 dp[i-1][ w - weights[i-1] ] 也就是 dp[1][0]，因為當前 w = 3 扣掉第二個物件就是 0 了，所以沒辦法再把第一個物件加進來</p>
     *      <p>w = 4，因為載重夠，所以 第一個物品就可以加進來，變成 1 + 4 = 5</p>
     * </ul>
     * <ul>
     *      <li>i = 3, 物品重量 4, 價值 5</li>
     *      <li>w = 0: 不能選擇物品，dp[3][0] = dp[2][0] = 0</li>
     *      <li>w = 1: 不能選擇物品，dp[3][1] = dp[2][1] = 1</li>
     *      <li>w = 2: 不能選擇物品，dp[3][2] = dp[2][2] = 1</li>
     *      <li>w = 3: 不能選擇物品，dp[3][3] = dp[2][3] = 4</li>
     *      <li>w = 4: 可以選擇物品，dp[3][4] = max(dp[2][4], dp[2][0] + 5) = max(5, 0 + 5) = 5</li>
     *      <li>w = 5: 可以選擇物品，dp[3][5] = max(dp[2][5], dp[2][1] + 5) = max(5, 1 + 5) = 6</li>
     *      <li>w = 6: 可以選擇物品，dp[3][6] = max(dp[2][6], dp[2][2] + 5) = max(5, 1 + 5) = 6</li>
     *      <li>w = 7: 可以選擇物品，dp[3][7] = max(dp[2][7], dp[2][3] + 5) = max(5, 4 + 5) = 9</li>
     * </ul>
     * <ul>
     *      <li>i = 4, 物品重量 5, 價值 7</li>
     *      <li>w = 0: 不能選擇物品，dp[4][0] = dp[3][0] = 0</li>
     *      <li>w = 1: 不能選擇物品，dp[4][1] = dp[3][1] = 1</li>
     *      <li>w = 2: 不能選擇物品，dp[4][2] = dp[3][2] = 1</li>
     *      <li>w = 3: 不能選擇物品，dp[4][3] = dp[3][3] = 4</li>
     *      <li>w = 4: 不能選擇物品，dp[4][4] = dp[3][4] = 5</li>
     *      <li>w = 5: 可以選擇物品，dp[4][5] = max(dp[3][5], dp[3][0] + 7) = max(6, 0 + 7) = 7</li>
     *      <li>w = 6: 可以選擇物品，dp[4][6] = max(dp[3][6], dp[3][1] + 7) = max(6, 1 + 7) = 8</li>
     *      <li>w = 7: 可以選擇物品，dp[4][7] = max(dp[3][7], dp[3][2] + 7) = max(9, 1 + 7) = 9</li>
     *      <p>這邊比較有趣的是最後一個，dp[4][7]，可以看到他挑選了上一個 dp[3][7]，那是因為，這邊就算把前面的東西加起來，價值也沒有到上一次這麼多，所以就挑選上一次的解</p>
     * </ul>
     */
    class Solution {
        public int knapsack(int[] weights, int[] values, int W) {
            int n = weights.length;
            int[][] dp = new int[weights.length + 1][W + 1];

            // for 迴圈的解釋
            // 依據每個物品，重量限制從 0 ~ W 中，把每個東西放進去背包去計算價值
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= W; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
            return dp[n][W];
        }
    }


}
