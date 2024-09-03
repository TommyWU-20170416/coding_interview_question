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
        int[] result = test.dailyTemperatures(temperature);
        System.out.println(result);
    }

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
     * 使用 hottest 紀錄最熱的那一天，如果當天溫度比 hottest 還高，就更新 hottest，且因為他是最熱的，所以 ans[i] = 0 找不到比他更熱的
     * 使用 while 一個個 比較
     * ans 可以看成是一個相對的座標，以 {72, 70, 69, 68, 78} 來看，會得到 [4, 3, 2, 1, 0]
     * 以 72 來講就是要到第 4 位 是比我更熱的
     * 再拆解來看
     * 72 後面的 70 比我小，代表我要的溫度在他之後，所以我就是把 70 找到的座標(index: 1)再加上(3)，我就可以直接去找(78)這溫度做比較
     * 不用一個個做比對
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = Integer.MIN_VALUE;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
            } else {
                int afterIndex = i + 1;
                while (temperatures[i] >= temperatures[afterIndex]) {
                    afterIndex += ans[afterIndex];
                }
                ans[i] = afterIndex - i;
            }
        }

        return ans;
    }
}