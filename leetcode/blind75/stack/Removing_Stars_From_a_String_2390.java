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
         * Runtime: 66 ms, Beats 63.96%
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
         * Runtime: 8 ms, Beats 99.52%
         * 解法:
         * 把 string 轉成 char 處理
         * 當 leet*a => leea
         * -- 012345 => 0123 => 5 變 3 = 5 - (1個* X 2) = 3
         * 當 leet**a => lea
         * -- 0123456 => 012 => 6 變 2 = 6 - (2個* X 2) = 2
         *
         * 由這樣的推斷，可以知道說 * 符號個數是要累加的
         * 最後因為 chars 的星號都被取代掉，所以要設定取 substring 的範圍
         * 一個 * 要取代兩個字，所以長度就會是 總長 - 2 X * 個數量
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