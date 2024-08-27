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
