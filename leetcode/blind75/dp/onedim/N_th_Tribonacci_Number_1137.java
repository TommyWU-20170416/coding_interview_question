package dp.onedim;

/**
 * 1137.https://leetcode.com/problems/n-th-tribonacci-number/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/27 16:26:47
 * @since JDK8.0
 */
public class N_th_Tribonacci_Number_1137 {
    public static void main(String[] args) {
        N_th_Tribonacci_Number_1137 s = new N_th_Tribonacci_Number_1137();
        N_th_Tribonacci_Number_1137.Solution solution = s.new Solution();
        int n = 0;
        int result = solution.tribonacci(n);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用跟 fib 一樣的方式並且每一個解都用 memo 紀錄
         */
        public int tribonacci(int n) {
            if (n <= 1)
                return n;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            return dp[n];
        }
    }
}
