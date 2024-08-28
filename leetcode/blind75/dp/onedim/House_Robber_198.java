package dp.onedim;

/**
 * 198.https://leetcode.com/problems/house-robber/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/27 18:35:10
 * @since JDK8.0
 */
public class House_Robber_198 {
    public static void main(String[] args) {
        House_Robber_198 s = new House_Robber_198();
        House_Robber_198.Solution solution = s.new Solution();
        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 1, 1, 8, 1};
        int result = solution.rob(nums);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解題說明:
         * 這題使用 DP + memo 方式，但要注意並非所有奇數跟偶數都是最大的值
         * 有可能是他是中間跨兩個值才是最大集合，因此要從第 3 個開始算
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[0], nums[1]);
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);
            // 之前都是看隔壁(i-1) & 隔壁隔壁(i-2)
            // 但因為不能連續，所以 i-1 不能用，且有可能 i-3 才會是比較大的數值
            // [2, 1, 1, 2] 這時候 2 + 2 才會是最大的
            // 有需要看 i - 4 嗎，不需要，因為 i - 4 裡面會包含 i - 3
            // [10, 1, 1, 1, 2] 10 + 2 不是最大，中間還可以包含 1 ，所以不用看 i - 4
            for (int i = 3; i < n; i++) {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
            return Math.max(dp[n - 1], dp[n - 2]);
        }
    }
}
