package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Max_Number_Of_K_Sum_Pairs_1679 {
    public static void main(String[] args) {
        Max_Number_Of_K_Sum_Pairs_1679 r = new Max_Number_Of_K_Sum_Pairs_1679();
        Max_Number_Of_K_Sum_Pairs_1679.Solution solution = r.new Solution();

//        int[] nums = {1, 2, 3, 4};
//        int k = 5;
        int[] nums = {5, 5, 1, 3, 1, 3, 2};
        int k = 4;
//        int[] nums = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
//        int k = 2;
        int result = solution.maxOperations(nums, k);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * Runtime: 12 ms, Beats 99.70% O(n log n)
         * test1
         * 這題如果用 map 紀錄，會算比較慢
         * 解法:
         * 1. 條件 nums[i] >= 1 ，不會有負號，所以先找出 > k 的，把 > k 的都去掉
         * 2. 排序前幾筆
         * 3. 根據前幾筆，從頭跟尾 往中間找，若加總太大，就是右邊太大往左，若加總太小，就是左邊太小往右
         */
        public int maxOperations(int[] nums, int k) {
            int count = 0, indexLessThanK = 0;
            for (int num : nums) {
                if (num < k) nums[indexLessThanK++] = num;
            }
            Arrays.sort(nums, 0, indexLessThanK);

            for (int left = 0, right = indexLessThanK - 1; left < right; ) {
                if (nums[left] + nums[right] < k) {
                    left++;
                } else if (nums[left] + nums[right] > k) {
                    right--;
                } else {
                    count++;
                    left++;
                    right--;
                }
            }
            return count;
        }
    }
}
