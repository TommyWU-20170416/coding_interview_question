package slidingwindow;

/**
 * 643.https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/25 14:01:15
 * @since JDK8.0
 */
public class Maximum_Average_Subarray_I_643 {

    public static void main(String[] args) {
        Maximum_Average_Subarray_I_643 r = new Maximum_Average_Subarray_I_643();
        Maximum_Average_Subarray_I_643.Solution solution = r.new Solution();

//        int[] nums = {1, 12, -5, -6, 50, 3};
//        int k = 4; // 12.75000
        int[] nums = {-1};
        int k = 1;

//        int[] nums = {8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244,
//                -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406,
//                -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429,
//                160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
//        int k = 93;
        double result = solution.findMaxAverage(nums, k);
        System.out.println("reuslt:" + result);
    }


    class Solution {

        /**
         * Runtime: 3 ms, Beats 80.17%
         * test1
         * 解法:
         * 當加滿 K 後開始計算 max ，然後扣掉 start 並 ++;
         * <p>
         * 注意
         * windowCount = Integer.MIN_VALUE 是因為可能最小值會是 -10000 - 100000 所以要找比他更小的
         */
        public double findMaxAverage(int[] nums, int k) {
            int windowStart = 0, windowCount = Integer.MIN_VALUE, windowCountTmp = 0;

            for (int i = 0; i < nums.length; i++) {
                windowCountTmp += nums[i];
                if (i - windowStart + 1 == k) {
                    windowCount = Math.max(windowCountTmp, windowCount);
                    windowCountTmp -= nums[windowStart++];
                }
            }
            return (double) windowCount / (double) (k);
        }
    }
}
