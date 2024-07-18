package string;

/**
 * 8.https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 13:11:20
 * @since JDK8.0
 */
public class String_To_Integer_Atoi_8 {
    public static void main(String[] args) {
        String_To_Integer_Atoi_8 ss = new String_To_Integer_Atoi_8();
        String_To_Integer_Atoi_8.Solution solution = ss.new Solution();
//        String s = "42"; // 42
//        String s = "   -042"; // -42
//        String s = "1337c0d3"; // 1337
//        String s = "0-1"; // 0
//        String s = "00001-1"; // 0
//        String s = "words and 987"; // 0
        String s = "-91283472332";
//        String s = "-2147483648";
//        String s = "+ 0 12";
//        String s = "    0000000000000   ";
        int result = solution.myAtoi(s);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 4 ms, Beats 13.03%
         * 簡單說就是一個個條件下去作業
         */
//        public int myAtoi(String s) {
//            // 先略過 leading space
//            s = s.trim();
//            if (s.length() == 0) return 0;
//            char[] chars = s.toCharArray();
//
//            // 判斷正負
//            // 如果有正負要記錄
//            // 如果沒有正負，而是數字或字母或小數點
//            int index = 0;
//            StringBuilder sb = new StringBuilder();
//
//            if (chars[0] == '-' ) {
//                index++;
//                sb.append(chars[0]);
//            } else if (chars[0] == '+' ) {
//                index++;
//                sb.append(chars[0]);
//            } else if (Character.isAlphabetic(chars[index])) {
//                return 0;
//            }
//            if (index == chars.length) return 0;
//
//            // handle leading zero   0040  004a 0-1
//            for (int i = index; i < chars.length; i++) {
//                char ch = chars[index];
//                if (Character.isDigit(ch))
//                    if (ch == '0' ) {
//                        index++;
//                    } else {
//                        break;
//                    }
//                else if (Character.isAlphabetic(ch) || ch == '-' || ch == '+' || ch == ' ' ) {
//                    return 0;
//                }
//            }
//            if (index == chars.length) return 0;
//
//            for (int i = index; i < chars.length; i++) {
//                char ch = chars[i];
//                if (Character.isDigit(ch)) {
//                    sb.append(ch);
//                } else {
//                    if (sb.length() != 0) break;
//                    return 0;
//                }
//            }
//
//            // 溢位檢查 如果長度超過 20 或 超過 2147483647 ~ -2147483648
//            if (sb.length() > 11) {
//                if (sb.charAt(0) == '-' ) {
//                    return Integer.MIN_VALUE;
//                }
//                return Integer.MAX_VALUE;
//            }
//
//            if (Long.valueOf(new String(sb)) < Integer.MIN_VALUE) {
//                return Integer.MIN_VALUE;
//            } else if (Long.valueOf(new String(sb)) > Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//
//
//            return Integer.valueOf(new String(sb));
//        }

        /**
         * Runtime: 1 ms, Beats 100.00%
         * 前面方法都一樣，先 檢查空字串 > trim > 檢查空字串 > 判斷正負號
         * 差別在於最後整併數字，他是邊做，邊檢查有沒有溢位
         * 這樣可以減少最後處理的判斷，因為當作到 第 10 位 也就是 2^31 ~ -2^31 的位置時就可以馬上檢查
         */
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            // 去除前導空格
            str = str.trim();
            if (str.length() == 0) {
                return 0;
            }

            int index = 0;
            int sign = 1;
            long total = 0;

            // 判斷正負號
            if (str.charAt(index) == '+' || str.charAt(index) == '-' ) {
                sign = (str.charAt(index) == '+' ) ? 1 : -1;
                index++;
            }

            // 轉換數字並避免溢出
            while (index < str.length()) {
                int digit = str.charAt(index) - '0';
                if (digit < 0 || digit > 9) {
                    break;
                }

                total = total * 10 + digit;

                // 檢查溢出情況
                if (sign == 1 && total > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -total < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                index++;
            }

            return (int) total * sign;
        }
    }
}
