package array.easy;

/**
 * 125. https://leetcode.com/problems/valid-palindrome/description/
 */
public class Valid_Palindrome {

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
    // time complexity: O(3n) = O(n)(removeNonAlphanumeric) + O(n)(toLowerCase) + O(n)(check palindrome) => O(n)
    //      because we need to iterate through the string to remove non-alphanumeric characters and then check if it's a palindrome
    // space complexity: O(n)
    //      because of the new string created after removing non-alphanumeric characters
    public static boolean isPalindrome(String s) {
        s = removeNonAlphanumeric(s);
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String removeNonAlphanumeric(String s) {
        // alpha: a-z, A-Z,
        // numeric: 0-9
        // use ASCII to check if a character is alphanumeric or use char to find
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
