package string;

import java.util.*;

/**
 * 438.https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 15:38:40
 * @since JDK8.0
 */
public class Find_All_Anagrams_in_a_String_438 {
    public static void main(String[] args) {
        Find_All_Anagrams_in_a_String_438 ss = new Find_All_Anagrams_in_a_String_438();
        Find_All_Anagrams_in_a_String_438.Solution solution = ss.new Solution();
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "aababcd";
        String p = "abcd";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println("reuslt:" + result);
    }

    /**
     * Runtime: 1579 ms, Beats 5.04%
     * 先把 p 做排序，再用 p 的長度去遍歷 s
     * s 也要先做排序在比對
     * 比對完一樣就 add result
     */
//    class Solution {
//        public List<Integer> findAnagrams(String s, String p) {
//            char[] charp = p.toCharArray();
//            Arrays.sort(charp);
//            List<Integer> result = new ArrayList<>();
//
//            for (int i = 0; i <= s.length() - p.length(); i++) {
//                char[] chars = s.substring(i, i + p.length()).toCharArray();
//                Arrays.sort(chars);
//                if (isSameArray(charp, chars)) result.add(i);
//            }
//            return result;
//        }
//
//        private boolean isSameArray(char[] chars1, char[] chars2) {
//            for (int i = 0; i < chars1.length; i++) {
//                if (chars1[i] != chars2[i]) return false;
//            }
//            return true;
//        }
//    }

    /**
     * Runtime: 8 ms, Beats 92.83% O(N + M)
     * 使用 Array 去計算每個字母出現的次數，並且使用 slideWindow 去新增跟排除字
     * 注意!! pCount[] 只會儲存 p 的總和，sCount[] 則會++--多次
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
                return result;
            }

            int[] pCount = new int[26];
            int[] sCount = new int[26];
            char[] sChars = s.toCharArray();
            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            int left = 0, right = 0, pLength = p.length();
            while (right < s.length()) {
                sCount[sChars[right] - 'a']++;
                if (right - left + 1 == pLength) {
                    if (isSameArray(pCount, sCount)) {
                        result.add(left);
                    }
                    sCount[sChars[left] - 'a']--;
                    left++;
                }
                right++;
            }
            return result;
        }

        private boolean isSameArray(int[] chars1, int[] chars2) {
            for (int i = 0; i < 26; i++) {
                if (chars1[i] != chars2[i]) return false;
            }
            return true;
        }
    }
}
