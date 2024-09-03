package binarysearch;

import java.util.Arrays;

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
//        int h = 11;
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6; // Expected: 30
//        int[] piles = {805306368, 805306368, 805306368}; // 如果今天 koko 一小時吃一根就會是 805306368 * 3 超過 2^32(2147483647)，所以要把 int 改成 Long
//        int h = 1000000000;
        int result = solution.minEatingSpeed(piles, h);
        System.out.print(result);
    }


    /**
     * Runtime: 12 ms, Beats 83.64%
     * test1
     * 解法:
     * 使用 binary search
     * 猴子吃香蕉，最高可以吃 max 根，也就是 piles 的最大，最少就是 1 根
     * 根據這個範圍去計算吃完全部要多少時間 h
     * 如果 h < H 代表吃太快、如果 h > H 代表吃太慢
     * 最後要找 h <= H
     * <p>
     * 這題跟其他的 binary search 最不一樣的是 使用 recursive 去找，之前都是 while
     */
//    class Solution {
//        private int count = 0;
//
//        public int minEatingSpeed(int[] piles, int h) {
//            if (piles == null || piles.length == 0) return 0;
//            int max_banana_number = getMax(piles);
//            int a = minEatingSpeed(piles, h, 1, max_banana_number);
//            System.out.println("count:" + count);
//            return a;
//        }
//
//        private int minEatingSpeed(int[] piles, int H, int k_low, int k_high) {
//            if (k_low > k_high) return -1;
//            int k_result = -1;
//            int k_mid = (k_low + k_high) / 2;
//            long h = calculateHour(piles, k_mid);
//
//            count++;
//            if (h <= H) {
//                k_result = k_mid;
//                int k_left = minEatingSpeed(piles, H, k_low, k_mid - 1);
//                if (k_left != -1) {
//                    k_result = k_left;
//                }
//            } else if (h > H) {
//                k_result = minEatingSpeed(piles, H, k_mid + 1, k_high);
//            }
//
//            return k_result;
//        }
//
//        private long calculateHour(int[] piles, int k_mid) {
//            long h = 0;
//            for (int pile : piles) {
//                count++;
//                if (pile % k_mid == 0) {
//                    h += pile / k_mid;
//                } else {
//                    h += pile / k_mid + 1;
//                }
//            }
//            return h;
//        }
//
//        private int getMax(int[] piles) {
//            int max = 0;
//            for (int pile : piles) {
//                count++;
//                max = Math.max(max, pile);
//            }
//            return max;
//        }
//
//    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * !! 這題重要的是邊界處理
     * 正常 start 大家都會想成是 1, end 是 piles 裡面最大的
     * 但這樣就會放大了範圍
     * 這個作者他把 piles 算總和 然後再去跟 h 計算 start, end
     * 如果加總就會失去分攤這件事情，例如 [2, 3, 11] 如果 h 是 4, 也要 4 小時，代表 start 一定超過 4，因為 2 跟 3 下去除 4 都有餘數，這些餘樹沒有其他可以共用
     * end 是把 h - n + 1，h - n 意思是把分攤加回來 + 1是確保不會變成 0
     * 暫時目前的理解是這樣
     * 這樣的算法對 h 很大 很有力，因為更容易收斂
     * 但如果 h = piles.length 這樣找 end 就會是 sum / 1
     */
    class Solution {
        private int count = 0;

        public int minEatingSpeed(int[] piles, int h) {
            int n = piles.length;
            long sum = 0;
            for (int p : piles) {
                count++;
                sum += p;
            }
            int start = (int) ceilDiv(sum, h); // 在共用的情況下，使用 h 計算最少要吃的根數，h 是最大的值
            int end = (int) ceilDiv(sum, h - n + 1); // 在 h 的時間內，有 n 推香蕉，所以至少是 n 根起跳，+1 是確保不會變成 0
            int mid = 1;
            while (start <= end) {
                count++;
                mid = (start + end) / 2;
                int time = 0;
                for (int i = 0; i < n; i++) {
                    count++;
                    time += (piles[i] + mid - 1) / mid;
                    if (time > h) break; // 這段是去看目前時間是否超過上限 h ，如果超過就跳出不用繼續往下算
                }
                if (time > h) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println("count:" + count);
            return start;
        }

        private long ceilDiv(long x, long y) {
            return (x + y - 1) / y;
        }
    }
}
