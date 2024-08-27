package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 452.https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/03 18:56:26
 * @since JDK8.0
 */
public class Minimum_Number_Of_Arrows_To_Burst_Balloons_452 {
    public static void main(String[] args) {
        Minimum_Number_Of_Arrows_To_Burst_Balloons_452 r = new Minimum_Number_Of_Arrows_To_Burst_Balloons_452();
        Minimum_Number_Of_Arrows_To_Burst_Balloons_452.Solution s = r.new Solution();
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}; // Expected: 2
//        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int result = s.findMinArrowShots(points);

        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 59 ms, Beats 21.89%
         * 用 start 來排序
         * 當兩者有交集後，找出最大的 start, 最小的 end，那塊就是重疊的地方
         * 接著若下一個不再這區間內，表示這是全新的一個，就 + 1;
         * 即便只有一個 point 也要一個飛鏢，所以 count 預設 1
         */
//        public int findMinArrowShots(int[][] points) {
//            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // 使用這樣不用相減，所以不用擔心溢位
//            int count = 1;
//            int[] lastPoint = points[0];
//            for (int i = 1; i < points.length; i++) {
//                if (lastPoint[1] >= points[i][0]) {
//                    lastPoint[0] = Math.max(lastPoint[0], points[i][0]);
//                    lastPoint[1] = Math.min(lastPoint[1], points[i][1]);
//                } else {
//                    count++;
//                    lastPoint = points[i];
//                }
//            }
//            return count;
//        }

        /**
         * test2:
         * Runtime: 56 ms, Beats 37.40%，這方法跟 34 ms 答案一樣，但不知道為什麼就是比較慢
         * 因為是用 end 作為排序，因此如果你的氣球在我的飛鏢之前，都算是我可以命中的範圍
         * 如果你的氣球超過我的飛鏢位置，那就代表這是新的區域
         * <p>
         * 為什麼要用 end 做排序
         * 如果今天是 [0, 9][3, 8][9, 10] 第一次選出 9 為飛鏢位置，後面會發現 飛鏢位置不會變，這樣就不對了
         * 應該要排成 [3, 8][0, 9][9, 10] 第三次才有辦法識別要換飛鏢位置了
         */
//        public int findMinArrowShots(int[][] points) {
//            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // 使用這樣不用相減，所以不用擔心溢位
//            int count = 1;
//            int lastEnd = points[0][1];
//            for (int i = 1; i < points.length; i++) {
//                if (lastEnd < points[i][0]) {
//                    count++;
//                    lastEnd = points[i][1];
//                }
//            }
//            return count;
//        }

        /**
         * 這方法比較難記，先略過
         */
        public int findMinArrowShots(int[][] points) {
            final int n = points.length;
            final long[] A = new long[n];
            // 把 右區間放到 左32位，左區間放到右32位
            // 排序依照 數字大小，由小到大排，相當於用右邊界排序
            for (int i = 0; i < n; i++) {
                A[i] = (((long) points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
            }
            Arrays.sort(A);
            int prev = (int) (A[0] >>> 32); // 得到右區間
            int count = 1;
            for (int i = 1; i < A.length; i++) {
                // (int) A[i] 溢出後的結果取 int 型的最低32位 也就會得到左邊區間
                // 若 左邊區間 > 右邊區間，不重疊所以 + 1 更新 prev
                if ((int) A[i] > prev) {
                    count++;
                    prev = (int) (A[i] >>> 32);
                }
            }
            return count;
        }
    }
}
