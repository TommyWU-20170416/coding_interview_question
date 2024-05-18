package slidewindow;

/**
 * 209.https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月11日 下午10:36:05
 * @since JDK8.0
 * <p>
 * Given an array of positive integers nums and a positive integer
 * target, return the minimal length of a contiguous subarray [numsl,
 * numsl+1, ..., numsr-1, numsr] of which the sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the
 * problem constraint.
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Input: target = 15, nums = [1,2,3,4,5]
 * Output: 0
 */
public class Minimum_Size_Subarray_Sum {
    private static int[] nums = {1, 15, 2, 3, 4};
    private static int target = 15;

    public static void main(String[] args) {
        Minimum_Size_Subarray_Sum test = new Minimum_Size_Subarray_Sum();
        System.out.println(test.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int windowCount = 0, windowStart = 0, windowSize = nums.length;
        for (int i = 0; i < nums.length; i++) {
            windowCount += nums[i];
            while (windowCount >= target) {
                windowSize = Math.min(windowSize, i - windowStart + 1);
                windowCount -= nums[windowStart];
                windowStart++;
            }
        }
        return windowSize;
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        int window_start = 0, window_sum = 0;
//        int window_size = nums.length + 1;
//        /* 當全部加起來也沒有達到target，那就代表找不到要 return 0 */
//
//        for (int window_end = 0; window_end < nums.length; window_end++) {
//            window_sum += nums[window_end];
//
//            while (window_sum >= target) {
//                window_size = Math.min(window_size, window_end - window_start + 1);
//                window_sum -= nums[window_start];
//                window_start++;
//            }
//        }
//        return window_size == nums.length + 1 ? 0 : window_size;
    }
}
