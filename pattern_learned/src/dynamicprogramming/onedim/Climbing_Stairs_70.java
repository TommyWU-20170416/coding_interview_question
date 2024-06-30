package dynamicprogramming.onedim;

import java.util.List;

/**
 * 70.https://leetcode.com/problems/climbing-stairs/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/26 16:46:07
 * @since JDK8.0
 */
public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        Climbing_Stairs_70 s = new Climbing_Stairs_70();
        Climbing_Stairs_70.Solution solution = s.new Solution();
        int n = 4;

        int result = solution.climbStairs(n);
        System.out.print(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 bottom up 去紀錄之前走過的
         *
         * 這題跟 fib 很相似，但差異在 dp[0] = 1
         * F(0) = 1, 要走到第0個階梯就是站在原地不同，只有這一種方法
         * F(1) = 1
         * F(2) = (1, 1) + (2), 1步1步走 + 2步一次走 = 2
         * F(3) = F(2) + F(1) = 3
         * F(4) = F(3)        + F(2) = 5
         * ____ = F(2) + F(1) + F(2)
         */
        public int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
