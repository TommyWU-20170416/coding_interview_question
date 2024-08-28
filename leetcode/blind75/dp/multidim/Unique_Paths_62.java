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

    /**
     * -   0   1   2   3
     * 0   1   1   1   1
     * 1   1   2   3   4
     * 2   1   3   6   10
     * 除了邊界以外，每一點都是上面 + 左邊來的路徑
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            // initial edge
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            // add top and left to get each node
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
