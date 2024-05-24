package twopointers;

/**
 * 392.https://leetcode.com/problems/is-subsequence/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/24 15:56:40
 * @since JDK8.0
 */
public class Is_Subsequence_392 {
    public static void main(String[] args) {
        Is_Subsequence_392 r = new Is_Subsequence_392();
        Is_Subsequence_392.Solution solutin = r.new Solution();
//        String s = "abc", t = "ahbgdc";
//        String s = "axc", t = "ahbgdc";
//        String s = "", t = "ahbgdc"; // return true
        String s = "b", t = "abc"; // return true
        boolean result = solutin.isSubsequence(s, t);
        System.out.print(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 index 當左 s 的 index
         * 去比較 t 的內容，如果一樣 index++，最後看 index 是否達到 s.length
         */
//        public boolean isSubsequence(String s, String t) {
//            if (s.length() == 0) return true;
//            int index = 0;
//            for (int i = 0; i < t.length(); i++) {
//                if (s.charAt(index) == t.charAt(i)) {
//                    index++;
//                }
//                if(index == s.length()) return true;
//            }
//            return false;
//        }

        /**
         * test2
         * 優化:
         * 使用 char[] 會比 charAt 還快，雖然 charAt 底層也是去抓 value[index]
         *
         * 若要遍歷單一個字就用 charAt
         * 但如果還要對其操作建議用 toCharArray，畢竟 toCharArray 一次就轉好
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            int index = 0;
            for(char c: charT){
                if(charS[index] == c){
                    index++;
                    if(index == s.length()) return true;
                }
            }
            return false;
        }
    }
}
