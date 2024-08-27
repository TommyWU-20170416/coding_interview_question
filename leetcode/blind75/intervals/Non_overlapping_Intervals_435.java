package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}}; // Output: 1
//        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}}; // Output: 2
        int[][] intervals = {{0, 2}, {4, 6}, {8, 10}, {1, 3}}; // Output:
        int result = s.eraseOverlapIntervals(intervals);

        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 48 ms, Beats 61.22%
         * 原本是一整組 int[] 來看，現在就用 end 來看，因為也已經排序過
         * 等於說 [[1,2],[2,3],[3,4],[1,3]] 排序過變成 [[1,2],[1,3],[2,3],[3,4]]，頭都排序過了，只要看 end
         * 1. 若 區間有重疊，更新 min end
         * 2. 若沒有重疊，更新 end
         */
//        public int eraseOverlapIntervals(int[][] intervals) {
//            // 按照區間的起點進行排序
//            Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
//
//            int count = 0;
//            int end = intervals[0][1]; // 初始的結束時間
//            // 如果上次最小 end > 起始代表重疊
//            for (int i = 1; i < intervals.length; i++) {
//                if (intervals[i][0] < end) {
//                    count++;
//                    end = Math.min(end, intervals[i][1]); // 更新結束時間為較早的那個區間
//                    // end 挑最小代表可以容納更多區間，達到 minimum number of intervals you need to remove
//                } else {
//                    // 無重疊，更新結束時間
//                    end = intervals[i][1];
//                }
//            }
//            return count;
//        }

        /**
         * Runtime: 5 ms, Beats 99.42%
         * 因為省略了排序，所以從 O(n log n) 下降至 O(n)
         * 1. 找出 右邊區間 max, min
         * 2. 把 右邊區間 max - min + 1 得到一個 以 1 為單位的區間數量。EX: min = 2, max = 4 就會是 [1,2][2,3][3,4]
         * 3. 把每一個內容都填上 Integer.MIN_VALUE 然後根據 end 偏移 minEnd 當作 index 去放入 左邊區間。EX: [1 , 2, 3]
         * 4. 尋找不重複的區間，若在 min ~ max 之間沒有對應到的左邊區間 = Integer.MIN_VALUE
         * -   end <= startRecord[i] 意思是 右邊區間 <= 左邊區間 就像是 [1, 2][2, 3] 就是不重複區間，count++
         * 5. 把 intervals - 不重複區間 = 重複區間
         */
        public int eraseOverlapIntervals(int[][] intervals) {
            int maxEnd = intervals[0][1];
            int minEnd = maxEnd;
            for (int i = 1; i < intervals.length; i++) {
                maxEnd = Math.max(maxEnd, intervals[i][1]);
                minEnd = Math.min(minEnd, intervals[i][1]);
            }

            // 右邊界的左邊界值
            int[] startRecord = new int[maxEnd - minEnd + 1];// 找出最多可能的區間數
            Arrays.fill(startRecord, Integer.MIN_VALUE);

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1] - minEnd;
                startRecord[end] = Math.max(startRecord[end], start); // 以 minEnd ~ maxEnd 當作 index 且歸 0 算，所以要減掉 minEnd，並放入比較大的 start
            }
            int end = minEnd;
            int count = 1;
            for (int i = 1; i < startRecord.length; i++) {
                // 這邊是要找不重疊的區域
                if (end <= startRecord[i]) {
                    count++;
                    // 因為 end 已經被轉換為 index
                    // 如果要找 min = 2，index 0 就是 2 的意思
                    // 也等於 index 0 + min = 2
                    end = i + minEnd;
                }
            }
            return intervals.length - count;
        }
    }
}
