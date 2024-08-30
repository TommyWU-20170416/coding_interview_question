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
         * Runtime: 8 ms, Beats 98.31%
         * operation1: 就是排順序
         * operation2: 各個出現過的頻率
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
            // 如果自己有，對方沒有，或是對方有，自己沒有，就 return false 因為不存在的字無法透過交換得到
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
