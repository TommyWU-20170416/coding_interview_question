package array;

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
//        String str = "the sky is blue";
        String str = "  hello  world  ";
//        String str = "a good   example";
        String result = s.reverseWords(str);
        System.out.println("result: " + result + ";");
    }

    class Solution {
        /**
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
         * test2
         * 使用方法:
         * 1. 從後面往前找第一個單字的尾巴(如果start_index < 0 就是找完了要跳脫)
         * 2. 找到後繼續往下找第一個空白(如果start_index < 0 就是找完了要跳脫)
         * 3. 空白 +1 ~ 尾巴 = 最後一組單字
         * 4. 把單字放到 res
         * 5. 單字新增空格
         */
        public String reverseWords(String s) {
            char[] str = s.toCharArray();
            char[] res = new char[s.length() + 1];

            int start = s.length() - 1;
            int end;
            int count = 0;

            while (start >= 0) {
                while (start >= 0 && str[start] == ' ') {
                    start--;
                }
                if (start == -1) break;
                end = start;
                while (start >= 0 && str[start] != ' ') {
                    start--;
                }
                for (int i = start + 1; i <= end; i++) {
                    res[count] = str[i];
                    count++;
                }
                res[count] = ' ';
                count++;
            }

            return new String(res, 0, count - 1);
        }
    }
}
