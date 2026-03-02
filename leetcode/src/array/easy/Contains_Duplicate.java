package array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. https://leetcode.com/problems/contains-duplicate/description/
 */
public class Contains_Duplicate {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3, 1 };
        boolean result1 = containsDuplicate(nums1);
        System.out.println("result1: " + result1); // true
        System.out.println(containsDuplicateUseBooleanArray(nums1));

        int[] nums2 = { 1, 2, 3, 4 };
        boolean result2 = containsDuplicate(nums2);
        System.out.println("result2: " + result2); // false
        System.out.println(containsDuplicateUseBooleanArray(nums2));

        int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        boolean result3 = containsDuplicate(nums3);
        System.out.println("result3: " + result3); // true
        System.out.println(containsDuplicateUseBooleanArray(nums3));

        int[] nums4 = { -100, -101, 100, 100 };
        boolean result4 = containsDuplicate(nums3);
        System.out.println("result4: " + result4); // true
        System.out.println(containsDuplicateUseBooleanArray(nums4)); // true
    }

    // Diff:
    // time complexity: O(N)
    // space complexity: O(N)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Diff: use boolean[] to store data would more fast when range is small enough
    // time complexity: O(N)
    // space complexity: O(N)
    public static boolean containsDuplicateUseBooleanArray(int[] nums) {
        // assume that range is -100,000 ~ 100,000
        int offset = 100_000;
        boolean[] set = new boolean[offset * 2 + 1];

        for (int num : nums) {
            int index = num + offset;
            if (set[index]) {
                return true;
            }
            set[index] = true;
        }
        return false;
    }
}
