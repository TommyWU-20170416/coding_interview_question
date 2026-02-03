package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Remove_Duplicates_From_Sorted_Array {

    public static List<String> list = new ArrayList<String>();
    public static Set<String> set = new HashSet<>();
    public static Set<String> sortset = new LinkedHashSet<>();

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

    // time complexity: O(n)
    // space complexity: O(k)
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        Set set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[k] = nums[i];
                k++;
            } else {
                nums[i] = 0;
            }
//            System.out.println("i: " + i + ", " + Arrays.toString(nums) + " k = " + k);
        }
        return k;
    }
}
