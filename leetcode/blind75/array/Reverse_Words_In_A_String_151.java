package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 151.https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/23 13:17:49
 * @since JDK8.0
 */
public class Reverse_Words_In_A_String_151 {
    public static void main(String[] args) {
        Reverse_Words_In_A_String_151 r = new Reverse_Words_In_A_String_151();
        Reverse_Words_In_A_String_151.Solution s = r.new Solution();
        String str = "the sky is blue";
//        String str = "  hello  world  ";
//        String str = "a good   example";
        String result = s.reverseWords(str);
        System.out.println("result: " + result + ";");
    }

    class Solution {
        /**
         * Runtime: 6 ms, Beats 85.41%
         * test1
         * 使用方法:
         * 1. 先把 前後空白都 trim 掉
         * 2. 使用 split 含有至少一個空格以上的都分開來
         * 3. 最後合併起來
         */
//        public String reverseWords(String s) {
//            // trim head and tail
//            s = s.trim();
//            String[] words = s.split("\\s+");
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = words.length - 1; i >= 0; i--) {
//                stringBuilder.append(words[i]);
//                if (i != 0) {
//                    stringBuilder.append(" ");
//                }
//            }
//            return stringBuilder.toString();
//        }

        /**
         * Runtime: 2 ms, Beats 99.56%
         * test2
         * 使用方法:
         * 1. 從後面往前找第一個單字的尾巴(如果start_index < 0 就是找完了要跳脫)
         * 2. 找到後繼續往下找第一個空白(如果start_index < 0 就是找完了要跳脫)
         * 3. 空白 +1 ~ 尾巴 = 一組單字
         * 4. 把單字放到 res
         * 5. 單字新增空格
         * 6. res 會 + 1 是因為最後會多一個空格，所以return 要砍掉
         */
        public String reverseWords(String s) {
            char[] inputChar = s.toCharArray(), result = new char[s.length() + 1]; // 因為每次都會多加一個空格，最後會減掉
            int start = s.length() - 1, end, len_result = 0;

            while (start >= 0) {
                while (start >= 0 && inputChar[start] == ' ') {
                    start--;
                }
                if (start == -1) break; // 這是為了避免當剩下空格的時候
                end = start;
                while (start >= 0 && inputChar[start] != ' ') {
                    start--;
                }
                // 注意這邊 start + 1 是因為他是找到空白才停止，空白後面才是單字的開頭
                for (int i = start + 1; i <= end; i++) {
                    result[len_result++] = inputChar[i];
                }
                result[len_result++] = ' ';
            }

            return new String(result, 0, len_result - 1);
        }
    }
}
