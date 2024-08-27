package slidingwindow;

/**
 * 1004.https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/25 15:43:31
 * @since JDK8.0
 */
public class Max_Consecutive_Ones_III_1004 {
    public static void main(String[] args) {
        Max_Consecutive_Ones_III_1004 r = new Max_Consecutive_Ones_III_1004();
        Max_Consecutive_Ones_III_1004.Solution solution = r.new Solution();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2; // Output: 6
//        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int k = 3;
        int result = solution.longestOnes(nums, k);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 2 ms, Beats 100.00%
         * 解法:
         * 計算0出現的次數
         * 條件不符合就修改頭或尾，不使用 max，是因為每一次都只會動一格，當今天先遇到比較長的 substring，後面的長度就會用這個下去算
         * <p>
         * 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0          k = 2
         * 1, 1, 1, 0, 0                            zeroCount = 2
         * -  1, 1, 0, 0, 0                         zeroCount = 3 > k 所以左邊縮減，此時最長就是 5
         * -     1, 0, 0, 0, 1                      會一路用 5 下去算，除非最後面有更長的
         * -     1, 0, 0, 0, 1, 1                   這邊就是遇到 1 所以長度會繼續變長
         * -     1, 0, 0, 0, 1, 1, 1                又是 1 繼續累加
         * -     1, 0, 0, 0, 1, 1, 1, 1
         */
        public int longestOnes(int[] nums, int k) {
            int start = 0, end = 0, zeroCount = 0;

            while (end < nums.length) {
                zeroCount += 1 - nums[end++];
                if (zeroCount > k) {
                    zeroCount -= 1 - nums[start++];
                }
            }
            return end - start;
        }

        /**
         * Runtime: 3 ms, Beats 85.80%
         * 解法:
         * 改用 for 條件
         */
//        public int longestOnes(int[] nums, int k) {
//            int start = 0, zeroCounts = 0, size = 0;
//            for (int end = 0; end < nums.length; end++) {
//                zeroCounts += 1 - nums[end];
//
//                while (zeroCounts > k) {
//                    zeroCounts -= 1 - nums[start++];
//                }
//                size = Math.max(size, end - start + 1);
//            }
//            return size;
//        }
    }
}
