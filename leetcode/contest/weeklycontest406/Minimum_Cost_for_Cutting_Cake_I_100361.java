package weeklycontest406;

import java.util.Arrays;

/**
 * 100361.https://leetcode.com/contest/weekly-contest-406/problems/minimum-cost-for-cutting-cake-i/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/14 11:40:56
 * @since JDK8.0
 */
public class Minimum_Cost_for_Cutting_Cake_I_100361 {
    public static void main(String[] args) {
        Minimum_Cost_for_Cutting_Cake_I_100361 ss = new Minimum_Cost_for_Cutting_Cake_I_100361();
        Minimum_Cost_for_Cutting_Cake_I_100361.Solution solution = ss.new Solution();

        int m = 3, n = 2;
        int[] horizontalCut = {1, 3}, verticalCut = {5};
        int result = solution.minimumCost(m, n, horizontalCut, verticalCut);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 100.00%
         * 為了找最便宜的切法，所以一定事先從大的開始切，因此先把 horizontalCut[], verticalCut[] 做排序，並且由後面開始找
         * 算出 sumH sumV ，主要用途在當你 切了 H 就要加上 sumV，當你切了 V 就要加上 sumH，這是因為要切出 1 x 1 的，你在當下就是要切這樣子的方式
         * <p>
         * 接下來就是推理
         * 1. 由後往前，比對 h[i] v[j]，數字大的才可以切
         * 2. 切下去後要加上 另一邊的總和
         * 3. 接著把加過的 h[i] 或 v[j] 從總和中扣掉，因為之後不會再用到了
         * 4. 重複這行為直到某一邊無法再切( 這邊會想說一邊切完還可以繼續往其他方向切，這個就是 return 要在做的事情 )
         * 5. 由於已經有一邊無法切除，所以 res 要把剩下的 總和加總起來，就會是答案
         * <p>
         * EX: h[1, 3], v[5, 7], 3 * 3
         *
         * <pre>
         * {@code
         *      5     7
         *   A  |  B  |  C
         * 1 ---|-----|---
         *   D  |  E  |  F
         * 3 ---|-----|---
         *   G  |  H  |  I
         * }
         * </pre>
         * 切法會是 7(v) > 5(v) > 3(h) > 1(h)
         * 總數會是這樣算
         * 7 + 5 + 3(1 + 3)
         * 以 C 來講，要切出 C 這塊需要 7 + (1 + 3) = 7 + sumH = 11
         * 以 B 來講，要切出 B 這塊需要 5 + (1 + 3) = 5 + sumH = 9
         * 因為 V 都切完了，所以 return 加總 res + sumV + sumH = 20 + 0 + 4 = 24
         *
         *
         * <pre>
         * {@code
         *      4     8
         *   A  |  B  |  C
         * 2 ---|-----|---
         *   D  |  E  |  F
         * 6 ---|-----|---
         *   G  |  H  |  I
         * }
         * </pre>
         * 切法會是 8(v) > 6(h) > 4(v) > 2(h)
         * 總數會是這樣算
         * 8 + 2(6) + 2(4) + 3(2)
         * 以 I 來講，要切出 I 這塊需要 8 + (2 + 6) = 8 + sumH = 16
         * 以 H 來講，要切出 H 這塊需要 6 + (4    ) = 6 + sumV = 10
         * 以 A 來講，要切出 A 這塊需要 4 + (2    ) = 0 + sumH =  6
         * 因為 V 都切完了，所以 return 加總 res + sumV + sumH = 32 + 0 + 2 = 34
         */
        public int minimumCost(int m, int n, int[] h, int[] v) {
            Arrays.sort(h);
            Arrays.sort(v);
            int sumH = 0, sumV = 0, res = 0;
            for (int x : h) sumH += x;
            for (int x : v) sumV += x;

            int i = h.length - 1, j = v.length - 1;
            while (i >= 0 && j >= 0) {
                if (h[i] > v[j]) {
                    res += h[i] + sumV;
                    sumH -= h[i--];
                } else {
                    res += v[j] + sumH;
                    sumV -= v[j--];
                }
            }
            return res + sumH + sumV;
        }
    }
}
