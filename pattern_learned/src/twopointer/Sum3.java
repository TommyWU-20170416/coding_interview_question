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
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.print(result);
    }

    /**
     * Runtime: 22 ms, Beats 99.38%
     * 排序後可以使用 two pointer 去做
     */
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && nums[i - 1] == nums[i]) continue; // 避免 i = 0
                twoSum(-nums[i], nums, i + 1);
            }
            return result;
        }

        public void twoSum(int target, int[] nums, int startIndex) {
            int right = nums.length - 1;

            for (int left = startIndex; left < right; ) {
                int numLeft = nums[left], numRight = nums[right];
                if (numLeft + numRight < target) left++;
                else if (numLeft + numRight > target) right--;
                else {
                    result.add(Arrays.asList(-target, nums[left++], nums[right--]));
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
    }
}