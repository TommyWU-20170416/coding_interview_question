package array.easy;

import java.util.Arrays;

/**
 * 88. https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Merge_Sorted_Array_Best {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m1 = 3, n2 = 3;
        merge(nums1, m1, nums2, n2); // Output: [1, 2, 2, 3, 5, 6]

        int[] nums3 = { 1 };
        int[] nums4 = {};
        int m3 = 1;
        int n4 = 0;
        merge(nums3, m3, nums4, n4); // Output: [1]

        int[] nums5 = { 0 };
        int[] nums6 = { 1 };
        int m5 = 0;
        int n6 = 1;
        merge(nums5, m5, nums6, n6); // Output: [1]

    }

    // Diff: put value from tail, it can prevent from swap issue
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }

        // if n = 0, it will return nums1 directly
        // if m = 0, it need to handle
        while(index2 >=0){
            nums1[index--] = nums2[index2--];
        }

        System.out.println(Arrays.toString(nums1));
    }
}
