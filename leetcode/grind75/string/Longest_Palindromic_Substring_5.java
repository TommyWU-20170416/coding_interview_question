package string;

/**
 * 5.https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 14:30:13
 * @since JDK8.0
 */
public class Longest_Palindromic_Substring_5 {
    public static void main(String[] args) {
        Longest_Palindromic_Substring_5 ss = new Longest_Palindromic_Substring_5();
        Longest_Palindromic_Substring_5.Solution solution = ss.new Solution();
        String s = "babad";
//        String s = "cbbd";
        String result = solution.longestPalindrome(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 15 ms, Beats 88.12% O(n^2)
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R <= s.length() - 1 && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
//        public String longestPalindrome(String s) {
//            if (s == null || s.length() < 1) return "";
//            int start = 0, end = 0;
//            for (int i = 0; i < s.length(); i++) {
//                int len1 = expandAroundCenter(s, i, i); // 奇數長度的回文
//                int len2 = expandAroundCenter(s, i, i + 1); // 偶數長度的回文
//                int len = Math.max(len1, len2);
//                if (len > end - start) {
//                    start = i - (len - 1) / 2;
//                    end = i + len / 2;
//                }
//            }
//            return s.substring(start, end + 1);
//        }
//
//        private int expandAroundCenter(String s, int left, int right) {
//            int L = left, R = right;
//            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//                L--;
//                R++;
//            }
//            return R - L - 1;
//        }
    }
}
