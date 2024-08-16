package array;

/**
 * 605.https://leetcode.com/problems/can-place-flowers/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/21 17:37:49
 * @since JDK8.0
 */

/**
 * 計算 flowerbed 內有幾個洞可以種東西
 * 可以種的條件是左右兩邊沒有 花(1)
 * 不會有 花 跟 花 連續種
 * <p>
 * 連續 3 個 0 就可以種一個
 */
public class Can_Place_Flowers_605 {
    public static void main(String[] args) {
        Can_Place_Flowers_605 ss = new Can_Place_Flowers_605();
        Can_Place_Flowers_605.Solution s = ss.new Solution();
        int[] flowerbed = {1, 0, 0, 0, 0};
//        int[] flowerbed = {0, 1, 0, 0, 1};
        int n = 1;
        boolean b = s.canPlaceFlowers(flowerbed, n);
        System.out.println(b);
    }

    // 如果是 flowerbed[i] = 0
// 就進去 看左跟右是否為 0 如果是就把當下的 變為 1
    class Solution {
        /**
         * Runtime: 1 ms, Beats 97.63% O(n)
         * 檢查左邊是否為 0，檢查右邊是否為 0
         * 如果兩邊都是 0 表示可以插花，把 n 扣掉
         * 如果最多可以插兩朵， n = 1，則 n 最後會等於 -1
         * 所以 return n <= 0;
         */
//        public boolean canPlaceFlowers(int[] flowerbed, int n) {
//            for (int i = 0; i < flowerbed.length; i++) {
//                if (flowerbed[i] == 0) {
//                    boolean isLeftEmpty = (i == 0 || flowerbed[i - 1] == 0);
//                    boolean isRightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
//
//                    if (isLeftEmpty && isRightEmpty) {
//                        flowerbed[i] = 1;
//                        n--;
//                    }
//                }
//            }
//            return n <= 0;
//        }

        /**
         * 如果是 0
         * > 且當前位置跟下一個一樣，代表可以插花，插完之後跳 2 格
         * > 且位置是最後一筆資料
         * > 但不滿足上述條件，則 i + 1 等於一次跳三個，因為代表已經插過花了
         *
         * 如果是 1 往後跳 2 個
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            for (int i = 0; i < len; i = i + 2) {
                if (flowerbed[i] == 0) {
                    if (i == len - 1 || flowerbed[i] == flowerbed[i + 1]) {
                        n--;
                    } else {
                        i++;
                    }
                }
            }
            return n <= 0;
        }
    }
}