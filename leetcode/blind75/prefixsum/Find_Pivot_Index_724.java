package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class Find_Pivot_Index_724 {
    public static void main(String[] args) {
        Find_Pivot_Index_724 s = new Find_Pivot_Index_724();
        Find_Pivot_Index_724.Solution solution = s.new Solution();
//        int[] gain = {1, 7, 3, 6, 5, 6}; // return 3
        int[] gain = {2, 1, -1}; // return 0
        int result = solution.pivotIndex(gain);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 右邊 + 回來的跟左邊 + 回來的要一樣
         * 所以先算出右邊 > 左邊總和，且因為題目要求最左解，所以先從右邊 + 回來
         * 再算左邊 > 右邊總和，加完就檢查是不是已經有存在於 map 中
         *
         * int[] sumBackward = new int[nums.length + 1 + 1]; 要加 2 是因為要讓 sumBackward 第一次計算 sumBackward[i + 1] 不會爆掉
         */
//        public int pivotIndex(int[] nums) {
//            Map<Integer, Integer> map = new HashMap<>();
//
//            int[] sumBackward = new int[nums.length + 1 + 1];
//            for (int i = sumBackward.length - 2; i > 0; i--) {
//                sumBackward[i] += sumBackward[i + 1] + nums[i - 1];
//                map.put(i, sumBackward[i]);
//            }
//
//            int[] sumForward = new int[nums.length + 1];
//            for (int i = 1; i < sumForward.length; i++) {
//                sumForward[i] += sumForward[i - 1] + nums[i - 1];
//                if (map.get(i) != null && map.get(i) == sumForward[i]) return i - 1;
//            }
//            return -1;
//        }

        /**
         * test2
         * 解法:
         * 先算一遍總和
         * 再遍歷一次，把總和扣掉
         * 以 [1, 7, 3, 6, 5, 6]來看
         * sum  會計算出      1 + 7 + 3 + 6 + 5 + 6
         * 減去        left  1 + 7 + 3
         * ------------------------------------------
         * 會得到                         6 + 5 +6
         * 也就得到 第一個 6 的位置就是 index 3
         * =====================
         * 有點像是 prefix sum 的進階應用
         * 單一方向看過去回得到 sum
         * 但如果把 sum 減去
         * 會得到 從右往左的 sum
         * 1 , 7, 3, 6, 5, 6
         * 1 , 8,11,17,22,28 => 左邊加過去
         * 28,27,20,17,11, 6 => 右邊加過去 = 左邊加過去(28) 減去 每個當下
         */
        public int pivotIndex(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                left += nums[i];
                if (left == sum) {
                    return i;
                }
                sum -= nums[i];
            }
            return -1;
        }
    }
}
