package array.easy;

/**
 * 14. https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Longest_Common_Prefix {

    public static void main(String[] args) {

        String[] strs1 = {"flower", "flow", "flow"};

        String result1 = longestCommonPrefix(strs1);
        System.out.println("result1: " + result1); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = longestCommonPrefix(strs2);
        System.out.println("result2: " + result2); // Output: ""

        String[] strs3 = {""};
        String result3 = longestCommonPrefix(strs3);
        System.out.println("result3: " + result3); // Output: ""

    }

    // Diff:
    // time complexity: O(S) base on strs.length and strs[0].length, S is the sum of all characters in all strings
    // space complexity: O(1) we only use constant space to store the longest common prefix
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].isEmpty()) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String word = strs[j];

                if (i >= word.length() || c != word.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}