package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. https://leetcode.com/problems/two-sum/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/11 14:54:19
 * @since JDK8.0
 */
public class Two_Sum_1 {
    public static void main(String[] args) {
        Two_Sum_1 ss = new Two_Sum_1();
        Two_Sum_1.Solution solution = ss.new Solution();
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {1, 2, 3, 5, 8};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.print(result);
    }

    class Solution {
        /**
         * Runtime: 45 ms, Beats 29.85%
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) return new int[]{i, j};
                }
            }
            return null;
        }
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 雖然次數跟 test1 跑雙 for 一樣，但是這方法就是容易比較快結束
         * 實驗: TimeComparison
         *
         * 可能的說法是因為他都只加減 nums[j] 跟 nums[j - 1] 以 j 來看就在隔壁，會比起找 nums[i] 還快
         */
//        public int[] twoSum(int[] nums, int target) {
//            /**
//             * i:1, j:1, nums[j] + nums[j-i] = nums[1] + nums[0] = 3
//             * i:1, j:2, nums[j] + nums[j-i] = nums[2] + nums[1] = 5
//             * i:1, j:3, nums[j] + nums[j-i] = nums[3] + nums[2] = 8
//             * i:1, j:4, nums[j] + nums[j-i] = nums[4] + nums[3] = 13
//             * i:2, j:2, nums[j] + nums[j-i] = nums[2] + nums[0] = 4
//             * i:2, j:3, nums[j] + nums[j-i] = nums[3] + nums[1] = 7
//             * i:2, j:4, nums[j] + nums[j-i] = nums[4] + nums[2] = 11
//             * i:3, j:3, nums[j] + nums[j-i] = nums[3] + nums[0] = 6
//             * i:3, j:4, nums[j] + nums[j-i] = nums[4] + nums[1] = 10
//             * i:4, j:4, nums[j] + nums[j-i] = nums[4] + nums[0] = 9
//             */
//            for (int i = 1; i < nums.length; i++) {
//                for (int j = i; j < nums.length; j++) {
//                    int a = nums[j];
//                    int b = nums[j - i];
//                    System.out.println(
//                            "i:" + i + ", j:" + j + ", nums[j] + nums[j-i] = " + "nums[" + j + "] + nums[" + (j - i) + "] = " + (a + b));
//                    if (a + b == target)
//                        return new int[]{j, j - i};
//                }
//            }
//            return null;
//        }

        /**
         * Runtime: 2ms, Beats 97.85%, O(n)
         * 使用 map 把之前減去的值存起來，這樣之後要找就很快
         * map.get 或 containKey 都是 O(1)
         */
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (map.containsKey(nums[i])) {
//                    return new int[]{map.get(nums[i]), i};
//                }
//                map.put(target - nums[i], i);
//            }
//            return null;
//        }
    }
}
