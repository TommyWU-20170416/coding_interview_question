package hashmapandset;

import java.util.Arrays;
import java.util.List;

public class Determine_if_Two_Strings_Are_Close_1657 {
    public static void main(String[] args) {
        Determine_if_Two_Strings_Are_Close_1657 s = new Determine_if_Two_Strings_Are_Close_1657();
        Determine_if_Two_Strings_Are_Close_1657.Solution solution = s.new Solution();

//        String word1 = "abc", word2 = "bca";
        String word1 = "cabbba", word2 = "abbccc";
        boolean result = solution.closeStrings(word1, word2);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1:
         *
         * operation1: 就是排順序
         * operation2: 各個出現過的頻率
         */
//        public boolean closeStrings(String word1, String word2) {
//            if (word1.length() != word2.length()) return false;
//
//            int[] count1 = new int[26];
//            int[] count2 = new int[26];
//            boolean[] chars1 = new boolean[26];
//            boolean[] chars2 = new boolean[26];
//
//            for (char c : word1.toCharArray()) {
//                count1[c - 'a']++; // 這邊計算字母出現過的次數
//                chars1[c - 'a'] = true; // 紀錄出現過哪些字，有出現就標記 true
//            }
//
//            for (char c : word2.toCharArray()) {
//                count2[c - 'a']++;
//                chars2[c - 'a'] = true;
//            }
//
//            // 把已經都用 0-25 index 排序好的 chars1 chars2 兩者做比對，有不一樣就 return false
//            for (int i = 0; i < 26; i++) {
//                if (chars1[i] != chars2[i]) {
//                    return false;
//                }
//            }
//
//            // 假設 word1 = "cabbba", word2 = "abbccc"
//            // a:2, b:3, c:1         a:1, b:2, c:3
//            // 依照次數做排序
//            // c:1, a:2, b:3         c:1, a:2, b:3
//            // 就可以知道是否滿足 operation2
//            Arrays.sort(count1);
//            Arrays.sort(count2);
//
//            return Arrays.equals(count1, count2);
//        }

        /**
         * test2
         * 簡化寫法
         */
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            if (word1.equals(word2)) return true;

            int[] count1 = new int[26];
            int[] count2 = new int[26];

            for (char ch : word1.toCharArray()) {
                count1[ch - 97]++;
            }
            for (char ch : word2.toCharArray()) {
                count2[ch - 97]++;
            }

            for (int i = 0; i < 26; i++) {
                if ((count1[i] > 0 && count2[i] == 0) || (count2[i] > 0 && count1[i] == 0))
                    return false;
            }

            Arrays.sort(count1);
            Arrays.sort(count2);
            for (int i = 0; i < 26; i++)
                if (count1[i] != count2[i]) return false;

            return true;
        }
    }
}
