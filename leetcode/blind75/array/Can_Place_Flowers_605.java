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
        Can_Place_Flowers_605_Solution s = new Can_Place_Flowers_605_Solution();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean b = s.canPlaceFlowers(flowerbed, n);
        System.out.println();
    }
}

// 如果是 flowerbed[i] = 0
// 就進去 看左跟右是否為 0 如果是就把當下的 變為 1
class Can_Place_Flowers_605_Solution {
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
//
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0) {
//                boolean isLeftEmpty = (i == 0 || flowerbed[i - 1] == 0);
//                boolean isRightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
//
//                if (isLeftEmpty && isRightEmpty) {
//                    flowerbed[i] = 1;
//                    count++;
//                }
//            }
//        }
//        return count >= n;
//    }

    public boolean canPlaceFlowers(final int[] flowerbed, int n) {
        if (n == 0) return true;
        final int length = flowerbed.length;
        int empty = 1;
        for (int i = 0; i < length; i++) {
            final int slot = flowerbed[i];
            if (slot == 0) {
                empty++;
            } else {
                n -= empty - 1 >>> 1;
                if (n <= 0) return true;
                empty = 1;
                i++;
            }
        }
        n -= empty >>> 1;
        return n <= 0;
    }
}