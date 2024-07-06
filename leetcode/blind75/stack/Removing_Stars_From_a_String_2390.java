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
         * 當 leet*a => leea
         * -- 012345 => 0123 => 5 變 3 = 5 - (1個* X 2) = 3
         * 當 leet**a => lea
         * -- 0123456 => 012 => 6 變 2 = 6 - (2個* X 2) = 2
         *
         * 由這樣的推斷，可以知道說 * 符號個數是要累加的
         * 最後因為 chars 的星號都被取代掉，所以要設定取 substring 的範圍
         * 一個 * 要取代兩個字，所以長度就會是 總長 - 2 X * 個數量
         *
         * time complexity: 10ms
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
         * getBytes() 是直接把 string 的字 一個個用 java 平台的預設語系去取資料，所以會相對比較慢
         * time complexity: 7ms
         */
//        public String removeStars(String s) {
//            int l = s.length();
//            byte[] bytes = s.getBytes();
//            int countStars = 0;
//            for (int i = 0; i < l; i++) {
//                if (bytes[i] == '*') countStars++;
//                else bytes[i - countStars * 2] = bytes[i];
//            }
//            return new String(bytes, 0, l - countStars * 2);
//        }

        /**
         * 使用 getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) 取代 getBytes()
         * 但這方法已經被 deprecated
         * <ul>內存分配:
         *  <li>上面的方法創建了一個新的字節數組，而下面這種方法使用的是已經分配好的字節數組。內存分配可能會增加額外的時間開銷。</li>
         * </ul>
         *
         * <ul>數據複製:
         *  <li>上面的方法將整個字符串的所有字符轉換為字節，這需要額外的數據複製操作。而下面這種方法僅在指定範圍內進行轉換和複製，減少了不必要的操作。</li>
         * </ul>
         *
         * <ul>範圍限制:
         *  <li>上面的方法只處理字符串的指定範圍，這可能會比處理整個字符串更高效，尤其當需要轉換的範圍較小時。</li>
         * </ul>
         * 因為是直接把每個字強轉(byte) 所以會更快
         * time complexity: 5ms
         */
        public String removeStars(String s) {
            int l = s.length();
            byte[] res = new byte[l];
            s.getBytes(0, l, res, 0);
            int countStars = 0;
            for (int i = 0; i < l; i++) {
                if (res[i] == 42) countStars++;
                else res[i - countStars * 2] = res[i];
            }
            return new String(res, 0, l - countStars * 2);
        }
    }
}