package array;

public class Increasing_Triplet_Subsequence_334 {
    public static void main(String[] args) {
        Increasing_Triplet_Subsequence_334 r = new Increasing_Triplet_Subsequence_334();
        Increasing_Triplet_Subsequence_334.Solution s = r.new Solution();
//        int[] nums = {1, 2, 3, 4, 5}; // true
        int[] nums = {2, 1, 5, 0, 4, 6}; // true
//        int[] nums = {20,100,10,12,5,13}; // true
        boolean result = s.increasingTriplet(nums);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * test1
         * 解說:
         * i < j < k 且 nums[i] &lt; nums[j] &lt; nums[k] &lt;
         * 建立一個 a 跟 b 是 整數最大，接著把 nums[i], nums[j] 往下取最小
         * !! 重要 !!
         * 第一次看到會覺得 nums[i] 跟 nums[j] 沒有比較怎麼知道順序
         * 但精華就在每一次都跟 nums[i] 先比，沒有才再往後
         */
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) return false;
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= a) {
                    a = num;
                } else if (num <= b) {
                    b = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
