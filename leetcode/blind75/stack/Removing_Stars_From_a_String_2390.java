package stack;
/**
 * 2390.https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/05/29 17:33:11
 * @since JDK8.0
 */

public class Removing_Stars_From_a_String_2390 {
    public static void main(String[] args) {
        Removing_Stars_From_a_String_2390 s = new Removing_Stars_From_a_String_2390();
        Removing_Stars_From_a_String_2390.Solution solution = s.new Solution();
        String str = "leet**cod*e";
        String result = solution.removeStars(str);
        System.out.print(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 stack 儲存字
         */
//        public String removeStars(String s) {
//            Stack stack = new Stack();
//            for (char c : s.toCharArray()) {
//                if (c == '*') {
//                    stack.pop();
//                } else {
//                    stack.push(c);
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < stack.size(); i++) {
//                sb.append(stack.get(i));
//            }
//            return sb.toString();
//        }

        /**
         * test2
         * 解法:
         * 把 string 轉成 char 處理
         */
//        public String removeStars(String s) {
//            int l = s.length();
//            char[] chars = s.toCharArray();
//            int countStars = 0;
//            for (int i = 0; i < l; i++) {
//                if (chars[i] == '*') countStars++;
//                else chars[i - countStars * 2] = chars[i];
//            }
//            return new String(chars, 0, l - countStars * 2);
//        }

        /**
         * test3
         * 解法
         * 把 char 轉成 byte 會更快
         */
        public String removeStars(String s) {
            int l = s.length();
            byte[] bytes = s.getBytes();
            int countStars = 0;
            for (int i = 0; i < l; i++) {
                if (bytes[i] == '*') countStars++;
                else bytes[i - countStars * 2] = bytes[i];
            }
            return new String(bytes, 0, l - countStars * 2);
        }
    }
}