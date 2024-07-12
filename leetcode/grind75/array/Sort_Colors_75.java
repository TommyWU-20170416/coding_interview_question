package array;

/**
 * 75.https://leetcode.com/problems/sort-colors/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/12 13:52:14
 * @since JDK8.0
 * <p>
 * 題目要求使用 in-place 也就是空間複雜度 O(1)
 */
public class Sort_Colors_75 {
    public static void main(String[] args) {
        Sort_Colors_75 ss = new Sort_Colors_75();
        Sort_Colors_75.Solution solution = ss.new Solution();
        int[] nums = {2, 1, 2, 1, 1, 0};
        solution.sortColors(nums);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00% O(n)
         * 考慮到只有三種元素，因此直接去計算三種出現次數
         * 再一一放回到原 nums
         * <p>
         * 缺點就是若今天元素很多就要用別的方式
         */
//        public void sortColors(int[] nums) {
//            int redC = 0;
//            int whiteC = 0;
//            int blueC = 0;
//            for (int num : nums) {
//                if (num == 0)
//                    redC++;
//                else if (num == 1)
//                    whiteC++;
//                else
//                    blueC++;
//            }
//
//            for (int i = 0; i < nums.length; i++) {
//                if (redC > 0) {
//                    nums[i] = 0;
//                    redC--;
//                } else if (whiteC > 0) {
//                    nums[i] = 1;
//                    whiteC--;
//                } else {
//                    nums[i] = 2;
//                    blueC--;
//                }
//            }
//        }

        /**
         * Runtime: 0 ms, Beats 100.00% O(n)
         * 使用陣列計算出現次數
         * 雖然有兩層 for 但實際上第一層 for 是 3 個，第二層 for 是個別的次數
         */
//        public void sortColors(int[] nums) {
//            // 計數每個數字出現的次數
//            int[] count = new int[3];
//            for (int num : nums) {
//                count[num]++;
//            }
//
//            // 根據計數重建數組
//            int index = 0;
//            for (int i = 0; i < count.length; i++) {
//                for (int j = 0; j < count[i]; j++) {
//                    nums[index++] = i;
//                }
//            }
//        }


        /**
         * 使用三個指標
         * low, mid, high
         * 初始化位置 low(0), mid(0), high(最後)
         * 當 mid == 0 將 nums[low] 和 nums[mid] 交換，並遞增 low 和 mid
         * 當 mid == 1 已經在正確位置，僅遞增 mid
         * 當 mid == 2 將 nums[mid] 和 nums[high] 交換，並遞減 high
         */
        public void sortColors(int[] nums) {
            int low = 0, mid = 0, high = nums.length - 1;

            while (mid <= high) {
                switch (nums[mid]) {
                    case 0:
                        swap(nums, low++, mid++);
                        break;
                    case 1:
                        mid++;
                        break;
                    case 2:
                        swap(nums, mid, high--);
                        break;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}
