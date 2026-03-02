package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349. https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class Intersection_Of_Two_Arrays_Best {

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

    // Diff: range ≈ n, suggest to use boolean[]
    // time complexity: O(m+n+k) to find each element in nums1(m) and nums2(n), transform list to array
    // space complexity: O(m or n) it depend on nums1 how big
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] flag = new boolean[1001];
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            flag[num] = true;
        }

        for (int num : nums2) {
            if (flag[num]) {
                result.add(num);
                flag[num] = false; // to remove added num
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}