package graph.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges_994 {
    public static void main(String[] args) {
        Rotting_Oranges_994 s = new Rotting_Oranges_994();
        Rotting_Oranges_994.Solution solution = s.new Solution();

//        int[][] maze = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] maze = {{1}}; // -1
//        int[][] maze = {{0}}; // 0
        int[][] maze = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] maze = {{2, 2}, {1, 1}, {0, 0}, {2, 0}}; //Expected: 1
        int result = solution.orangesRotting(maze);

        System.out.println("result: " + result);
    }

    /**
     * Runtime: 2 ms, Beats 72.94%
     * 一般常見的做法
     */
//    class Solution {
//        private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//        public int orangesRotting(int[][] grid) {
//            Queue<int[]> queue = new LinkedList<>();
//            int count = 0, steps = 0, rows = grid.length, cols = grid[0].length;
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    if (grid[i][j] == 1) {
//                        count++;
//                    } else if (grid[i][j] == 2) {
//                        queue.offer(new int[]{i, j});
//                    }
//                }
//            }
//            if (count == 0) return 0;
//            if (queue.isEmpty()) return -1;
//            // use bfs to follow 4-directions to substrate the count of fresh oranges
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    int[] current = queue.poll();
//                    int x = current[0], y = current[1];
//                    // check each point
//                    for (int[] direction : directions) {
//                        int newX = x + direction[0], newY = y + direction[1];
//                        if (0 <= newX && newX < rows && 0 <= newY && newY < cols && grid[newX][newY] == 1) {
//                            count--;
//                            grid[newX][newY] = 2;
//                            queue.offer(new int[]{newX, newY});
//                        }
//                    }
//                }
//                steps++;
//            }
//            return count > 0 ? -1 : steps - 1; // 因為是先標記，標記後再從 qeue 找一次上下左右，當剩下最後一批，再檢查就會多做一次
//        }
//    }
    /**
     * Runtime: 2 ms, Beats 72.94%
     * 這邊是在 queue 添加 null 做為區隔，當遇到 null 且後面還有東西表示 要加
     * 這樣可以把 for 取代掉， for 是看 queue.size()，去做檢視
     * null 的添加可以當作是每一輪的結束
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
//                    if (grid[row][col] == 2) q.add(new int[]{row, col});
//                    else if (grid[row][col] == 1) {
//                        countFreshOrange++;
//                    }
//                }
//            }
//            if (countFreshOrange == 0) return 0;
//            if (q.isEmpty()) return -1; // may be there is not  rottenOrange
//            q.add(null); // be the end trigger
//            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//            while (!q.isEmpty()) {
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

    /**
     * Runtime: 1 ms, Beats 100.00%
     * 這看起來是把它用 物件包起來，但使用物件沒有比較快
     * 而是 if 分開寫，有時候會比 for 跑 4-方向 一整圈快一點
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
            int rows = grid.length;  // rows
            int cols = grid[0].length;  // cols

            // Enqueue all rotten oranges initially
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
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
                Pair current = q.remove();
                int row = current.row;
                int col = current.col;
                int time = current.time;
                ans = time;

                // 下面整段判斷跟 for 一樣，只是單獨判斷，可能會快點
                // Upper neighbour
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    q.add(new Pair(row - 1, col, time + 1));
                    grid[row - 1][col] = 2;
                    freshOranges--;
                }

                // Right neighbour
                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    q.add(new Pair(row, col + 1, time + 1));
                    grid[row][col + 1] = 2;
                    freshOranges--;
                }

                // Down neighbour
                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    q.add(new Pair(row + 1, col, time + 1));
                    grid[row + 1][col] = 2;
                    freshOranges--;
                }

                // Left neighbour
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    q.add(new Pair(row, col - 1, time + 1));
                    grid[row][col - 1] = 2;
                    freshOranges--;
                }
            }
            return freshOranges > 0 ? -1 : ans;
        }
    }
}