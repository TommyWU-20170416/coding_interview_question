package binarysearch;

/**
 * 704.https://leetcode.com/problems/binary-search/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 17:25:43
 * @since JDK8.0
 */
public class Binary_Search_704 {
    public static void main(String[] args) {
        Binary_Search_704 ss = new Binary_Search_704();
        Binary_Search_704.Solution solution = ss.new Solution();
//        int[] nums = {-1, 0, 3, 5, 9, 12};
//        int target = 9;
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int result = solution.search(nums, target);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 使用遞迴，主要是在 mid 這樣計算可以避免數值過大
         * mid 因為比較過，所以要做 + 1 或 - 1
         */
//        public int search(int[] nums, int target) {
//            return search(nums, target, 0, nums.length - 1);
//        }
//
//        private int search(int[] nums, int target, int start, int end) {
//            if (start > end) return -1;
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) return mid;
//            else if (nums[mid] < target) {
//                return search(nums, target, mid + 1, end);
//            } else {
//                return search(nums, target, start, mid - 1);
//            }
//        }

        /**
         * Runtime: 0 ms, Beats 100.00%
         * 這樣寫 Space Complexity 會好一點
         * 我覺得也比較簡短
         */
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid;
            while (start <= end) {
                mid = (end - start) / 2 + start;
                if (target < nums[mid])
                    end = mid - 1;
                else if (target > nums[mid])
                    start = mid + 1;
                else
                    return mid;
            }
            return -1;
        }
    }
}
