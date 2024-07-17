package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3.https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/17 16:17:41
 * @since JDK8.0
 */
public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 ss = new Longest_Substring_Without_Repeating_Characters_3();
        Longest_Substring_Without_Repeating_Characters_3.Solution solution = ss.new Solution();
//        String s = "abcabcbb"; // 3
        String s = "abcbdef";
//        String s = "au";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 6 ms, Beats 68.20%
         * 使用 two pointer 以及 map 紀錄每一次字母第一次新增的位置
         * 如果有重複，就要從左邊一路清到右邊，直到該直沒有
         * a b c b d e
         * 遇到 b 重複的時候，l要走到 c 的位置，並且把 map 內的 a 砍掉
         * 最後的 return 是因為考量到若走到底發現都沒有重複的情境，因此要跟 count 比大小
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) return s.length();
            int l = 0, maxLen = 0;
            Map<Character, Integer> map = new HashMap<>();
            char[] letters = s.toCharArray();
//            for (int r = 0; r < letters.length; r++) {
//                if (map.containsKey(letters[r])) {
//                    count = Math.max(count, r - l);
//                    int duplicateIndex = map.get(letters[r]);
//                    while (l <= duplicateIndex) {
//                        map.remove(letters[l++]);
//                    }
//                }
//                map.put(letters[r], r);
//            }
//            return Math.max(count, map.size());
            // 這邊改變一下寫法，這樣寫比較好懂，就是當重複的時候才更新 left 到重覆的下一個
            // 沒有重複就繼續計算 maxLen 跟 放直到 map 內
            for (int r = 0; r < s.length(); r++) {
                char cur = letters[r];
                if (map.containsKey(cur)) {
                    l = Math.max(l, map.get(cur) + 1);
                }
                map.put(cur, r);
                maxLen = Math.max(maxLen, r - l + 1);
            }
            return maxLen;
        }

        /**
         * Runtime: 1 ms, Beats 100.00%
         * 很酷的解法
         * 他使用 charIndex[s.charAt(right)] 紀錄這個字是在陣列中的哪個位置
         * 如果今天不重複 left 都是 0，如果遇到重複，l 就會是上一次出現的那個位置
         * 重要!!
         * 每一次他都會去計算 max，所以不用像上面那樣，還要判斷當有重複才算 max
         */
//        public int lengthOfLongestSubstring(String s) {
//            int maxLen = 0;
//            int[] charIndex = new int[128];
//            char[] letterS = s.toCharArray();
//            for (int r = 0, l = 0; r < letterS.length; r++) {
//                l = Math.max(l, charIndex[letterS[r]]);
//                maxLen = Math.max(maxLen, r - l + 1);
//                charIndex[letterS[r]] = r + 1;
//            }
//            return maxLen;
//        }
    }
}
