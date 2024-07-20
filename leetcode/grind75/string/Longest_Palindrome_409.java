package string;

/**
 * 409.https://leetcode.com/problems/longest-palindrome/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/17 17:18:54
 * @since JDK8.0
 */
public class Longest_Palindrome_409 {
    public static void main(String[] args) {
        Longest_Palindrome_409 ss = new Longest_Palindrome_409();
        Longest_Palindrome_409.Solution solution = ss.new Solution();
        String s = "abccccdd";
        int result = solution.longestPalindrome(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 100.00%
         * 因為題目說可以重新拼湊，如果今天的字是這樣 aabbbccccddddd = a2b3c4d5
         * 也就是可以這樣看 2, (2 + 1), 4, (4 + 1) 可以直接把 2 的倍數加起來，就是長度
         * 最後再判斷 b d，但其實不管選誰，都只能選一種
         * 所以最後會判斷是否 有 %2 == 1 的情況，a c 各為 2 跟 4 直接加起來
         */
        public int longestPalindrome(String s) {
            int[] letterS = new int['z' + 1];
            for (char c : s.toCharArray()) {
                letterS[c]++;
            }
            int isThereOne = 0, sum = 0;
            for (int i : letterS) {
                if (i % 2 == 1) isThereOne = 1;
                sum += i / 2;
            }

            return sum * 2 + isThereOne;
        }
    }
}
