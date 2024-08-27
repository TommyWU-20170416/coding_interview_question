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
         * Runtime: 0 ms, Beats 100.00%
         * 優化:
         * 使用 char[] 會比 charAt 還快，雖然 charAt 底層也是去抓 value[index]
         * <p>
         * 若要遍歷單一個字就用 charAt
         * 但如果還要對其操作建議用 toCharArray，畢竟 toCharArray 一次就轉好
         * <p>
         * 另外把第二個 if 寫在裡面會比單獨寫在外面好，因為有++的時候才要判斷
         */
        public boolean isSubsequence(String s, String t) {
            if (s.equals(t) || s.length() == 0)
                return true;
            char[] charS = s.toCharArray(), charT = t.toCharArray();
            int indexS = 0;
            for (char c : charT) {
                if (c == charS[indexS]) {
                    indexS++;
                    if (indexS == charS.length)
                        return true;
                }
            }
            return false;
        }
    }
}
