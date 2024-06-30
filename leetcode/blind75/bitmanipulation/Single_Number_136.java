package bitmanipulation;

/**
 * 136.https://leetcode.com/problems/single-number/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/30 23:47:13
 * @since JDK8.0
 */
public class Single_Number_136 {
    public static void main(String[] args) {
        Single_Number_136 s = new Single_Number_136();
        Single_Number_136.Solution solution = s.new Solution();
//        int[] nums = {4, 1, 2, 1, 2};
        int[] nums = {4, 1, 2, 1, 4};
        int result = solution.singleNumber(nums);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 相同的值在經過 XOR 會變成 0
         * 起初想到用 map，但因為題目要求用 constant extra space
         */
        public int singleNumber(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result ^= nums[i];
            }
            return result;
        }
    }
}
