package binarysearch;

import java.util.Arrays;

/**
 * 2300.https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/20 17:21:13
 * @since JDK8.0
 */
public class Successful_Pairs_Of_Spells_And_Potions_2300 {
    public static void main(String[] args) {
        Successful_Pairs_Of_Spells_And_Potions_2300 s = new Successful_Pairs_Of_Spells_And_Potions_2300();
        Successful_Pairs_Of_Spells_And_Potions_2300.Solution solution = s.new Solution();

        int[] spells = {5, 1, 3}, potions = {1, 2, 2, 4, 5};
        int success = 10;
        int[] result = solution.successfulPairs(spells, potions, success);

        System.out.print("result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    class Solution {
        /**
         * test1
         * 解法:
         * 先把藥水做排序，這樣之後就可以挑選裡面最小的，然後再用 長度減去就可以知道該 spell 適用的組合
         * <p>
         * 排序使用到 O(n log n)
         * 雙指針(binary search)使用到 O(m log n)
         */
//        public int[] successfulPairs(int[] spells, int[] potions, long success) {
//            int[] result = new int[spells.length];
//            // sort the potions
//            Arrays.sort(potions);
//
//            for (int i = 0; i < spells.length; i++) {
//                int left = 0;
//                int right = potions.length - 1;
//                // binary search to find the first potion can product spell >= success
//                while (left <= right) {
//                    int mid = left + (right - left) / 2;
//                    int potion_mid = potions[mid];
//
//                    // if product == success, because we have to find the smallest value, so we move left
//                    if ((long) potion_mid * spells[i] >= success) {
//                        right = mid - 1;
//                    } else if ((long) potion_mid * spells[i] < success) {
//                        left = mid + 1;
//                    }
//                }
//                result[i] = potions.length - left;
//            }
//            return result;
//        }

        /**
         * test2
         * 解法: 沒有用到 binary search，轉而使用 array 特性去紀錄位置跟數量
         * 1. 先去找最大的 potion
         * 2. 使用 array[] 計算每一個 potion 所擁有的瓶數 (因為有可能重複)
         * 3. 因為 array 就已經排序好，所以去找到每一個 potoin 後面有多少瓶，這樣當找到一瓶後的位置後，就可以知道它後面的總和(因為第一瓶可以的話，後面就通通可以，因為已經排序過大小)
         * 4. 使用 potion_max 去推出 spell_min
         * 5. 使用 for 去找到 spell[i] >= spell_min
         * 6. 如果有至少等於 spell_min 去找他至少符合那個 potion，找到後再去 array[i] 回傳答案
         * <p>
         * 時間複雜度: O(m+n), m = spells.length, n = potions.length
         * 空間複雜度: O(m)
         */
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int slen = spells.length;
            int plen = potions.length;

            // find the max potions
            int maxp = potions[0];
            for (int i = 1; i < plen; i++) {
                if (maxp < potions[i]) {
                    maxp = potions[i];
                }
            }

            // Count the number of times poison appears
            // potions: [1, 2, 2, 4, 5]
            // pcouners:[0, 1, 2, 0, 1, 1]
            // pcouners 會多建立一個
            int[] pcouners = new int[maxp + 1];
            for (int i = 0; i < plen; i++) {
                pcouners[potions[i]]++;
            }
            // Accumulate array forward
            // pcouners:[0, 1, 2, 0, 1, 1]
            // pcouners:[0, 5, 4, 2, 2, 1]
            for (int i = maxp - 1; i > 0; i--) {
                pcouners[i] += pcouners[i + 1];
            }
            // 求 最小 spell，如果連最小都沒有滿足，等於整個 potions 都不用看
            long mins = (success + maxp - 1) / maxp;

            // 當 spell >= minspell, 尋找 potions 有多少個符合
            // 使用 ptarget 去找最小的 potions
            // 之前已經知道說 每個 potions 後面有多少個 ex: pcouners[1] = 5 = 1 + 2 + 1 + 1個
            // 所以算出最低的 ptarget 後再去 pcouners 裡面找，最後放進 spells，他還省略掉創建 result 的空間
            for (int i = 0; i < slen; i++) {
                int spell = spells[i];
                int res = 0;

                if (spell >= mins) {
                    long ptarget = (success + spell - 1) / spell;
                    res = pcouners[(int) ptarget];
                }
                spells[i] = res;
            }

            return spells;
        }
    }
}
