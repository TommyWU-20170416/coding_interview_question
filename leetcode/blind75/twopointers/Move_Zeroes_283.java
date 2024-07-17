package twopointers;

import array.String_Compression_443;

/**
 * 283.https://leetcode.com/problems/move-zeroes/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/24 15:16:06
 * @since JDK8.0
 */
public class Move_Zeroes_283 {
    public static void main(String[] args) {
        Move_Zeroes_283 r = new Move_Zeroes_283();
        Move_Zeroes_283.Solution s = r.new Solution();
//        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {1, 0};
//        int[] nums = {1, 1, 2};
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        s.moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    class Solution {
        /**
         * Runtime: 30 ms, Beats 10.60%。O(n) 雖然是雙層，可是裡面的 while 條件跟外面都是一樣的，所以不會是 O(n * n)
         * test1
         * 解法:
         * 想像上就是兩個 index，左邊找 0 右邊找非0，然後去做交換
         * 且左邊不可以超過右邊
         */
//        public void moveZeroes(int[] nums) {
//            if (nums.length < 2) return;
//            int left = 0;
//            int right = 1;
//            while (left < nums.length && right < nums.length) {
//                while (left < nums.length && nums[left] != 0) {
//                    left++;
//                }
//                right = left + 1;
//                while (right < nums.length && nums[right] == 0) {
//                    right++;
//                }
//                if (left >= nums.length || right >= nums.length) break;
//                swap(nums, left, right);
//                left++;
//                right++;
//            }
//        }
//
//        private void swap(int[] nums, int left, int right) {
//            int tmp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = tmp;
//        }

        /**
         * Runtime: 1 ms, Beats 100.00%
         * test2
         * 解法:
         * 把非 0 的先更新到前面，後面在依序補 0
         */
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[index++] = num;
                }
            }
            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }
}