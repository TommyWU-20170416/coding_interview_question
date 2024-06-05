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
     * Runtime: 6 ms, Memory Usage: 39 MB
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        /**
         * https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/4043492/best-and-understandable-code-in-java/
         */
//        HashMap<Character, Integer> map = new HashMap<>();
//        int max = 0;
//        int low = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char curr = s.charAt(i);
//            if (map.containsKey(curr)) {
//                // 當有重複，跳到重覆後面的位置當作不重複的起始點
//                low = Math.max(low, map.get(curr) + 1);
//            }
//            map.put(curr, i);
//            max = Math.max(max, i - low + 1);
//        }
//        return max;

        //        Set set = new HashSet();
//        int windowStart = 0, windowEnd = 0, maxLength = 0;
//        while (windowEnd < s.length()) {
//            if (set.contains(s.charAt(windowEnd))) {
//                set.remove(s.charAt(windowStart));
//                windowStart++;
//            } else {
//                set.add(s.charAt(windowEnd));
//                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
//                windowEnd++;
//            }
//        }
//        return maxLength;
//		Set<Character> set = new HashSet<Character>();
//		int maxLength = 0, window_start = 0, window_end = 0;
//		int count = 0;
//		/* abcabcbb */
//		while (window_end < s.length()) {
//			System.out.println("count:" + count);
//			count++;
//			if (set.contains(s.charAt(window_end))) {
//				set.remove(s.charAt(window_start));
//				window_start++;
//			} else {
//				set.add(s.charAt(window_end));
//				maxLength = Math.max(maxLength, window_end - window_start + 1);
//				window_end++;
//			}
//
//		}
//
//		return maxLength;
        if (s.isEmpty())
            return 0;

        int[] charIndex = new int[128]; // 僅限定

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (charIndex[c] > start) {
                start = charIndex[c];
            }
            charIndex[c] = end + 1;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
