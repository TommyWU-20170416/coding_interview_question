package slidingwindow;

/**
 * 1493.https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/02 13:22:32
 * @since JDK8.0
 */
public class Longest_Subarray_of_1s_After_Deleting_One_Element_1493 {
    public static void main(String[] args) {
        Longest_Subarray_of_1s_After_Deleting_One_Element_1493 r = new Longest_Subarray_of_1s_After_Deleting_One_Element_1493();
        Longest_Subarray_of_1s_After_Deleting_One_Element_1493.Solution solution = r.new Solution();
//        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1}; // Output: 5
//        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1}; // Output: 4
        int[] nums = {0, 0, 0}; // Output: 0
        int result = solution.longestSubarray(nums);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        public int longestSubarray(int[] nums) {
            int start = 0, zeroCount = 0, size = 0;
            for (int end = 0; end < nums.length; end++) {
                zeroCount += 1 - nums[end];

                while (zeroCount > 1) {
                    zeroCount -= 1 - nums[start];
                    start++;
                }
                size = Math.max(size, end - start);

            }
            return size;
        }
    }
}
