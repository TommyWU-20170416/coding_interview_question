package array.medium;

/**
 * 11.https://leetcode.com/problems/container-with-most-water/description/
 * @author AaronWU
 * @version 創建時間：2020年1月21日 下午5:48:08
 * @since JDK8.0
 */
public class Container_With_Most_Water {

    public static void main(String[] args) {
        int[] height = {1, 2, 100, 1, 1, 1, 1, 1, 2};
        System.out.println("result:" + maxArea2(height));
        System.out.println("result:" + maxArea3(height));
    }

    /**
     * time:O(n^2) space:O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int sizeOfheight = height.length;
        int area = 0;
        for (int i = 0; i < sizeOfheight; i++) {
            for (int j = i + 1; j < sizeOfheight; j++) {
                int length = j - i;

                System.out.print("[A" + i + j + "]*" + length + "=" + minVerticalLine(height[i], height[j]) * length + " ");
                if (area < minVerticalLine(height[i], height[j]) * length) {
                    area = minVerticalLine(height[i], height[j]) * length;
                }
            }
            System.out.println();
        }
        return area;
    }

    public static int minVerticalLine(int a, int b) {
        return (a > b) ? b : a;
    }

    /**
     * 每一個最小的高度要創造最大的面積則是距離越長越好
     * 因此只要最小高度的面積算完，則可以進行下一個，計算其他面積
     * time:O(n) space:O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        int count = 0;
        while (l < r) {
            count++;
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("count: " + count);
        return maxarea;
    }

    /**
     * 如果接下來的高度沒有比現在高，其實沒有計算的必要，可以減少
     */
    public static int maxArea3(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        int count = 0;
        while (l < r) {
            count++;
            int minHeight = Math.min(height[l], height[r]);
            maxarea = Math.max(maxarea, minHeight * (r - l));
            while (height[l] <= minHeight && l < r) l++;
            while (height[r] <= minHeight && l < r) r--;
        }
        System.out.println("count: " + count);
        return maxarea;
    }
}
