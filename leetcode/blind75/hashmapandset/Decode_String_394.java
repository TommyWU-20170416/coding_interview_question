package hashmapandset;

import java.util.Stack;

/**
 * 394.https://leetcode.com/problems/decode-string/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/02 14:32:48
 * @since JDK8.0
 */
public class Decode_String_394 {
    public static void main(String[] args) {
        Decode_String_394 r = new Decode_String_394();
        Decode_String_394.Solution solution = r.new Solution();
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
        String s = "123[leetcode]";
        String result = solution.decodeString(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {

        /**
         * test1
         * 解法
         * 1. 先記錄數字
         * 2. 紀錄"[" 要做什麼
         * 3. 紀錄"]" 要做什麼
         * 4. 紀錄字號要做什麼
         */
        public String decodeString(String s) {
            Stack<Integer> stack_integer = new Stack<>();
            Stack<StringBuilder> stack_string = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = 0;

            for (char c : s.toCharArray()) {
                // digital
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');// 字符數字轉換為對應的整數 '0' = 48， n * 10 是為了非個位數的計算
                } else if (c == '[') {
                    stack_integer.push(n);
                    n = 0;
                    stack_string.push(sb);
                    sb = new StringBuilder();
                } else if (c == ']') {
                    int k = stack_integer.pop();
                    String tmp = sb.toString();
                    sb = stack_string.pop();
                    while (k-- > 0) {
                        sb.append(tmp); // append(String) 會比 append(StringBuilder) 還要快
                    }
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
