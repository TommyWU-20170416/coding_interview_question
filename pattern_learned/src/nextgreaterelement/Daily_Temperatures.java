package nextgreaterelement;

import java.util.*;

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

    /**
     * tset1
     * 解法:
     * 使用 map 去紀錄每個座標，以及比該座標還大多少的位置
     * 由前往後算，stack 會儲存由大到小
     *
     * 最後再把 stack 的值放到 result 內，所以會多做一組 O(n)
     * Runtime: 86 ms, Beats 9.22%
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        Map<Integer, Integer> nextGreater = new HashMap<>();
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//                int a = stack.pop();
//                nextGreater.put(a, i - a);
//            }
//            stack.push(i);
//        }
//        int[] result = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            result[i] = nextGreater.getOrDefault(i, 0);
//        }
//        return result;
//    }

    /**
     * test2
     * Runtime: 27ms, Beats 81.70%
     * 編作的同時，就把 reuslt 準備好
     * 這個事由後到前作法，stack 會儲存由大到小
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        Deque<Integer> stack = new LinkedList<>();
//        for (int i = temperatures.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
//                stack.pop();
//            }
//            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
//            stack.push(i);
//        }
//
//        return res;
//    }

    /**
     * test3
     * Runtime: 6ms, Beats 100.00%
     * 使用 hottest 紀錄最熱的那一天
     * 使用 while 一個個 比較
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = Integer.MIN_VALUE;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
            } else {
                int it = i + 1;
                while (temperatures[it] <= temperatures[i]) {
                    it += ans[it];
                }
                ans[i] = it - i;
            }
        }

        return ans;
    }


    public static void printArray(int[] num) {
        System.out.print("i: ");
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}