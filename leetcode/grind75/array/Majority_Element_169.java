package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.https://leetcode.com/problems/majority-element/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/12 13:05:58
 * @since JDK8.0
 */
public class Majority_Element_169 {
    public static void main(String[] args) {
        Majority_Element_169 ss = new Majority_Element_169();
        Majority_Element_169.Solution solution = ss.new Solution();
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {3, 3, 3, 2, 2, 2, 2, 2, 2, 3, 3};
        int[] nums = {5, 1, 5, 2, 5, 3, 4, 5};
        int result = solution.majorityElement(nums);
        System.out.print(result);
    }

    class Solution {
        /**
         * Runtime: 15 ms, Beats 22.36%
         * 使用 hashmap 紀錄數字出現過的次數
         * 在使用 for 去找出 >= nums.length/2 的
         */
//        public int majorityElement(int[] nums) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                if (map.containsKey(num)) {
//                    map.put(num, map.get(num) + 1);
//                } else {
//                    map.put(num, 1);
//                }
//            }
//            int pos = (int)Math.ceil((double)nums.length / 2);
//            for (Map.Entry entry : map.entrySet()) {
//                if ((int)entry.getValue() > (pos)) {
//                    return (int) entry.getKey();
//                }
//            }
//            return -1;
//        }

        /**
         * Boyer–Moore majority vote algorithm 多數投票演算法—來自毛怪發佈於毛怪的沙龍https://vocus.cc/article/652ca296fd897800019bfe1f
         * Runtime: 2 ms, Beats 74.84%
         * 找出次數超過一半的元素
         * 僅適用於單一元素，若同時有多元素則無法
         */
        public int majorityElement(int[] nums) {
            int count = 0;
            int major = nums[0];
            for (int num : nums) {
                if (count == 0) major = num;
                count += major == num ? 1 : -1;
            }
            return major;
        }
    }
}
