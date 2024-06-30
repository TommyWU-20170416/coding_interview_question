package dp.multidim;

/**
 * 63.https://leetcode.com/problems/unique-paths-ii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/29 15:38:37
 * @since JDK8.0
 */
public class Unique_Paths_II_63 {
    public static void main(String[] args) {
        Unique_Paths_II_63 s = new Unique_Paths_II_63();
        Unique_Paths_II_63.Solution solution = s.new Solution();
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{1, 1}, {0, 0}};
//        int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
        int result = solution.uniquePathsWithObstacles(obstacleGrid);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 dp table 去記錄每一步要走的
         * 但要注意的是，啟動若有障礙物或是終點有障礙物，其實都可以直接 return 0
         * 另外是邊界如果有障礙物，其實邊界後面的也到不了，所以要 break 而不是 continue
         */
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//            if (obstacleGrid[0][0] == 1) return 0;
//            int m = obstacleGrid.length;
//            int n = obstacleGrid[0].length;
//            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                if (obstacleGrid[i][0] == 1) break;
//                dp[i][0] = 1;
//            }
//            for (int j = 0; j < n; j++) {
//                if (obstacleGrid[0][j] == 1) break;
//                dp[0][j] = 1;
//            }
//
//            for (int i = 1; i < m; i++) {
//                for (int j = 1; j < n; j++) {
//                    if (obstacleGrid[i][j] == 1) continue;
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//            return dp[m - 1][n - 1];
//        }

        /**
         * 簡短寫法
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
                dp[i][0] = 1;
            for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++)
                dp[0][j] = 1;


            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = (obstacleGrid[i][j] == 1) ? dp[i - 1][j] + dp[i][j - 1] : 0;
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
