package array.medium;

/**
 * 11.https://leetcode.com/problems/container-with-most-water/description/
 *
 * @author AaronWU
 * @version 創建時間：2020年1月21日 下午5:48:08
 * @since JDK8.0
 */
public class Container_With_Most_Water {

    public static void main(String[] args) {
//        int[] height = {1, 2, 100, 1, 1, 1, 1, 1, 2};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("result:" + maxArea(height));
//        System.out.println("result:" + maxArea3(height));
    }

    /**
     * time:O(n^2) space:O(1)
     *
     * @param height
     * @return
     */
//    public static int maxArea(int[] height) {
//        int sizeOfheight = height.length;
//        int area = 0;
//        for (int i = 0; i < sizeOfheight; i++) {
//            for (int j = i + 1; j < sizeOfheight; j++) {
//                int length = j - i;
//
//                System.out.print("[A" + i + j + "]*" + length + "=" + minVerticalLine(height[i], height[j]) * length + " ");
//                if (area < minVerticalLine(height[i], height[j]) * length) {
//                    area = minVerticalLine(height[i], height[j]) * length;
//                }
//            }
//            System.out.println();
//        }
//        return area;
//    }
//
//    public static int minVerticalLine(int a, int b) {
//        return (a > b) ? b : a;
//    }
//

    /**
     * Runtime: 2 ms, Beats 98.70%
     * 如果接下來的高度沒有比現在高，其實沒有計算的必要，可以減少
     */
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            maxarea = Math.max(maxarea, minHeight * (r - l));
            while (height[l] <= minHeight && l < r)
                l++;
            while (height[r] <= minHeight && l < r)
                r--;
        }
        return maxarea;
    }
}
