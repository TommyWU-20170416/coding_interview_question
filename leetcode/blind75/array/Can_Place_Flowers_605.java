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
//        int[] flowerbed = {1, 0, 0, 0, 1};
        int[] flowerbed = {0, 1, 0, 0, 1};
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
         * 如果都是 0，下一個插花的距離就是往後 + 2
         * 一次跳兩格，若到了 0 但不能插花 就多 +1 格
         * i == len - 1；如果倒數第二個是 0 ，最後一個也就可以插花，倒數第二個是否等於 0 會在上一次的 flowerbed[i] == flowerbed[i + 1] 檢查過
         * 這個也是確保最後不會溢位
         * 滿巧妙的思考，一次往後跳兩隔，但同時也檢查下一個是不是 0
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