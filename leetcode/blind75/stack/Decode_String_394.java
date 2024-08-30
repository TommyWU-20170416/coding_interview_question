package stack;

import java.util.Stack;

/**
 * 394.https://leetcode.com/problems/decode-string/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 23:01:06
 * @since JDK8.0
 */
public class Decode_String_394 {
    public static void main(String[] args) {
        Decode_String_394 ss = new Decode_String_394();
        Decode_String_394.Solution solution = ss.new Solution();

//        String s = "3[a]2[bc]"; // Output: "aaabcbc"
        String s = "3[a2[c]]"; // Output: "accaccacc"

        String result = solution.decodeString(s);
        System.out.print(result);
        System.out.println();

    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 解法
         * 1. 遇到數字，記錄數字
         * 2. 遇到"["，記錄前面遇到的數字以及英文字，紀錄後要初始化。 因為遇到 "[" 代表要處理後面的東西了，所以都先記錄起來
         * 3. 遇到"]"，處理先前記憶的 sb + stackString.pop 出來的。 sb 是從"["到"]"之間的字母，他要跟 stackString.pop 出來的字母做多次組合
         * 4. 遇到字母，紀錄字母
         */
        public String decodeString(String s) {
            Stack<Integer> stackInteger = new Stack<>();
            Stack<StringBuilder> stackString = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = 0;

            for (char c : s.toCharArray()) {
                // digital
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');// 字符數字轉換為對應的整數 '0' = 48
                } else if (c == '[') {
                    stackInteger.push(n);
                    n = 0;
                    stackString.push(sb);
                    sb = new StringBuilder();
                } else if (c == ']') {
                    int k = stackInteger.pop();
                    String tmp = sb.toString();
                    sb = stackString.pop();
                    while (k-- > 0) {
                        sb.append(tmp);
                    }
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
