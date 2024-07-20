package hashtable;

/**
 * 383.https://leetcode.com/problems/ransom-note/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/20 12:18:05
 * @since JDK8.0
 */
public class Ransom_Note_383 {
    public static void main(String[] args) {
        Ransom_Note_383 s = new Ransom_Note_383();
        Ransom_Note_383.Solution solution = s.new Solution();
        String ransomNote = "aa", magazine = "abba";
        boolean result = solution.canConstruct(ransomNote, magazine);
        System.out.print(result);
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 98.76% O(N + M)
         */
//        public boolean canConstruct(String ransomNote, String magazine) {
//            int[] magazineLetters = new int[26];
//            for (char c : magazine.toCharArray()) {
//                magazineLetters[c - 'a']++;
//            }
//            for (char c : ransomNote.toCharArray()) {
//                if (magazineLetters[c - 'a']-- == 0) {
//                    return false;
//                }
//            }
//            return true;
//        }

        /**
         * Runtime: 0 ms, Beats 100.00%
         * 使用 indexOf 去找說 ch 從哪個起點 會傳位置並更新
         * 如果這個字在 mahazine 找不到，index 就會是 - 1
         * magazineLetters[ch % 26] 是利用 a-z 的特性去存放 位置
         * <p>
         * ransomNote = "aa", magazine = "abba"
         * ransomNote第一個 a 位於 magazine 第 0 位
         * ransomNote第二個 a 位於 magazine 第 0 位以後的 第三位
         * 要這樣更新位置是因為每個單字只能被用掉一次，而下一次尋找都會是上一次的位置往後開始找(不包含原本的位置)
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] magazineLetters = new int[26];
            for (char ch : ransomNote.toCharArray()) {
                int index = magazine.indexOf(ch, magazineLetters[ch % 26]);
                if (index == -1) {
                    return false;
                }
                magazineLetters[ch % 26] = index + 1;
            }
            return true;
        }

    }
}
