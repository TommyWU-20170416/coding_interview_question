package stack;

/**
 * 20.https://leetcode.com/problems/valid-parentheses/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/05 15:23:04
 * @since JDK8.0
 * <p>
 * 這題的 ()[]{} 只會一組一組出現，也會有穿插如 {[()]} 這樣
 */
public class Valid_Parentheses_20 {
    public static void main(String[] args) {
        Valid_Parentheses_20 ss = new Valid_Parentheses_20();
        Valid_Parentheses_20.Solution solution = ss.new Solution();
        String s = "]"; // 40 41 91 93 123 125
//        String s = "()[]{}";
//        String s = "{[()]}";
        boolean result = solution.isValid(s);
        System.out.print(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 當判斷有 ( [ { 加入的時候
         * 就在 stack 加入另一半
         * 這樣下一輪就可以去檢查是否另一半也在這 s 內
         */
//        public boolean isValid(String s) {
//            Stack<Character> stack = new Stack<>();
//            for (char c : s.toCharArray()) {
//                if (c == '(') stack.push(')');
//                else if (c == '[') stack.push(']');
//                else if (c == '{') stack.push('}');
//
//
//                if (stack.isEmpty()) return false;
//                else if (c == ')') {
//                    if (stack.peek() == ')') stack.pop();
//                    else return false;
//                } else if (c == ']') {
//                    if (stack.peek() == ']') stack.pop();
//                    else return false;
//                } else if (c == '}') {
//                    if (stack.peek() == '}') stack.pop();
//                    else return false;
//                }
//            }
//            return stack.isEmpty();
//        }

        /**
         * 優化:
         * 當 stack 裡面有值 且已經排除 ( [ { 後，代表接下來要判斷的值 = stack.pop()
         * 如果不是就 return false
         */
//        public boolean isValid(String s) {
//            Stack<Character> stack = new Stack<>();
//            for (char c : s.toCharArray()) {
//                if (c == '(') stack.push(')');
//                else if (c == '[') stack.push(']');
//                else if (c == '{') stack.push('}');
//                else if (stack.isEmpty() || stack.pop() != c) return false;
//            }
//            return stack.isEmpty();
//        }

        /**
         * test2
         * 使用一個陣列紀錄左邊的位置，來比對當前
         * 如果陣列紀錄的 跟 當前 是一組，陣列指標就往前
         * 直到 字串跑完 或是發現不匹配 return false
         */
        public boolean isValid(String s) {
            int i = -1;
            char[] leftChars = new char[s.length()];
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    leftChars[++i] = c;
                } else {
                    if (i > -1 && ((leftChars[i] == '(' && c == ')') || (leftChars[i] == '[' && c == ']') || (leftChars[i] == '{' && c == '}'))) {

                        i--;
                    } else return false;
                }
            }
            return i == -1;
        }
    }
}
