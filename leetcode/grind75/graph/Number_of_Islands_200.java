package graph;

/**
 * 200.https://leetcode.com/problems/number-of-islands/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/02 18:38:12
 * @since JDK8.0
 */
public class Number_of_Islands_200 {
    public static void main(String[] args) {
        Number_of_Islands_200 ss = new Number_of_Islands_200();
        Number_of_Islands_200.Solution solution = ss.new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};

//        char[][] grid = {
//                {'1', '0'},
//                {'0', '1'}};
        int result = solution.numIslands(grid);

        System.out.println(result);
    }

    /**
     * Runtime: 3 ms, Beats 84.69%
     * 建立一個 boolean[][] 代表被訪問過，被訪問過的就可以跳過
     * 只要一區，上下左右都訪問完(超過邊界 || 被訪問過 || '0') 就可以視為一個 island 掃描完成
     */
//    class Solution {
//        public int numIslands(char[][] grid) {
//            if (grid == null || grid.length == 0) return 0;
//
//            int rows = grid.length, cols = grid[0].length, numIsland = 0;
//            boolean[][] visited = new boolean[rows][cols];
//
//            for (int row = 0; row < rows; row++) {
//                for (int col = 0; col < cols; col++) {
//                    if (grid[row][col] == '1' && !visited[row][col]) {
//                        numIslands_dfs(grid, row, col, visited);
//                        numIsland++;
//                    }
//                }
//            }
//            return numIsland;
//        }
//
//        private void numIslands_dfs(char[][] grid, int row, int col, boolean[][] visited) {
//            int rows = grid.length, cols = grid[0].length;
//            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col]) {
//                return;
//            }
//            visited[row][col] = true;
//            numIslands_dfs(grid, row - 1, col, visited); // 上
//            numIslands_dfs(grid, row + 1, col, visited); // 下
//            numIslands_dfs(grid, row, col - 1, visited); // 左
//            numIslands_dfs(grid, row, col + 1, visited); // 右
//        }
//    }

    /**
     * Runtime: 1 ms, Beats 100.00%
     */
    class Solution {
        int row;
        int col;
        char[][] arr;
        int numIsland;

        public int numIslands(char[][] grid) {
            row = grid.length;
            col = grid[0].length;
            arr = grid;

            numIsland = 0;
            for (int i = 0; i < row; i++) {
                check(grid[i], i);
            }
            return numIsland;
        }

        // 這段很酷 因為跟上面的 雙for 一樣寫法但這個就是比較快，可能因為變成 method 調用會比較快
        void check(char[] row, int i) {
            for (int j = 0; j < col; j++) {
                if (row[j] == '1') {
                    visitIsland(i, j);
                    numIsland++;
                }
            }
        }

        public void visitIsland(int i, int j) {
            arr[i][j] = 2; // 2 表示訪問過
            if (i - 1 >= 0 && arr[i - 1][j] == '1') visitIsland(i - 1, j);
            if (i + 1 < row && arr[i + 1][j] == '1') visitIsland(i + 1, j);
            if (j - 1 >= 0 && arr[i][j - 1] == '1') visitIsland(i, j - 1);
            if (j + 1 < col && arr[i][j + 1] == '1') visitIsland(i, j + 1);
        }
    }
}
