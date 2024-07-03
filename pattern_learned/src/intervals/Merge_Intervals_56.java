package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56.https://leetcode.com/problems/merge-intervals/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/03 15:13:07
 * @since JDK8.0
 * <p>
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * 排序：首先根據每個區間的起點對區間進行排序。
 * 合併：然後遍歷排序後的區間，並將重疊的區間合併。
 */
public class Merge_Intervals_56 {
    public static void main(String[] args) {
        Merge_Intervals_56 r = new Merge_Intervals_56();
        Merge_Intervals_56.Solution s = r.new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = s.merge(intervals);

        System.out.println("reuslt:" + result);
    }


    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }

            // 按照區間的起點進行排序
            // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 同等下面的意思
            // Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).reversed()); // 這是由小大到排序後，再進行翻轉，就可以獲得由大到小
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            List<int[]> result = new ArrayList<>(); // 因為不知道 merge 後的大小，所以先用 list 做使用
            int[] currentInterval = intervals[0];
            result.add(currentInterval);

            for (int[] interval : intervals) {
                int currentEnd = currentInterval[1];
                int nextStart = interval[0];
                int nextEnd = interval[1];

                if (currentEnd >= nextStart) {
                    // 重疊的區間，合併它們
                    currentInterval[1] = Math.max(currentEnd, nextEnd);
                } else {
                    // 不重疊的區間，將新的區間加入結果中
                    currentInterval = interval;
                    result.add(currentInterval);
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }
}
