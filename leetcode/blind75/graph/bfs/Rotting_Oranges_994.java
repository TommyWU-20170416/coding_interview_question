package graph.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges_994 {
    public static void main(String[] args) {
        Rotting_Oranges_994 s = new Rotting_Oranges_994();
        Rotting_Oranges_994.Solution solution = s.new Solution();

//        int[][] maze = {{2, 1, 1}, {1, 1, 0}, {0, 0, 1}};
        int[][] maze = {{1}}; // -1
//        int[][] maze = {{0}}; // 0
        int result = solution.orangesRotting(maze);

        System.out.println("result: " + result);
    }

    /**
     * Runtime: 1 ms, Beats 100.00%
     * 這看起來是把它用 物件包起來，但 ans 那段看不太懂，不過邏輯滿像
     */
    class Solution {
        class Pair {
            int row;
            int col;
            int time;

            Pair(int row, int col, int time) {
                this.row = row;
                this.col = col;
                this.time = time;
            }
        }

        int freshOranges = 0;

        public int orangesRotting(int[][] grid) {
            Queue<Pair> q = new LinkedList<>();
            int n = grid.length;  // rows
            int m = grid[0].length;  // cols

            // Enqueue all rotten oranges initially
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        freshOranges++;
                    } else if (grid[i][j] == 2) {
                        q.add(new Pair(i, j, 0));
                    }
                }
            }
            if (freshOranges == 0) return 0;
            if (q.isEmpty()) return -1;

            int ans = -1;
            while (!q.isEmpty()) {
                Pair rem = q.remove();
                int crow = rem.row;
                int ccol = rem.col;
                int ctime = rem.time;
                ans = ctime;

                // Upper neighbour
                if (crow - 1 >= 0 && grid[crow - 1][ccol] == 1) {
                    q.add(new Pair(crow - 1, ccol, ctime + 1));
                    grid[crow - 1][ccol] = 2;
                }

                // Right neighbour
                if (ccol + 1 < m && grid[crow][ccol + 1] == 1) {
                    q.add(new Pair(crow, ccol + 1, ctime + 1));
                    grid[crow][ccol + 1] = 2;
                }

                // Down neighbour
                if (crow + 1 < n && grid[crow + 1][ccol] == 1) {
                    q.add(new Pair(crow + 1, ccol, ctime + 1));
                    grid[crow + 1][ccol] = 2;
                }

                // Left neighbour
                if (ccol - 1 >= 0 && grid[crow][ccol - 1] == 1) {
                    q.add(new Pair(crow, ccol - 1, ctime + 1));
                    grid[crow][ccol - 1] = 2;
                }
            }

            // Check if there's any fresh orange left
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return ans == -1 ? 0 : ans;
        }
    }

    /**
     * Runtime: 2 ms, Beats 72.94%
     * 這邊是在 queue 添加 null 做為區隔，當遇到 null 且後面還有東西表示 要加
     */
//    class Solution {
//        int rows, cols, rottenMinutes = 0, countFreshOrange = 0;
//        Queue<int[]> q = new LinkedList<>();
//
//        public int orangesRotting(int[][] grid) {
//            rows = grid.length;
//            cols = grid[0].length;
//
//            // collect '2' to queue
//            for (int row = 0; row < rows; row++) {
//                for (int col = 0; col < cols; col++) {
//                    if (grid[row][col] == 2)
//                        q.add(new int[]{row, col});
//                    else if (grid[row][col] == 1) {
//                        countFreshOrange++;
//                    }
//                }
//            }
//            if(countFreshOrange == 0 && q.isEmpty()) return 0;
//            if (q.isEmpty()) return -1; // may be there is not  rottenOrange
//            q.add(null); // be the end trigger
//            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//            while (!q.isEmpty()) {
////                int size = q.size(); // 這邊獲取size ，等 size 跑完就代表要 ++，可以取代以下 if 判斷
////                for (int i = 0; i < size; i++) {
//                int[] current = q.poll();
//                if (current == null) {
//                    if (!q.isEmpty()) {
//                        rottenMinutes++;
//                        // 加入新的分隔符，表示下一轮
//                        q.add(null);
//                    }
//                } else {
//                    for (int[] direction : directions) {
//                        int nowRow = current[0] + direction[0], nowCol = current[1] + direction[1];
//                        if (nowRow < 0 || nowRow == rows || nowCol < 0 || nowCol == cols) continue;
//                        if (grid[nowRow][nowCol] == 1) {
//                            countFreshOrange--;
//                            grid[nowRow][nowCol] = 2;
//                            q.add(new int[]{nowRow, nowCol});
//                        }
//                    }
//                }
//            }
//            return countFreshOrange == 0 ? rottenMinutes : -1;
//        }
//    }
}
