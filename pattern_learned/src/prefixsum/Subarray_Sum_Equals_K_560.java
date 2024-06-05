package prefixsum;

import java.util.HashMap;

/**
 * 560.https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/27 14:49:15
 * @since JDK8.0
 */
public class Subarray_Sum_Equals_K_560 {
    public static void main(String[] args) {
        Subarray_Sum_Equals_K_560 s = new Subarray_Sum_Equals_K_560();
        Solution solution = s.new Solution();
        int[] nums = {1};
        int k = 1;

//        int[] nums = {1, 1, 1};
//        int k = 2;

//        int[] nums = {1, -1, 4, -3, -1};
//        int k = 0;
        int result = solution.subarraySum(nums, k);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 暴力解
         * 1. 創建兩層 for，第一層提供第一個數
         * 2. 第二層 for 遍歷並加總後面的數值到 sum = k
         */
//        public int subarraySum(int[] nums, int k) {
//            int count = 0;
//            for (int i = 0; i < nums.length; i++) {
//                int sum = 0;
//                for (int j = i; j < nums.length; j++) {
//                    sum += nums[j];
//                    if (sum == k) {
//                        count++;
//                    }
//                }
//            }
//            return count;
//        }
        public int subarraySum(int[] nums, int k) {
            int currentSum = 0;
            int count = 0;
            // hashmap 儲存 前綴和 and 出現次數
            HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
            // 初始情况下，前缀和為 0 的出現次數為 1 (處理自己就是解的)
            prefixSumMap.put(0, 1);

            for (int num : nums) {
                currentSum += num;

                // 檢查當前和是否有存在於 map 中
                // 因為 map 是存 前綴和出現過的次數，如果相減後在 map 中有找到
                // 表示當前 num 是其中一組解
                // 就以 [1, -1, 4, -3, -1]來看，當推估到 nums[3] = -3 的時候
                // 運算之前 currentSum = 4 | prefixSumMap = [0, 2][1, 1][4, 1]
                // 運算之後 currentSum = 1 | prefixSumMap = [0, 2][1, 1][4, 1]
                // 發現 prefixSumMap 有 1 這個 key，更新 prefixSumMap = [0, 2][1, 2][4, 1]
                // 雖然 prefixSumMap 的 key = 1 是在 第[0]次的時候新增，而現在做到第[3]次，才去看會覺得怪怪
                // ----- 換個方向想 -----
                // 1 + -1 + 4 + -3 = currentSum = nums[0 - 3] = nums [0] + nums[1 - 3]
                // 1               = prefix     = nums[0]
                // 兩者相減若是      = k 就表示這次我們要的區間
                // ----- 用公式來想 -----
                // currentSum - prefix = k
                // 也等於 currentSum - k = prefix
                if (prefixSumMap.containsKey(currentSum - k)) {
                    count += prefixSumMap.get(currentSum - k);
                }

                // 更新前缀和出现的次数
                prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
            }

            return count;
        }
    }
}
