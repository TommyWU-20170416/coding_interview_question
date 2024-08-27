package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217.https://leetcode.com/problems/contains-duplicate/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/12 14:19:01
 * @since JDK8.0
 */
public class Contains_Duplicate_217 {
    public static void main(String[] args) {
        Contains_Duplicate_217 ss = new Contains_Duplicate_217();
        Contains_Duplicate_217.Solution solution = ss.new Solution();
//        int[] nums = {6, 5, 1, 3, 2, 4, 6};
        int[] nums = {7, 10, 5, 5, 6, 6, 4, 10, 5, 4, 9, 4, 9, 6, 5, 9, 6, 3, 6, 5, 6, 7, 7, 4, 9, 9, 10, 5, 8, 1, 8, 3, 2, 7, 5, 10, 1, 8, 5, 8, 4, 3, 6, 4, 9, 4, 2, 8, 3, 2, 2, 1, 5, 6, 3, 2, 6,
                1, 8, 6, 2, 9, 1, 4, 5, 10, 8, 5, 10, 5, 10, 1, 4, 8, 3, 6, 4, 10, 9, 1, 1, 1, 2, 2, 9, 6, 6, 8, 1, 9, 2, 5, 5, 2, 1, 8, 5, 2, 3, 10};
        /**
         * 使用這樣的 nums
         * hashmap 做了 101 步才 return true
         * 第二個雙 for 做第七步就 return
         * 所以說 O(n) 有時候也是會跑輸 O(n^2)
         */
        boolean result = solution.containsDuplicate(nums);

        System.out.print(result);
    }

    class Solution {
        int count = 0;

        /**
         * Runtime: 8 ms, Beats 92.05%
         * 使用 map 預紀錄每一次出現的次數
         */
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                if(!set.add(num)){
                    return true;
                }
            }
            return false;
        }

        /**
         * Runtime: 2 ms, Beats: 99.81% O(n^2)
         * 理論上第二個方法如果是在極端直，也就是第一個跟最後一個重複，就要跑O(n^2)
         *
         * 如果 當前 跟上一個一樣就 return true
         * 如果 當前 比上一個小，有可能在這之前有跟我重複的
         * 所以使用 For 往回找，如果沒有就跟隔壁交換，達到數字越大的往後移動
         * <p>
         * 透過數字最大的往後，可以判斷這個數字大的以前有可能有重複
         */
//        public boolean containsDuplicate(int[] nums) {
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] == nums[i - 1]) {// 如果跟上一個一樣就 return true
//                    return true;
//                } else if (nums[i - 1] > nums[i]) {
//                    // 往前找之前有沒有重複的
//                    for (int j = i - 1; j >= 0; j--) {
//                        if (nums[i] == nums[j]) {
//                            return true;
//                        }
//                    }
//                    // 把大的往後放，接下來比大的還要小就可能存在重複，所以只要交換一個就好不用把小的放到最前面
//                    int temp = nums[i];
//                    nums[i] = nums[i - 1];
//                    nums[i - 1] = temp;
//                }
//            }
//            return false;
//        }
    }
}
