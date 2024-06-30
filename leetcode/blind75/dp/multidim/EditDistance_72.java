package dp.multidim;
/**
 * 72.https://leetcode.com/problems/edit-distance/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/29 15:11:50
 * @since JDK8.0
 */
public class EditDistance_72 {
    public static void main(String[] args) {
        EditDistance_72 test = new EditDistance_72();
        test.testMinDistance();
    }

    public void testMinDistance() {
        String word1 = "horse";
        String word2 = "ros";
        int expectedOutput = 3;  // Expected output for "horse" -> "ros" is 3
        int result = minDistance(word1, word2);
        System.out.println("Test Case 1: " + (result == expectedOutput ? "Passed" : "Failed"));

        word1 = "";
        word2 = "a";
        expectedOutput = 5;  // Expected output for "intention" -> "execution" is 5
        result = minDistance(word1, word2);
        System.out.println("Test Case 2: " + (result == expectedOutput ? "Passed" : "Failed"));

        // Add more test cases as needed
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填表
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;      // 插入操作
                    int delete = dp[i - 1][j] + 1;      // 删除操作
                    int replace = dp[i - 1][j - 1] + 1; // 替换操作
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * test2:
     * 優化:
     * 把 charAt 改用 toCharArray
     */
//    public int minDistance(String word1, String word2) {
//        char[] chars1 = word1.toCharArray();
//        char[] chars2 = word2.toCharArray();
//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//
//        for (int i = 0; i <= word1.length(); i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 0; j <= word2.length(); j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i <= word1.length(); i++) {
//            for (int j = 1; j <= word2.length(); j++) {
//                if (chars1[i - 1] == chars2[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
//                }
//            }
//        }
//        return dp[word1.length()][word2.length()];
//    }
}
