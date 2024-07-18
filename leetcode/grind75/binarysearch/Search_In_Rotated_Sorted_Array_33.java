package binarysearch;

/**
 * 33.https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 21:27:05
 * @since JDK8.0
 */
public class Search_In_Rotated_Sorted_Array_33 {
    public static void main(String[] args) {
        Search_In_Rotated_Sorted_Array_33 ss = new Search_In_Rotated_Sorted_Array_33();
        Search_In_Rotated_Sorted_Array_33.Solution solution = ss.new Solution();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
//        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] nums = {8, 1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        int result = solution.search(nums, target);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 跟原本的二元搜尋一樣，只是還要多判斷是否左邊右邊有排序
         * 先檢查有排序的那一邊
         * <p>
         * 8, 1, 2, 3, 4, 5, 6, 7  要找 8
         * 第一次 start = 0, mid = 3, end = 7
         * 左邊無序，檢查右邊，右邊不存在，所以代表 8 在 mid 左邊
         * <p>
         * 第二次 start = 0, mid = 1, end = 2
         * 左邊無序，檢查右邊，右邊不存在，所以代表 8 在 mid 左邊
         * <p>
         * 收斂到 0 的位置
         */
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) return mid;

                // 判斷左邊是否有序
                if (nums[start] <= nums[mid]) {
                    if (nums[start] <= target && target <= nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
