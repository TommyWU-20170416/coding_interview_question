package slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 159.https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月22日 下午6:59:22
 * @since JDK8.0
 * <p>
 * Given a string s , find the length of the longest substring t that
 * contains at most 2 distinct characters.
 * 尋找子字串中兩個不同字元，可組成最長的連續字串
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: this "ece" which its length is 3.
 * content:
 * ec
 * ece
 * eceb > ceb > eb
 * eba > ba
 * <p>
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: this "aabbb" which its length is 5.
 * content:
 * <p>
 * cc
 * cca
 * ccaa
 * ccaab > caab > aab
 * aabb
 * aabbb
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters_159 {

    //    private static String s1 = "eceba";
//    private static String s1 = "ccaabbb";
    private static String s1 = "ecebeeeeeeeea";

    public static void main(String[] args) {
        Longest_Substring_with_At_Most_Two_Distinct_Characters_159 test = new Longest_Substring_with_At_Most_Two_Distinct_Characters_159();
        int result = test.lengthOfLongestSubstringTwoDistinct(s1);
        System.out.println("result:" + result);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int windowStart = 0, windowCount = 0, maxRange = 0;
        /** 字串，出現次數 */
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);

            while (map.size() > 2) {
                int value = map.get(s.charAt(windowStart));
                map.put(s.charAt(windowStart), value - 1);
                map.values().remove(0);
                windowStart++;
            }
            maxRange = Math.max(maxRange, i - windowStart + 1);
        }
        return maxRange;
//		int window_start = 0, maxLength = 0;
//		HashMap<Character, Integer> map = new HashMap();
//		for (int window_end = 0; window_end < s.length(); window_end++) {
//			if(map.containsKey(s.charAt(window_end))) {
//				int value = map.get(s.charAt(window_end));
//				map.put(s.charAt(window_end), ++value);
//			}else {
//				map.put(s.charAt(window_end), 1);
//			}
//			while (map.size() > 2) {
//				int value = map.get(s.charAt(window_start));
//				map.put(s.charAt(window_start), --value);
//				if(map.get(s.charAt(window_start)) == 0) {
//					map.remove(s.charAt(window_start));
//				}
//				window_start++;
//			}
//			maxLength = Math.max(maxLength, window_end - window_start + 1);
//		}
//
//		return maxLength;
    }
}
