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
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int result = s.findMinArrowShots(points);

        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 想像上就是當兩者有交集後，找出最大的 start, 最小的 end，那塊就是重疊的地方
         * 接著若下一個不再這區間內，表示這是全新的一個，就 + 1;
         * 即便只有一個 point 也要一個飛鏢，所以 count 預設 1
         */
//        public int findMinArrowShots(int[][] points) {
//            Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0]));
//            int start = points[0][0], end = points[0][1];
//            int count = 1;
//
//            for (int i = 1; i < points.length; i++) {
//                int curStart = points[i][0], curEnd = points[i][1];
//                if (curStart <= end) {
//                    // merge
//                    start = Math.max(start, curStart);
//                    end = Math.min(end, curEnd);
//                } else {
//                    start = curStart;
//                    end = curEnd;
//                    count++;
//                }
//            }
//            return count;
//        }

        /**
         * test2:
         * 想法:
         * 因為是用 end 作為排序，因此如果你的氣球在我的飛鏢之前，都算是我可以命中的範圍
         * 如果你的氣球超過我的飛鏢位置，那就代表這是新的區域
         *
         * 為什麼要用 end 做排序
         * 如果今天是 [0, 9][3, 8][9, 10] 第一次選出 9 為飛鏢位置，後面會發現 飛鏢位置不會變，這樣就不對了
         * 應該要排成 [3, 8][0, 9][9, 10] 第三次才有辦法識別要換飛鏢位置了
         */
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

            int arrows = 1;
            int arrowPos = points[0][1];

            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > arrowPos) {
                    arrows++;
                    arrowPos = points[i][1];
                }
            }

            return arrows;
        }
    }
}
