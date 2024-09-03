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
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {1, 2, 1, 3, 5, 6, 7};
        int[] nums = {1, 2};
        int result = solution.findPeakElement(nums);

        System.out.print("result: " + result + "\n");
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 如果 mid - 1 < mid < mid + 1 則要往右邊找，但也不排除可能性在左邊，所以題目才會說邊界是 MIN_VALUES，同理如果都是大於就往左邊找
         * 如果 邊界 < mid(0) < mid + 1 因為邊界是 MIN_VALUE 所以只要看右邊 mid + 1 就好
         * 因為我們是用 mid - 1 < mid < mid + 1 去找，else if
         * 那邊的判斷是從 if nums[mid] > nums[mid + 1] 過濾後的 也就是 nums[mid] < nums[mid + 1]
         * 而因為最右邊的邊界是 MIN_VALUE 不用擔心 if 過濾不到 造成 mid + 1 out of bound
         * <p>
         * 這樣想比較簡單
         * 這題還有其他很多類似的解法但這樣寫比較好記
         */
        public int findPeakElement(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                // Check if mid is a peak
                // 如果 mid = 0       或是  mid - 1 < mid       檢查是否右邊 mid > mid + 1
                // 如果 mid = 最後一位 或是  mid > mid + 1       檢查是否左邊 mid - 1 < mid
                if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
}
