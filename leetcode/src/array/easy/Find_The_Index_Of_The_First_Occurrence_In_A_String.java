package array.easy;

public class Find_The_Index_Of_The_First_Occurrence_In_A_String {

    public static void main(String[] args) {

        // Input: haystack = "sadbutsad", needle = "sad"
        // Output: 0
        String haystack1 = "sadbutsad", needle1 = "sad";
        int result1 = strStr(haystack1, needle1);
        System.out.println(result1);

        // Input: haystack = "leetcode", needle = "leeto"
        // Output: 5
        String haystack2 = "leetcleeto", needle2 = "leeto";
        int result2 = strStr(haystack2, needle2);
        System.out.println(result2);

        // Input: haystack3 = "aaa" , needle3 = "aaaa"
        // Output: -1
        String haystack3 = "aaa", needle3 = "aaaa";
        int result3 = strStr(haystack3, needle3);
        System.out.println(result3);

        // Input: haystack3 = "aabaaabaaac", needle4 = "aabaaac"
        // Output: 4
        String haystack4 = "aabaaabaaac", needle4 = "aabaaac";
        int result4 = strStr(haystack4, needle4);
        System.out.println(result4);
    }

    // Diff:
    // time complexity:
    // space complexity:
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return -1;
        }

        // n - m 是因為不需要全部檢查完
        for (int i = 0; i <= n - m; i++) {
            // j 每一次都去檢查 needle 的內容
            // i + j 表示從哪裡開始
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
