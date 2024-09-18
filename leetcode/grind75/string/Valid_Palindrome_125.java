package string;

/**
 * 125.https://leetcode.com/problems/valid-palindrome/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/17 15:12:39
 * @since JDK8.0
 */
public class Valid_Palindrome_125 {
    public static void main(String[] args) {
        Valid_Palindrome_125 ss = new Valid_Palindrome_125();
        Valid_Palindrome_125.Solution solution = ss.new Solution();
        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = " ";
//        String s = "0P";
        boolean result = solution.isPalindrome(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 3 ms, Beats 72.20% O(2n) 因為整理一次 + 檢查一次
         * 先把 字母以及數字以外的 剔除，整理成 newLetters[]
         * 然後再比對頭尾
         */
//        public boolean isPalindrome(String s) {
//            //remove non-alpha
//            int r = 0;
//            char[] newLetters = new char[s.length()];
//            char[] letters = s.toCharArray();
//            for (int i = 0; i < letters.length; i++) {
//                if (Character.isAlphabetic(letters[i]) || Character.isDigit(letters[i])) {
//                    newLetters[r++] = Character.toLowerCase(letters[i]);
//                }
//            }
//            if (r == 0) return true; // 整理完沒有任何字母，代表是空的
//            r--; // 會多一個
//            for (int l = 0; l < r; ) {
//                if (newLetters[l] != newLetters[r]) {
//                    return false;
//                } else {
//                    l++;
//                    r--;
//                }
//            }
//            return true;
//        }

        /**
         * Runtime: 1 ms, Beats 100.00%
         * 這段實測，把 if 改成 while 想說讓他第二層 while 可以做快點，但效果一樣
         * 比較明顯的差異是使用 Character.isDigit 跟 Character.isAlphabetic 還是比手刻還慢
         */
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                while (left < right && !isValid(s.charAt(left))) {
                    left++;
                }
                while (left < right && !isValid(s.charAt(right))) {
                    right--;
                }
                char leftChar = toLowerCase(s.charAt(left)), rightChar = toLowerCase(s.charAt(right));
                if (leftChar != rightChar) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        private boolean isValid(char c) {
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
                return true;
            }
            return false;
        }

        private char toLowerCase(char c) {
            if ('A' <= c && c <= 'Z') {
                return (char) ('a' + (c - 'A'));
            }
            return c;
        }
    }
}
