package graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number_Of_Provinces_547 {
    public static void main(String[] args) {
        Number_Of_Provinces_547 s = new Number_Of_Provinces_547();
        Number_Of_Provinces_547.Solution solution = s.new Solution();

//        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected = {{1, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        int result = solution.findCircleNum(isConnected);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 情境一 return 3
         * - 1
         * -
         * 2  3
         * <p>
         * 情境二 return 2
         * - 1
         * -/
         * 2  3
         * <p>
         * 情境三 return 1
         * - 1
         * -/
         * 2 - 3
         * <p>
         * 情境四 return 1
         * - 1
         * -/ \
         * 2 - 3
         */
//        public int findCircleNum(int[][] isConnected) {
//            Set<Integer> visited = new HashSet<>();
//            int count = 0;
//
//            for (int row = 0; row < isConnected.length; row++) {
//                if (!visited.contains(row)) {
//                    findCircleNum_helper(isConnected, row, visited);
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        private void findCircleNum_helper(int[][] isConnected, int row, Set<Integer> visited) {
//            if (visited.contains(row)) return;
//
//            visited.add(row);
//            for (int col = 0; col < isConnected[row].length; col++) {
//                if (isConnected[row][col] == 1) {
//                    findCircleNum_helper(isConnected, col, visited);
//                }
//            }
//        }
        public int findCircleNum(int[][] isConnected) {
            boolean[] visited = new boolean[isConnected.length];
            int count = 0;

            for (int row = 0; row < isConnected.length; row++) {
                if (!visited[row]) {
                    findCircleNum_helper(isConnected, row, visited);
                    count++;
                }
            }
            return count;
        }

        private void findCircleNum_helper(int[][] isConnected, int row, boolean[] visited) {
            visited[row] = true;
            for (int col = 0; col < isConnected[row].length; col++) {
                if (isConnected[row][col] == 1 && !visited[col]) {
                    findCircleNum_helper(isConnected, col, visited);
                }
            }
        }
    }
}
