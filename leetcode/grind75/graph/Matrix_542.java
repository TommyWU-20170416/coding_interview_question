package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542.https://leetcode.com/problems/01-matrix/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/01 17:35:24
 * @since JDK8.0
 */
public class Matrix_542 {
    public static void main(String[] args) {
        Matrix_542 ss = new Matrix_542();
        Matrix_542.Solution solution = ss.new Solution();
//        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] mat = {{1, 1}, {1, 0}};
        int[][] result = solution.updateMatrix(mat);
        System.out.print(result);
    }

    /**
     * Runtime14msBeats62.68%
     * 使用 BFS
     * 創建 dist 把非 0 的都先改成 Integer.MAX_VALUE，等於 0 的時候 q.add() 讓後面知道說這幾個加入的點是要去看得
     *
     */
//    class Solution {
//        public int[][] updateMatrix(int[][] mat) {
//            int rows = mat.length, cols = mat[0].length;
//            int[][] dist = new int[rows][cols];
//            Queue<int[]> q = new LinkedList<>();
//
//            // create a new mat to put the 0
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    if (mat[i][j] == 0) {
//                        dist[i][j] = 0;
//                        q.add(new int[]{i, j}); // 在遍歷的過程中，就把 0 的都加進來，這些都是確定位置的，所以提供給後面去看四周有沒有要更新的
//                    } else {
//                        dist[i][j] = Integer.MAX_VALUE;
//                    }
//                }
//            }
//
//            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// 上 下 左 右
//
//            // 0  0  0
//            // 0 MAX 0
//            // 0  0  0
//            while (!q.isEmpty()) {
//                int[] current = q.poll();
//                int currentRow = current[0];
//                int currentCol = current[1];
//
//                for (int[] direction : directions) {
//                    int newRow = currentRow + direction[0];
//                    int newCol = currentCol + direction[1];
//
//                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
//                        if (dist[newRow][newCol] > dist[currentRow][currentCol] + 1) { // 如果該點原本是 1 就會是 MAX 然後比較 MAX > 0 + 1 就打該點更新為 1
//                            dist[newRow][newCol] = dist[currentRow][currentCol] + 1;
//                            q.add(new int[]{newRow, newCol}); // 由於更新過，所以這些點要納入計算
//                        }
//                    }
//                }
//            }
//            return dist;
//        }
//    }

    /**
     * Runtime: 6 ms, Beats 98.93%
     * 使用 DP 規劃
     */
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int max = m + n; // 主要是讓該直可以超過最大的可能不被取代

            // 左上 > 右下 看 top left
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0)
                        continue;
                    int top = (i - 1 >= 0) ? mat[i - 1][j] : max;
                    int left = (j - 1 >= 0) ? mat[i][j - 1] : max;
                    mat[i][j] = Math.min(top, left) + 1;
                }
            }

            // 右下 > 左上 看 bottom right
            // 這邊看回來要跟原本的比較大小
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] == 0)
                        continue;
                    int bottom = (i + 1 < m) ? mat[i + 1][j] : max;
                    int right = (j + 1 < n) ? mat[i][j + 1] : max;
                    mat[i][j] = Math.min(mat[i][j], (Math.min(bottom, right) + 1));
                }
            }

            return mat;
        }
    }

}
