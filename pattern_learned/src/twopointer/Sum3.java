package twopointer;

import java.util.*;

/**
 * 15.https://leetcode.com/problems/3sum/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月8日 下午4:00:57
 * @since JDK8.0
 * <p>
 * Given an integer array nums, return all the triplets [nums[i],
 * nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] +
 * nums[j] + nums[k] == 0.
 * <ul>
 *     <li>Input : nums = [-1,0,1,2,-1,-4] <br> Output: [[-1,-1,2],[-1,0,1]]</li>
 *     <li>Input : nums = [-2,0,0,2,2] <br> Output: [[-2,0,2]]</li>
 *     <li>Input : nums = [-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0] <br> Output: [[-5,1,4],[-3,-1,4],[-3,0,3],[-2,-1,3],[-2,1,1],[-1,0,1],[0,0,0]]</li>
 * </ul>
 * <p>
 * 這題不能用暴力解，一定會 TLE
 */
public class Sum3 {
    public static void main(String[] args) {
        Sum3 ss = new Sum3();
        Sum3.Solution solution = ss.new Solution();
//        int[] nums = {-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0};
//        int[] nums = {0, 1, 1};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.print(result);
    }

    /**
     * Runtime: 440 ms, Beats 25.64%
     * 排序後跑 for 先找出第一個數，也就是未來 two sum 的 target
     * 為避免有重複值出現，判斷 nums[i] == nums[i - 1]
     *
     * two sum 為避免重複，判斷 mid 是否重複
     * 使用 two sum 找答案
     */
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            Arrays.sort(nums);
//            List<List<Integer>> result = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (i > 0 && nums[i] == nums[i - 1]) continue;
//                twoSum(i + 1, nums, -nums[i], result);
//            }
//            return result;
//        }
//
//        private void twoSum(int index, int[] nums, int target, List<List<Integer>> result) {
//            int mid = Integer.MIN_VALUE;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = index; i < nums.length; i++) {
//                if (map.containsKey(nums[i]) && mid != target - nums[i]) {
//                    mid = target - nums[i];
//                    List<Integer> list = new ArrayList<>();
//                    list.add(-target);
//                    list.add(target - nums[i]);
//                    list.add(nums[i]);
//                    result.add(list);
//                }
//                map.put(target - nums[i], nums[i]);
//            }
//        }
//    }

    /**
     * Runtime: 22 ms, Beats 99.38%
     * 因為排序後可以使用 two pointer 去做
     */
    class Solution {
        private int count = 0;

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                twoSum(-nums[i], nums, i + 1, list);
            }
            System.out.println("count:" + count);
            return list;
        }

        private void twoSum(int target, int[] nums, int startIndex, List<List<Integer>> list) {
            int left = startIndex;
            int right = nums.length - 1;

            while (left < right) {
                count++;
                if (nums[left] + nums[right] < target) left++;
                else if (nums[left] + nums[right] > target) right--;
                else {
                    list.add(Arrays.asList(-target, nums[left], nums[right]));
                    left++;
                    right--;
//                    while (left < right && nums[left] == nums[left - 1]) left++; // 避免重複組合
//                    while (left < right && nums[right] == nums[right + 1]) right--; // 避免重複組合
                }
                // 這樣寫也可避免重複組合，選擇 right 是因為
                // EX:[-1, -1, 0, 1, 2, 3]
                // ---[ 0,  1, 2, 3, 4, 5]
                // 若當前 target = 1 要尋找 mid right 的值
                // 一進來 left = 1, right = 5
                // 若此時就判斷 nums[left] == nums[left + 1] 或是判斷 nums[left] == nums[left - 1]
                // 都會讓答案少一組，因為被跳過了，所以選擇 right 跳過比較適合
                while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1]) right--;
            }
        }
    }
}