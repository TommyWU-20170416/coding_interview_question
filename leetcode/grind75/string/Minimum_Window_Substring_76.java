package string;

import java.util.List;

/**
 * 76.https://leetcode.com/problems/minimum-window-substring/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 16:30:32
 * @since JDK8.0
 */
public class Minimum_Window_Substring_76 {
    public static void main(String[] args) {
        Minimum_Window_Substring_76 ss = new Minimum_Window_Substring_76();
        Minimum_Window_Substring_76.Solution solution = ss.new Solution();
        String s = "AOBECOEBANC", t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 2 ms, Beats 99.88%
         */
        public String minWindow(String s, String t) {
            int[] freq = new int[128];
            for (char c : t.toCharArray()) {
                freq[c]++;
            }

            char[] source = s.toCharArray();
            int requiredChars = t.length();
            int left = 0, start = -1;
            int len = source.length;
            int end = len;

            for (int right = 0; right < len; right++) {
                if (--freq[source[right]] >= 0) { // 在 s 中找跟 t 有關的
                    requiredChars--;
                }

                while (requiredChars == 0) {
                    if (++freq[source[left]] > 0) {
                        if (right - left < end - start) {
                            start = left;
                            end = right;
                        }
                        requiredChars++;
                    }
                    left++;
                }
            }
            return start == -1 ? "" : s.substring(start, end + 1);
        }
    }
}
