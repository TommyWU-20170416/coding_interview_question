package nextgreaterelement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 739.https://leetcode.com/problems/daily-temperatures/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月30日 下午5:23:11
 * @since JDK8.0
 * <p>
 * For example, given the list of temperatures temperatures =
 * [73, 74,75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class Daily_Temperatures {

    private static int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};

    public static void main(String[] args) {
        Daily_Temperatures test = new Daily_Temperatures();
        printArray(test.dailyTemperatures(temperature));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int a = stack.pop();
                nextGreater.put(a, i - a);
            }
            stack.push(i);
        }
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            result[i] = nextGreater.getOrDefault(i, 0);
        }
        return result;


//		if(temperatures == null || temperatures.length == 0) return null;
//		int[] res = new int[temperatures.length];
//		Deque<Integer> stack = new LinkedList<Integer>();
//		for (int i = temperatures.length - 1; i >= 0; i--) {
//			while( !stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
//				stack.pop();
//			}
//			res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
//			stack.push(i);
//		}
//
//		return res;
    }

    public static void printArray(int[] num) {
        System.out.print("i: ");
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}