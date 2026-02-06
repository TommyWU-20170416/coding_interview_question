package array.easy;

/**
 * 941. https://leetcode.com/problems/valid-mountain-array/description/
 */
public class Valid_Mountain_Array {

    public static void main(String[] args) {

        // Input: nums = [0,1,0,3,12]
        // Output: nums = [1,3,12,0,0]
        int[] nums1 = { 2, 1 };
        boolean result1 = validMountainArray(nums1);
        System.out.println(result1);

        // Input: nums = [0]
        // Output: nums = [0]
        int[] nums2 = { 3, 5, 5 };
        boolean result2 = validMountainArray(nums2);
        System.out.println(result2);

        // Input: nums = [1, 1]
        // Output: nums = [1, 1]
        int[] nums3 = { 0, 3, 2, 1 };
        boolean result3 = validMountainArray(nums3);
        System.out.println(result3);
    }

    // Diff:
    // time complexity: O(n), although two loop, it use index to break out
    // space complexity: O(1), only use index
    public static boolean validMountainArray(int[] arr) {
        // a mountain is from down > up > down
        // down > up
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                index++;
            } else {
                break;
            }
        }
        // check
        if (index == 0 || index == arr.length - 1) {return false;}

        // up > down
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                index++;
            } else {
                break;
            }
        }
        return index == arr.length - 1;
    }

    // Diff:
    // time complexity: O(n), use two pointer to find peak
    // space complexity: O(1), only use two index
    public static boolean validMountainArray1(int[] arr) {

        if (arr.length < 3) {return false;}

        int left = 0;
        while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
            left++;
        }

        if (left == 0 || left == arr.length - 1) {return false;}

        int right = arr.length - 1;
        while (right >= 1 && arr[right - 1] > arr[right]) {
            right--;
        }

        if (right == arr.length - 1) {return false;}
        return left == right;
    }
}
