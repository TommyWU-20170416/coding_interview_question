package array.easy;

public class Find_The_Index_Of_The_First_Occurrence_In_A_String_Best {

    public static void main(String[] args) {

//        // Input: haystack = "sadbutsad", needle = "sad"
//        // Output: 0
//        String haystack1 = "sadbutsad", needle1 = "sad";
//        int result1 = strStr(haystack1, needle1);
//        System.out.println(result1);
//
//        // Input: haystack = "leetcode", needle = "leeto"
//        // Output: 5
//        String haystack2 = "leetcleeto", needle2 = "leeto";
//        int result2 = strStr(haystack2, needle2);
//        System.out.println(result2);
//
//        // Input: haystack3 = "aaa" , needle3 = "aaaa"
//        // Output: -1
//        String haystack3 = "aaa", needle3 = "aaaa";
//        int result3 = strStr(haystack3, needle3);
//        System.out.println(result3);
//
        // Input: haystack3 = "aabaaabaaac", needle4 = "aabaaac"
        // Output: 4
        String haystack4 = "aabaaabaaac", needle4 = "aabaaac";
        int result4 = strStr(haystack4, needle4);
        System.out.println(result4);
    }

    // Diff: Use LPS to figure out
    //
    // time complexity:
    // space complexity: :
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return -1;
        }

        int[] lps = buildLPS(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    public static int[] buildLPS(String needle) {
        int[] lps = new int[needle.length()];
        lps[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            int j = lps[i - 1];

            // 回溯找到正確的匹配位置
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = lps[j - 1];
            }

            // 根據 j 的最終值判斷
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[i] = j + 1;
            } else {
                lps[i] = 0;
            }
        }

        return lps;
    }
}
