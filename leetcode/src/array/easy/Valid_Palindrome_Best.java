package array.easy;

/**
 * 125. https://leetcode.com/problems/valid-palindrome/description/
 */
public class Valid_Palindrome_Best {

    public static void main(String[] args) {

        // Input: s = "A man, a plan, a canal: Panama"
        // Output: true
        String s1 = "A man, a plan, a canal: Panama";
        boolean result1 = isPalindrome(s1);

        System.out.println(result1);

        // Input: s = "race a car"
        // Output: false
        String s2 = "race a car";
        boolean result2 = isPalindrome(s2);
        System.out.println(result2);

        // Input: s = " "
        // Output: true
        String s3 = " ";
        boolean result3 = isPalindrome(s3);
        System.out.println(result3);
    }

    // Diff:
    // time complexity:
    // space complexity:
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // find useful left
            if (!isAlphaNumeric(l)) {
                left++;
                continue;
            }

            // find useful right
            if (!isAlphaNumeric(r)) {
                right--;
                continue;
            }

            // valid left and right
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
