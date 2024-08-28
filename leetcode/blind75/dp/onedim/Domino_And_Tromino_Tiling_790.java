package dp.onedim;

/**
 * 790.https://leetcode.com/problems/domino-and-tromino-tiling/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/28 14:47:13
 * @since JDK8.0
 */
public class Domino_And_Tromino_Tiling_790 {
    public static void main(String[] args) {
        Domino_And_Tromino_Tiling_790 s = new Domino_And_Tromino_Tiling_790();
        Domino_And_Tromino_Tiling_790.Solution solution = s.new Solution();
        int n = 3;
//        int n = 4;
        int result = solution.numTilings(n);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 41.82%
         * 解法:
         * dp[i]  = dp[i-2] + dp[i-1] + 2*dp2[i-1];
         * dp2[i] = dp[i-2] + dp2[i-1]
         * dp[i]：表示填滿一個 2xi 棋盤的方式數。
         * dp2[i]：表示填滿 2xi 棋盤時，最右側多出一格或兩格（形成缺口）的方式數。
         */
//        public int numTilings(int n) {
//            if (n <= 1) return 1;
//            int MOD = 1000000007;
//            int[] dp = new int[n + 1];
//            int[] dp2 = new int[n + 1];
//            dp[0] = 1; // 填滿一個長度為 0 的棋盤，有 1 種方式（什麼都不放）。
//            dp[1] = 1; // 填滿一個 2x1 的棋盤，有 1 種方式（放一個垂直的 2x1 骨牌）。
//            dp2[0] = 0; // 沒有棋盤時，無法形成缺口。
//            dp2[1] = 0; // 填滿一個 2x1 的棋盤後無法形成缺口
//
//            for (int i = 2; i <= n; i++) {
//                dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + 2 * dp2[i - 1] % MOD) % MOD;
//                dp2[i] = (dp[i - 2] + dp2[i - 1]) % MOD;
//            }
//            return dp[n];
//        }

        /**
         * Runtime: 0 ms, Beats 100.00%
         * 要看這推導
         * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620809/python-java-c-c-dp-image-visualized-explanation-100-faster-o-n/?envType=study-plan-v2&envId=leetcode-75
         * 作者以 0-index 所以 dp[0] 就是有一欄的意思，也因此最後 return 也要減一
         * 公式推導出來會有 i - 3 所以初始 dp 也要到 2
         */
        public int numTilings(int n) {
            if (n <= 1)
                return 1;
            int[] dp = new int[n + 1];
            int MOD = 1000000007;
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((2 * dp[i - 1]) % MOD + (dp[i - 3]) % MOD) % MOD;
            }
            return dp[n];
        }
    }
}
