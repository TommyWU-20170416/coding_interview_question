package graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 1466.https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/15 11:57:09
 * @since JDK8.0
 */
public class Reorder_Routes_To_Make_All_Paths_Lead_To_The_City_Zero_1466 {
    public static void main(String[] args) {
        Reorder_Routes_To_Make_All_Paths_Lead_To_The_City_Zero_1466 s = new Reorder_Routes_To_Make_All_Paths_Lead_To_The_City_Zero_1466();
        Reorder_Routes_To_Make_All_Paths_Lead_To_The_City_Zero_1466.Solution solution = s.new Solution();

        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int n = 6;
        int result = solution.minReorder(n, connections);

        System.out.println("result: " + result);
    }

    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // 初步建立各點到各點的方向，但不一定是正確的方向
            // 目前假設是右>左是正確的方向
            // 若有五條路線，這個跑完會有 5 * 2 = 10 組
            for (int[] conn : connections) {
                int start = conn[0];
                int end = conn[1];
                graph.get(start).add(new int[]{end, 1}); // conn[0] -> conn[1], 1表示需要翻轉
                graph.get(end).add(new int[]{start, 0}); // conn[1] -> conn[0], 0表示不需要翻轉
            }

            boolean[] visited = new boolean[n];
            return minReorder_helper(graph, visited, 0);
        }

        private int minReorder_helper(List<List<int[]>> graph, boolean[] visited, int node) {
            visited[node] = true;
            int changeCount = 0;
            for (int[] neighbor : graph.get(node)) {
                if (!visited[neighbor[0]]) {
                    changeCount += neighbor[1] + minReorder_helper(graph, visited, neighbor[0]);
                }
            }
            return changeCount;
        }
    }
}
