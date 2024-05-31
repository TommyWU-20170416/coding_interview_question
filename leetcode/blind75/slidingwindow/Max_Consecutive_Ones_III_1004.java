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
        int[] nums = {1, 1, 1, 0, 0, 0, 1};
        int k = 2;
//        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int k = 3;
        int result = solution.longestOnes(nums, k);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * test1:
         * 解法:
         * 計算0出現的次數
         * 條件不符合就修改頭或尾
         */
//        public int longestOnes(int[] nums, int k) {
//            int windowStart = 0, windowEnd = 0, zeroCount = 0;
//
//            while (windowEnd < nums.length) {
//                if (nums[windowEnd] == 0) {
//                    zeroCount++;
//                }
//                if (zeroCount > k) {
//                    // 這樣寫比較簡潔
//                    zeroCount -= 1 - nums[windowStart]; // if nums[l] == 0 => zeros = zeros - (1 - 0)
//                    windowStart++;
//                }
//                windowEnd++;
//            }
//            return windowEnd - windowStart;
//        }

        /**
         * test2
         * 解法:
         * 改用 for 條件
         */
        public int longestOnes(int[] nums, int k) {
            int start = 0, zeroCounts = 0, size = 0;
            for (int end = 0; end < nums.length; end++) {
                zeroCounts += 1 - nums[end];

                while (zeroCounts > k) {
                    zeroCounts -= 1 - nums[start++];
                }
                size = Math.max(size, end - start + 1);
            }
            return size;
        }
    }
}
