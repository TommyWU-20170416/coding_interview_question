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

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 BFS 從起點開始檢查到上下左右
         * 若上下左右在邊界上，且不能於入口，則回傳路徑
         * 4ms Beats 96.53%
         */
//        public int nearestExit(char[][] maze, int[] entrance) {
//            int result = bfs(maze, entrance);
//            return result;
//        }
//
//        private int bfs(char[][] maze, int[] entrance) {
//            int rows = maze.length;
//            int cols = maze[0].length;
//            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四個方向
//            Queue<int[]> queue = new LinkedList<>();
//            Set<String> visited = new HashSet<>();
//
//            // 將入口點加入隊列並標記為已訪問
//            queue.offer(new int[]{entrance[0], entrance[1], 0});
//            visited.add(entrance[0] + "," + entrance[1]);
//
//            while (!queue.isEmpty()) {
//                int[] current = queue.poll();
//                int x = current[0];
//                int y = current[1];
//                int steps = current[2];
//
//                // 檢查四個方向
//                for (int[] direction : directions) {
//                    int nx = x + direction[0];
//                    int ny = y + direction[1];
//
//                    // 確保新位置在迷宮內且不是牆
//                    // boundary case: nx >= 0 && nx < rows && ny >= 0 && ny < cols
//                    // 確保不是牆壁(+)
//                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == '.') {
//                        // 檢查是否為出口（邊界上的空地）且不是入口
//                        // boundary case: nx == 0 || ny == 0 || nx == rows - 1 || ny == cols - 1
//                        // 若出口 == 入口 不能納入計算
//                        if ((nx == 0 || ny == 0 || nx == rows - 1 || ny == cols - 1) && !(nx == entrance[0] && ny == entrance[1])) {
//                            return steps + 1;
//                        }
//
//                        // 如果是空地且未被訪問，加入隊列
//                        if (!visited.contains(nx + "," + ny)) {
//                            queue.offer(new int[]{nx, ny, steps + 1});
//                            visited.add(nx + "," + ny);
//                        }
//                    }
//                }
//            }
//            // 若無法找到出口
//            return -1;
//        }

        /**
         * test2
         * 解法:
         * 把 test1 做優化
         * 把原本 int[] 儲存 [起點, 終點, 步數] 改成物件
         * visited 因為會多佔據空間作儲存，所以是 O(V) V:迷宮節點數，但如果改成 + 就不用這空間
         */
        class Cord {
            int x;
            int y;
            int distFromEntrance;

            public Cord(int x, int y, int distFromEntrance) {
                this.x = x;
                this.y = y;
                this.distFromEntrance = distFromEntrance;
            }
        }

        public int nearestExit(char[][] maze, int[] entrance) {
            Queue<Cord> pathToExit = new ArrayDeque<>();
            int rows = maze.length;
            int cols = maze[0].length;

            pathToExit.add(new Cord(entrance[0], entrance[1], 0));
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!pathToExit.isEmpty()) {
                Cord curr = pathToExit.poll();
                // 是否在邊界上 && 不是入口
                if (curr.x == 0 || curr.x == rows - 1 || curr.y == 0 || curr.y == cols - 1 && !(curr.x == entrance[0] && curr.y == entrance[1]))
                    return curr.distFromEntrance;

                for (int[] dir : directions) {
                    int newX = curr.x + dir[0];
                    int newY = curr.y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                        maze[newX][newY] = '+';
                        pathToExit.add(new Cord(newX, newY, curr.distFromEntrance + 1));
                    }
                }
            }
            return -1;
        }
    }
}
