package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733.https://leetcode.com/problems/flood-fill/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/01 14:11:50
 * @since JDK8.0
 */
public class Flood_Fill_733 {
    public static void main(String[] args) {
        Flood_Fill_733 ss = new Flood_Fill_733();
        Flood_Fill_733.Solution solution = ss.new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        int[][] result = solution.floodFill(image, sr, sc, color);
        System.out.print(result);
    }

    /**
     * Runtime: 1 ms, Beats 44.55%
     * 使用 BFS 一層層解決
     */
//    class Solution {
//        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//            int originalColor = image[sr][sc];
//
//            if (originalColor == color) return image;
//            floodFill_bfs(image, sr, sc, originalColor, color);
//
//            return image;
//        }
//
//        private void floodFill_bfs(int[][] image, int sr, int sc, int originalColor, int color) {
//            int rows = image.length, cols = image[0].length;
//            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 右 下 左 上
//            Queue<int[]> q = new LinkedList<>();
//            q.add(new int[]{sr, sc});
//
//            while (!q.isEmpty()) {
//                int[] current = q.poll();
//                int currentRow = current[0], currentCol = current[1];
//                // 把原本顏色改成新的
//                image[currentRow][currentCol] = color;
//
//                // 四個方向的處理
//                for (int[] direction : directions) {
//                    int newRow = currentRow + direction[0];
//                    int newCol = currentCol + direction[1];
//
//                    // if in bound && color same as center
//                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == originalColor) {
//                        q.add(new int[]{newRow, newCol});
//                    }
//                }
//            }
//        }
//    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 使用 DFS
     */
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int originalColor = image[sr][sc];
            if (newColor != originalColor)
                floodFill_dfs(image, sr, sc, originalColor, newColor);
            return image;
        }

        private void floodFill_dfs(int[][] image, int row, int col, int originalColor, int newColor) {
            if(row < 0 || col < 0 || row == image.length || col == image[0].length){
                return;
            }
            if(image[row][col] != originalColor){
                return;
            }
            image[row][col] = newColor;
            floodFill_dfs(image, row - 1, col, originalColor, newColor);
            floodFill_dfs(image, row + 1, col, originalColor, newColor);
            floodFill_dfs(image, row, col - 1, originalColor, newColor);
            floodFill_dfs(image, row, col + 1, originalColor, newColor);
        }
    }
}
