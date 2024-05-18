package twopointer;

/**
 * 713.https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月8日 下午7:13:04
 * @since JDK8.0
 * <p>
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product
 * of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not
 * strictly less than k.
 * <p>
 * Input : [1, 2, 3], 0
 * Output:
 */
public class Subarray_Product_Less_Than_K {
    private static int[] nums = {10, 5, 2, 6};
    private static int k = 100;

    public static void main(String[] args) {
        Subarray_Product_Less_Than_K test = new Subarray_Product_Less_Than_K();
        test.twoPoint(nums, k);
    }

    /**
     * 時間複雜度O(n)，暴力解的話要O(n*n*n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int twoPoint(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int product = 1, left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
            /* 多的1是本身的，right-left是兩者中間 */
            System.out.println("count:" + count);
        }

        return count;
    }
}
