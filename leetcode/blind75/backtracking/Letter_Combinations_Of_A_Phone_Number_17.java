package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/24 14:26:16
 * @since JDK8.0
 */
public class Letter_Combinations_Of_A_Phone_Number_17 {
    public static void main(String[] args) {
        Letter_Combinations_Of_A_Phone_Number_17 s = new Letter_Combinations_Of_A_Phone_Number_17();
        Letter_Combinations_Of_A_Phone_Number_17.Solution solution = s.new Solution();
        String digits = "23";

        List<String> result = solution.letterCombinations(digits);
        System.out.print(result);
    }

    /**
     *
     * 解法:
     * 優化 map 裡面儲存的內容，提高效率
     */
    class Solution {
        private Map<Character, char[]> phoneMap = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            phoneMap.put('2', new char[]{'a', 'b', 'c'});
            phoneMap.put('3', new char[]{'d', 'e', 'f'});
            phoneMap.put('4', new char[]{'g', 'h', 'i'});
            phoneMap.put('5', new char[]{'j', 'k', 'l'});
            phoneMap.put('6', new char[]{'m', 'n', 'o'});
            phoneMap.put('7', new char[]{'p', 'q', 'r', 's'});
            phoneMap.put('8', new char[]{'t', 'u', 'v'});
            phoneMap.put('9', new char[]{'w', 'x', 'y', 'z'});

            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) return result;

            backtrack(digits, result, 0, new StringBuilder());
            return result;
        }

        private void backtrack(String digits, List<String> result, int index, StringBuilder current) {
            if (index == digits.length()) {
                result.add(current.toString());
                return;
            }
            char digit = digits.charAt(index);
            char[] letters = phoneMap.get(digit);
            for (char letter : letters) {
                current.append(letter);

                // main
                backtrack(digits, result, index + 1, current);

                current.deleteCharAt(current.length() - 1);
            }
        }


    }
}
