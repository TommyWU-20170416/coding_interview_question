package array;

/**
 * 238.https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/23 14:54:38
 * @since JDK8.0
 */

import java.util.Arrays;

/**
 * 題目要求是 O(n) time and without using the division operation
 */
public class Product_Of_Array_Except_Self_238 {
    public static void main(String[] args) {
        Product_Of_Array_Except_Self_238 r = new Product_Of_Array_Except_Self_238();
        Product_Of_Array_Except_Self_238.Solution s = r.new Solution();
//        int[] nums = {2, 3, 4, 5}; // [60, 40, 30, 24]
//        int[] nums = {2, 3, 0, 0}; // [0, 0, 0, 0]
        int[] nums = {-1, 0, -3, 3};
        int[] result = s.productExceptSelf(nums);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    class Solution {
        /**
         * origin
         * 這是 O(n^2) 的方式
         */
//        public int[] productExceptSelf(int[] nums) {
//            int[] result = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                int product = 1;
//                for (int j = 0; j < nums.length; j++) {
//                    if (i != j) {
//                        product *= nums[j];
//                    }
//                }
//                result[i] = product;
//            }
//
//            return result;
//        }

        /**
         * test1
         * Runtime: 1 ms, Beats 99.98%
         * 這是 O(n) 的方式
         * -[2, 3, 4, 5]
         * 看成把左邊 product 的值 再 product 右邊 product 的值
         * 以 3 來講就是 左邊的 2 * 右邊的 (4 * 5)
         * 以 5 來講就是 左邊的 (2 * 3 *4) * 右邊的 1(預設)
         * <p>
         * !! 要注意 !!
         * Q: 為什麼 ans[i] = leftProductNum; 這裡是=
         * A: 第一次存取用
         * Q: 為什麼 ans[i] *= rightProductNum; 這裡是*=
         * A: 為了把 leftProductNum 乘起來
         */
        public int[] productExceptSelf(int[] nums) {
            int ans[] = new int[nums.length];
            // 左邊 product 的值
            int leftProductNum = 1;
            for (int i = 0; i < nums.length; i++) {
                ans[i] = leftProductNum;
                leftProductNum *= nums[i];
            }

            // 右邊 product 的值
            int rightProductNum = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                ans[i] *= rightProductNum;
                rightProductNum *= nums[i];
            }
            return ans;
        }
    }

}
