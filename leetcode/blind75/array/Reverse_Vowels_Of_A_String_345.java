package array;

/**
 * 345.https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/23 09:38:28
 * @since JDK8.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * Input: s = "aA"
 * Output: "Aa"
 * <p>
 * Input: s = "aA"
 * Output: "Aa"
 * <p>
 * 題目意思是 reverse 沒錯，可是要怎麼 reverse
 * 就已 leetcode 來看你會得到母音有 eeoe
 * reverse 後會得到 eoee => 1,4交換, 2,3 交換
 * <p>
 * 如果是 race car 會得到 aea
 * revese 後會得到 aea
 */
public class Reverse_Vowels_Of_A_String_345 {

    public static void main(String[] args) {
        Reverse_Vowels_Of_A_String_345 r = new Reverse_Vowels_Of_A_String_345();
        Solution s = r.new Solution();
        String str = "leetcode"; // 重複
//        String str = "aA"; // 重複且大小寫
        String result = s.reverseVowels(str);
        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 100.00% O(n)
         * test2
         * 使用方法:
         * 由於 indexOf 找字母是 O(n) 所以改用 boolean[] 去尋找達到 O(1)
         */
        public String reverseVowels(String s) {
            boolean[] isVowels = new boolean['z' + 1];
            isVowels['a'] = true;
            isVowels['e'] = true;
            isVowels['i'] = true;
            isVowels['o'] = true;
            isVowels['u'] = true;
            isVowels['A'] = true;
            isVowels['E'] = true;
            isVowels['I'] = true;
            isVowels['O'] = true;
            isVowels['U'] = true;
            char[] word = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                while (left < right && !isVowels[word[left]]) {
                    left++;
                }
                while (left < right && !isVowels[word[right]]) {
                    right--;
                }
                if(left == right) break; // 可以少做一次，但就要多判斷
                char tmp = word[left];
                word[left] = word[right];
                word[right] = tmp;
                left++;
                right--;
            }
            return new String(word);
        }
    }
}
