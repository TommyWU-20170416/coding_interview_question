package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 26. https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Remove_Duplicates_From_Sorted_Array_Best {

    public static void main(String[] args) {

        // Input: nums = [1,1,2]
        // Output: 2, nums = [1,2,_]
        int[] nums1 = { 1, 1, 2 };
        int k1 = removeDuplicates(nums1);
        System.out.println(Arrays.toString(nums1) + " k1 = " + k1);
        // Input: nums = [0,0,1,1,1,2,2,3,3,4]
        // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k2 = removeDuplicates(nums2);
        System.out.println(Arrays.toString(nums2) + " k2 = " + k2);
    }

    // Diff: time space would be better from O(n) -> O(1)
    // time complexity: O(n)
    // space complexity: O(1)
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
            if (k != i) {
                nums[i] = 0; // to set the duplicate positions to 0
            }
            System.out.println("i: " + i + ", k = " + k + ", " + Arrays.toString(nums));
        }

        return k + 1;
    }
}
