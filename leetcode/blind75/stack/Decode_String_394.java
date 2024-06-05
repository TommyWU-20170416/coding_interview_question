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
        Decode_String_394 s = new Decode_String_394();
        Decode_String_394.Solution solution = s.new Solution();

        String str = "3[a]2[bc]";
        String result = solution.decodeString(str);
        System.out.print(result);
        System.out.println();

    }

    class Solution {
        public String decodeString(String s) {
            Stack<Integer> stack_integer = new Stack<>();
            Stack<StringBuilder> stack_string = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = 0;

            for (char c : s.toCharArray()) {
                // digital
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');// 字符數字轉換為對應的整數 '0' = 48
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
