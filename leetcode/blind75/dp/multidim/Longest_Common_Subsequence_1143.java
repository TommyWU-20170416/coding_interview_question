package dp.multidim;


/**
 * 1143.https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/28 16:27:25
 * @since JDK8.0
 */
public class Longest_Common_Subsequence_1143 {
    public static void main(String[] args) {
        Longest_Common_Subsequence_1143 s = new Longest_Common_Subsequence_1143();
        Longest_Common_Subsequence_1143.Solution solution = s.new Solution();
        String text1 = "abcde", text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 8 ms, Beats 99.27%
         * 優化:
         * 因為是 charAt 所以可用 toCharArray() 取代提高效率
         * 主要利用 dp 去跑每一種可能，如果今天值不一樣，就延續上一個最大值 Math.max(dp[i - 1][j], dp[i][j - 1])
         * 如果一樣 chars1[i - 1] == chars2[j - 1]，就要把 dp[i][j] = dp[i - 1][j - 1] + 1 意義是當前的值是由上一個值 + 1
         * 可以想像成 chars1[i - 1] 跟 chars2[j - 1] 做比較，因為字元一樣所以放到 dp[i][j]
         */
        public int longestCommonSubsequence(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];

            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
