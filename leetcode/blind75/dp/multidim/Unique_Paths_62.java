package dp.multidim;

/**
 * 62.https://leetcode.com/problems/unique-paths/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/29 15:12:05
 * @since JDK8.0
 */
public class Unique_Paths_62 {
    public static void main(String[] args) {
        Unique_Paths_62 s = new Unique_Paths_62();
        Unique_Paths_62.Solution solution = s.new Solution();
//        int m = 3, n = 7;
        int m = 3, n = 2;
        int result = solution.uniquePaths(m, n);

        System.out.println("result: " + result);
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
