package graph.bfs;

import java.util.*;

/**
 * 1926.https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/18 14:58:15
 * @since JDK8.0
 */
public class Nearest_Exit_From_Entrance_In_Maze_1926 {
    public static void main(String[] args) {
        Nearest_Exit_From_Entrance_In_Maze_1926 s = new Nearest_Exit_From_Entrance_In_Maze_1926();
        Nearest_Exit_From_Entrance_In_Maze_1926.Solution solution = s.new Solution();

        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};

        int result = solution.nearestExit(maze, entrance);

        System.out.println("result: " + result);
    }

    /**
     * Runtime: 4 ms, Beats 96.43%
     * 解法:
     * 使用 BFS 從起點開始檢查到上下左右
     * 若上下左右在邊界上，且不能於入口，則回傳路徑
     */
//    class Solution {
//        private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//        public int nearestExit(char[][] maze, int[] entrance) {
//            int rows = maze.length, cols = maze[0].length, steps = 0;
//            Queue<int[]> queue = new LinkedList<>();
//            queue.offer(entrance);
//
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    int[] current = queue.poll();
//                    int x = current[0], y = current[1];
//
//                    if ((x != entrance[0] || y != entrance[1]) && (x == 0 || y == 0 || x == rows - 1 || y == cols - 1)) {
//                        return steps;
//                    }
//                    for (int[] direction : directions) {
//                        int newX = x + direction[0], newY = y + direction[1];
//                        if (0 <= newX && newX < rows && 0 <= newY && newY < cols && maze[newX][newY] == '.') {
//                            maze[newX][newY] = '+';
//                            queue.offer(new int[]{newX, newY});
//                        }
//                    }
//                }
//                steps++;
//            }
//            return -1;
//        }
//    }

    /**
     * Runtime: 3 ms, Beats 100.00%
     * 解法:
     * 把 test1 做優化
     * 把原本 int[] 儲存成 [起點, 終點, 步數] 改成物件
     */
    class Solution {
        private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        class Cord {
            private int x;
            private int y;
            private int steps;

            public Cord(int x, int y, int steps) {
                this.x = x;
                this.y = y;
                this.steps = steps;
            }
        }

        public int nearestExit(char[][] maze, int[] entrance) {
            Queue<Cord> queue = new LinkedList<>();
            int rows = maze.length, cols = maze[0].length;
            queue.offer(new Cord(entrance[0], entrance[1], 0));

            while (!queue.isEmpty()) {
                Cord cord = queue.poll();
                int x = cord.x, y = cord.y, steps = cord.steps;
                if ((x != entrance[0] || y != entrance[1]) && (x == 0 || y == 0 || x == rows - 1 || y == cols - 1)) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int newX = x + direction[0], newY = y + direction[1];
                    if (0 <= newX && newX < rows && 0 <= newY && newY < cols && maze[newX][newY] == '.') {
                        maze[newX][newY] = '+';
                        queue.offer(new Cord(newX, newY, steps + 1));
                    }
                }
            }
            return -1;
        }
    }
}