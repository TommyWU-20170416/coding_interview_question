package tree;

/**
 * 34.https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/29 14:34:08
 * @since JDK8.0
 */
public class Find_First_And_Last_Position_Of_Element_In_Sorted_Array_34 {
    public static void main(String[] args) {
        Find_First_And_Last_Position_Of_Element_In_Sorted_Array_34 s = new Find_First_And_Last_Position_Of_Element_In_Sorted_Array_34();
        Find_First_And_Last_Position_Of_Element_In_Sorted_Array_34.Solution solution = s.new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        for (int i : result) {
            System.out.print(i);
        }
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) return new int[]{-1, -1};
            return searchRange(nums, target, 0, nums.length - 1);
        }

        private int[] searchRange(int[] nums, int target, int i_start, int i_end) {
            if (i_start > i_end) return new int[]{-1, -1};

            int i_mid = (i_start + i_end) / 2;
            int[] result = new int[]{-1, -1};
            if (target == nums[i_mid]) {
                // if find the target, continue to find the left and right
                result[0] = result[1] = i_mid;

                // left
                int[] search_left = searchRange(nums, target, i_start, i_mid - 1);
                if(search_left[0] != -1){
                    result[0] = search_left[0];
                }

                // rigjt
                int[] search_right = searchRange(nums, target, i_mid + 1, i_end);
                if(search_right[1] != -1){
                    result[1] = search_right[1];
                }

            } else if (target < nums[i_mid]) {
                result = searchRange(nums, target, i_start, i_mid - 1);
            } else if (target > nums[i_mid]) {
                result = searchRange(nums, target, i_mid + 1, i_end);
            }
            return result;
        }
    }
}
