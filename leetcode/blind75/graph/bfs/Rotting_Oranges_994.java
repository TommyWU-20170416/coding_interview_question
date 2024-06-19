package graph.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges_994 {
    public static void main(String[] args) {
        Rotting_Oranges_994 s = new Rotting_Oranges_994();
        Rotting_Oranges_994.Solution solution = s.new Solution();

        int[][] maze = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = solution.orangesRotting(maze);

        System.out.println("result: " + result);
    }

    class Solution {
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

        public int orangesRotting(int[][] grid) {
            Queue<int[]> rottenOrangeQueue = new ArrayDeque();
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int rows = grid.length;
            int cols = grid[0].length;
            int freshOranges = 0;
            int minutes = 0;

            // count fresh oranges and find the rotten oranges
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) freshOranges++;
                    else if (grid[i][j] == 2) rottenOrangeQueue.offer(new int[]{i, j});
                }
            }

            // If there are no fresh oranges, return 0
            if (freshOranges == 0) return 0;

            // size:
            // if first add one, rottenorange than will do one
            // if second add two, rottenorange than will do two
            while (!rottenOrangeQueue.isEmpty() && freshOranges > 0) {
                int size = rottenOrangeQueue.size();
                for (int i = 0; i < size; i++) {
                    int[] rottenOrange = rottenOrangeQueue.poll();
                    int x = rottenOrange[0];
                    int y = rottenOrange[1];

                    // 上下左右開始
                    for (int[] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];

                        if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                            freshOranges--;
                            rottenOrangeQueue.offer(new int[]{newX, newY});
                            grid[newX][newY] = 2;
                        }
                    }
                }
                minutes++;
            }
            return freshOranges != 0 ? -1 : minutes;
        }
    }
}
