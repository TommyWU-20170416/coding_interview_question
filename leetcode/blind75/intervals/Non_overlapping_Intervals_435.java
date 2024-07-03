package intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435.https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/03 17:11:46
 * @since JDK8.0
 */
public class Non_overlapping_Intervals_435 {
    public static void main(String[] args) {
        Non_overlapping_Intervals_435 r = new Non_overlapping_Intervals_435();
        Non_overlapping_Intervals_435.Solution s = r.new Solution();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}}; // Output: 2
        int result = s.eraseOverlapIntervals(intervals);

        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * 錯誤想法:
         * 因為我想像上是他會排序好，只是在其中插入一個，但如果起始就已經概括全部，我就會排除剩餘的
         */
//        public int eraseOverlapIntervals(int[][] intervals) {
//            List<int[]> newIntervals = new ArrayList<>();
//            newIntervals.add(intervals[0]);
//            Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
//
//            if (intervals.length == 1) return 0;
//
//            for (int i = 1; i < intervals.length; i++) {
//                if (intervals[i][0] >= newIntervals.get(newIntervals.size() - 1)[1]) {
//                    newIntervals.add(intervals[i]);
//                }
//            }
//
//            return intervals.length - newIntervals.size();
//        }

        /**
         *
         */
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;

            // 按照區間的起點進行排序
            Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

            int count = 0;
            int end = intervals[0][1]; // 初始的結束時間
            // 如果上次最小 end > 起始代表重疊
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    count++;
                    end = Math.min(end, intervals[i][1]); // 更新結束時間為較早的那個區間
                    // end 挑最小代表可以容納更多區間，達到 minimum number of intervals you need to remove
                } else {
                    // 無重疊，更新結束時間
                    end = intervals[i][1];
                }
            }
            return count;
        }
    }
}
