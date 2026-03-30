package array.easy;

/**
 * 14. https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Longest_Common_Prefix_Best {

    public static void main(String[] args) {

        String[] strs1 = {"flower", "flow", "flight"};

        String result1 = longestCommonPrefix(strs1);
        System.out.println("result1: " + result1); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = longestCommonPrefix(strs2);
        System.out.println("result2: " + result2); // Output: ""

        String[] strs3 = {""};
        String result3 = longestCommonPrefix(strs3);
        System.out.println("result3: " + result3); // Output: ""

    }

    /**
     * Diff: use indexOf java language
     * <p>
     * time complexity: O(N * M^2 * L)
     * <ol>
     *      <li>O(N)：for for loop</li>
     *      <li>O(M * L)：indexOf 搜尋</li>
     *          <ul>
     *              <li>`indexOf` will brute force to find substring, if not find, shift right</li>
     *              <li>the worst situation: O(M * L); M = prefix, L = str[i]</li>
 *              </ul>
     *      <li>O(M)：while loop base on M(prefix) length</li>
     * </ol>
     * <p>
     * space complexity: O(M) substring will create new String
     */
    public static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        // "ABC".indexOf("") will get 0
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // only accept match from begin
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}