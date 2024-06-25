package binarysearch;

/**
 * 162.https://leetcode.com/problems/find-peak-element/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/20 18:54:04
 * @since JDK8.0
 */
public class Find_Peak_Element_162 {
    public static void main(String[] args) {
        Find_Peak_Element_162 s = new Find_Peak_Element_162();
        Find_Peak_Element_162.Solution solution = s.new Solution();

        // test for mid out of bound
//        int[] nums = {1, 2};
        int[] nums = {1, 2, 1, 3, 5, 6, 7};
        int result = solution.findPeakElement(nums);

        System.out.print("result: " + result + "\n");
    }

    class Solution {
        public int findPeakElement(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                // Check if mid is a peak
                // mid == 0 去檢查是否在邊界，是的話後面的 nums[mid] >= nums[mid - 1] 不用算
                if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                    return mid;
                }

                // If nums[mid] is less than nums[mid - 1], peak must be on the left
                // mid may over the array
                if (mid > 0 && nums[mid] < nums[mid - 1]) {
                    end = mid - 1;
                } else { // Otherwise, peak must be on the right
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
}
