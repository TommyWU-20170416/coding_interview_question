package stack;

import java.util.Stack;

/**
 * 150.https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/05 16:36:14
 * @since JDK8.0
 */
public class Evaluate_Reverse_Polish_Notation_150 {
    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation_150 ss = new Evaluate_Reverse_Polish_Notation_150();
        Evaluate_Reverse_Polish_Notation_150.Solution solution = ss.new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"}; // ((2 + 1) * 3) = 9
//        String[] tokens = {"4", "13", "5", "/", "+"}; // (4 + (13 / 5)) = 6
//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = solution.evalRPN(tokens);
        System.out.print(result);
    }


    class Solution {
        public int evalRPN(String[] tokens) {
            // '+', '-', '*', '/'
            Stack<Integer> stack = new Stack<>();
            for (String s : tokens) {
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    if (s.equals("+")) stack.push(a + b);
                    else if (s.equals("-")) stack.push(a - b);
                    else if (s.equals("*")) stack.push(a * b);
                    else if (s.equals("/")) stack.push(a / b);
                } else stack.push(new Integer(s));
            }
            return stack.peek();
        }
    }
}
