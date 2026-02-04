package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 283. https://leetcode.com/problems/move-zeroes/description/
 */
public class Move_Zeroes_Best {

    public static void main(String[] args) {

        // Input: nums = [0,1,0,3,12]
        // Output: nums = [1,3,12,0,0]
        int[] nums1 = { 0, 1, 0, 3, 12 };
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        // Input: nums = [0]
        // Output: nums = [0]
        int[] nums2 = { 0 };
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        // Input: nums = [0, 1]
        // Output: nums = [1, 0]
        int[] nums3 = { 0, 1 };
        moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    // Diff:
    // time complexity: O(n)
    // space complexity: O(1)
    // pros: 每個非零元素只寫入一次，然後再補零
    // cons: 需要兩個迴圈
    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[left++] = n;
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }

    // time complexity: O(n)
    // space complexity: O(1)
    // pros: 只需要一個迴圈就可以完成
    // cons: 是每一次叫喚都是寫入三次
    public static void moveZeroesSwap(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
