package weeklycontest406;

import java.util.Arrays;

/**
 * 100352.https://leetcode.com/contest/weekly-contest-406/problems/lexicographically-smallest-string-after-a-swap/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/14 10:31:11
 * @since JDK8.0
 */
public class Lexicographically_Smallest_String_After_A_Swap_100352 {
    public static void main(String[] args) {
        Lexicographically_Smallest_String_After_A_Swap_100352 ss = new Lexicographically_Smallest_String_After_A_Swap_100352();
        Lexicographically_Smallest_String_After_A_Swap_100352.Solution solution = ss.new Solution();
//        String s = "45320";
//        String s = "13";
//        String s = "131";
        String s = "000004322677566";
        String result = solution.getSmallestString(s);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * 類似 two pointer，從 1 開始，跟前一個做比對
         * 如果當下 < 前一個 && 是連續整數或奇數，就可以交換
         * 交換後break，返回 result
         */
        public String getSmallestString(String s) {
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                int a = chars[i - 1] - '0';
                int b = chars[i] - '0';
                if (a > b && isContinueOddOrEven(a, b)) {
                    swap(chars, i - 1, i);
                    break;
                }
            }
            return new String(chars);
        }

        private boolean isContinueOddOrEven(int num1, int num2) {
            return (num1 % 2 + num2 % 2) % 2 == 0;
        }

        private void swap(char[] chars, int a, int b) {
            char c = chars[a];
            chars[a] = chars[b];
            chars[b] = c;
        }
    }
}
