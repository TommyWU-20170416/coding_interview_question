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
         * test1
         * 解法:
         * 比對每個字元，如果有相同就 ++
         * 如果不相同就找 同列或同欄 最大值，紀錄下去
         */
//        public int longestCommonSubsequence(String text1, String text2) {
//            int strLen1 = text1.length();
//            int text2.length = text2.length();
//            int[][] dp = new int[strLen1 + 1][text2.length + 1];
//
//            for (int i = 1; i <= strLen1; i++) {
//                char c1 = text1.charAt(i - 1);
//                for (int j = 1; j <= text2.length; j++) {
//                    char c2 = text2.charAt(j - 1);
//                    if (c1 == c2) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                    } else {
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                    }
//                }
//            }
//            return dp[strLen1][text2.length];
//        }

        /**
         * test2
         * 優化:
         * 因為是 charAt 所以可用 toCharArray() 取代提高效率
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
