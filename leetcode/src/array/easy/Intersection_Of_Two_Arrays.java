package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class Intersection_Of_Two_Arrays {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        int[] result1 = intersection(nums1, nums2);
        System.out.println("result1: " + Arrays.toString(result1)); // Output: [2]

        int[] nums3 = { 4, 9, 5 }, nums4 = { 9, 4, 9, 8, 4 };
        int[] result2 = intersection(nums3, nums4);
        System.out.println("result2: " + Arrays.toString(result2)); // Output: [9,4]

        int[] nums5 = { 1000, 0, 2, 1000 }, nums6 = { 1000, 1000, 0 };
        int[] result3 = intersection(nums5, nums6);
        System.out.println("result2: " + Arrays.toString(result3)); // Output: [9,4]
    }

    // Diff: Use Set to store unique nums
    // time complexity: O(m+n) to find each element in nums1(m) and nums2(n)
    // space complexity: O(m or n) it depend on nums1 how big
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        // get unique nums1
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}