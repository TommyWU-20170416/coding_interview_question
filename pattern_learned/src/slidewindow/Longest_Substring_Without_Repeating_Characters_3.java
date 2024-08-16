package slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3.https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月22日 下午11:41:18
 * @since JDK8.0
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence
 * and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class Longest_Substring_Without_Repeating_Characters_3 {
    private static String s = "abcabcbb";
//	private static String s = "bbbbb";
//    private static String s = "pwwpkea";

    //	private static String s = "";
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 test = new Longest_Substring_Without_Repeating_Characters_3();
        int result = test.lengthOfLongestSubstring(s);
        System.out.println("result:" + result);
    }

    /**
     * Runtime: 1 ms, Beats 100.00%
     * 很酷的解法
     * 他使用 charIndex[s.charAt(right)] 紀錄這個字是在陣列中的哪個位置
     * 如果今天不重複 left 都是 0，如果遇到重複，l 就會是上一次出現的那個位置
     * 重要!!
     * 每一次他都會去計算 max，所以不用像上面那樣，還要判斷當有重複才算 max
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int[] records = new int[128]; // 儲存的位置是從 1 開始算
        int maxLen = 0;
        // 假設 abcc，left 可以快速指定到 3 而不是 2
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (records[s.charAt(right)] > left) {
                left = records[s.charAt(right)];
            }
            maxLen = Math.max(maxLen, right - left + 1);
            records[s.charAt(right)] = right + 1;
        }
        return maxLen;
    }
}
