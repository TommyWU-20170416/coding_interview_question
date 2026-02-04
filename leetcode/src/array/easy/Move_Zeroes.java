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
public class Move_Zeroes {

    public static List<String> list = new ArrayList<String>();
    public static Set<String> set = new HashSet<>();
    public static Set<String> sortset = new LinkedHashSet<>();

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

        // Input: nums = [1, 1]
        // Output: nums = [1, 1]
        int[] nums3 = { 0, 1 };
        moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    // Diff:
    // time complexity: O(n) 最差會是所有都是 0，導致 right 遍歷一輪後 left 也會遍歷一輪，總共是 2n -> O(n)
    // space complexity: O(1)
    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
                // 離開起始位置後才會有空間讓他置換成 0
                if (left != 0 && left <= right) {
                    nums[right] = 0;
                }
            }
        }
    }

}
