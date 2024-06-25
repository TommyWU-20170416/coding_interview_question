package binarysearch;

/**
 * 875.https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/29 15:16:57
 * @since JDK8.0
 */
public class Koko_Eating_Bananas_875 {
    public static void main(String[] args) {
        Koko_Eating_Bananas_875 s = new Koko_Eating_Bananas_875();
        Koko_Eating_Bananas_875.Solution solution = s.new Solution();
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
        int[] piles = {805306368, 805306368, 805306368}; // 如果今天 koko 一小時吃一根就會是 805306368 * 3 超過 2^32(2147483647)，所以要把 int 改成 Long
        int h = 1000000000;
        int result = solution.minEatingSpeed(piles, h);
        System.out.print(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 binary search
         * 猴子吃香蕉，最高可以吃 max 根，也就是 piles 的最大，最少就是 1 根
         * 根據這個範圍去計算吃完全部要多少時間 h
         * 如果 h < H 代表吃太快、如果 h > H 代表吃太慢
         * 最後要找 h <= H
         *
         * 這題跟其他的 binary search 最不一樣的是 使用 recursive 去找，之前都是 while
         */
        public int minEatingSpeed(int[] piles, int h) {
            if (piles == null || piles.length == 0) return 0;
            int max_banana_number = getMax(piles);
            return minEatingSpeed(piles, h, 1, max_banana_number);
        }

        private int minEatingSpeed(int[] piles, int H, int k_low, int k_high) {
            if (k_low > k_high) return -1;
            int k_result = -1;
            int k_mid = (k_low + k_high) / 2;
            long h = calculateHour(piles, k_mid);

            if (h <= H) {
                k_result = k_mid;
                int k_left = minEatingSpeed(piles, H, k_low, k_mid - 1);
                if (k_left != -1) {
                    k_result = k_left;
                }
            } else if (h > H) {
                k_result = minEatingSpeed(piles, H, k_mid + 1, k_high);
            }

            return k_result;
        }

        private long calculateHour(int[] piles, int k_mid) {
            long h = 0;
            for (int pile : piles) {
                if (pile % k_mid == 0) {
                    h += pile / k_mid;
                } else {
                    h += pile / k_mid + 1;
                }
            }
            return h;
        }

        private int getMax(int[] piles) {
            int max = 0;
            for (int pile : piles) {
                max = Math.max(max, pile);
            }
            return max;
        }
    }
}
