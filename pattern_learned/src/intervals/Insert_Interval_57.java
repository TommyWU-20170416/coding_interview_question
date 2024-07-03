package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 57.https://leetcode.com/problems/insert-interval/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/03 16:38:32
 * @since JDK8.0
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * 遍歷區間：找到所有不與新區間重疊的區間。
 * 合併區間：將與新區間重疊的區間合併。
 * 插入結果：將所有區間插入結果列表。
 */
public class Insert_Interval_57 {
    public static void main(String[] args) {
        Insert_Interval_57 r = new Insert_Interval_57();
        Insert_Interval_57.Solution s = r.new Solution();
//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] result = s.insert(intervals, newInterval);

        System.out.println("reuslt:" + result);
    }

    /**
     * intervals[i][1]< newInterval[0] < newInterval[1] < intervals[i][0]
     * 把不重疊的部分加入到 result
     * 處理重疊的部分
     */
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();
            int i = 0;
            int n = intervals.length;

            // add intervals before newInterval
            // 如果 end < new start 就可以加入，這邊會把不重疊且又比 newInterval[0] 小的放進 result
            while (i < n && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }

            // combine interval and newInterval overlap
            // 這邊直接想 while 條件會怪怪，反過來想，如果 newInterval[1] < intervals[i][0] 代表後面的 區間都比 newInterval 還大
            // 所以這個 while 要找的是 比 newInterval 小的
            // while 去找當前最小以及最大
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            result.add(newInterval);

            // add intervals after newInterval
            while (i < n) {
                result.add(intervals[i++]);
            }

            return result.toArray(new int[result.size()][]);
            // 實測不會比較快
//            int[][] res = new int[result.size()][];
//            for (int j = 0; j < ; j++) {
//                res[j] = result.get(j);
//            }
//            return res;
        }
    }
}
