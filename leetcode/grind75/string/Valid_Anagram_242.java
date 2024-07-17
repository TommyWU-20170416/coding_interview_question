package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242.https://leetcode.com/problems/valid-anagram/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/17 15:48:33
 * @since JDK8.0
 */
public class Valid_Anagram_242 {
    public static void main(String[] args) {
        Valid_Anagram_242 ss = new Valid_Anagram_242();
        Valid_Anagram_242.Solution solution = ss.new Solution();
//        String s = "anagram", t = "nagaram";
        String s = "ra", t = "car";
        boolean result = solution.isAnagram(s, t);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 4 ms, Beats 70.34% O(2nlogn + n)
         * 先做排序在比較字串
         */
//        public boolean isAnagram(String s, String t) {
//            char[] charS = s.toCharArray(), charT = t.toCharArray();
//            Arrays.sort(charS);
//            Arrays.sort(charT);
//            if (charS.length != charT.length) return false;
//            for (int i = 0; i < charS.length; i++) {
//                if (charS[i] != charT[i]) return false;
//            }
//            return true;
//        }

        /**
         * Runtime: 2 ms, Beats 97.17%
         * 使用 int[26] 去把第一個 s 出現過的字母加總
         * 再去 跑 t 扣掉出現過的字母
         */
        public boolean isAnagram(String s, String t) {
            int totalLetters = s.length();
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                if (charCount[c - 'a'] != 0) {
                    charCount[c - 'a']--;
                    totalLetters--;
                }
            }
            // 第二次的 for 用下面的算會 差 1 ms 但看不出來有什麼厲害的
//            for (char c : t.toCharArray()) {
//                charCount[c - 'a']--;
//            }
//            for (int i : charCount) {
//                if (i != 0) {
//                    return false;
//                }
//            }
            return totalLetters == 0;
        }
    }
}
