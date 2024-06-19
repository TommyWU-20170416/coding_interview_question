package graph.dfs;

import java.util.*;

/**
 * 399.https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/06/17 14:30:19
 * @since JDK8.0
 */
public class Evaluate_Division_399 {
    public static void main(String[] args) {
        Evaluate_Division_399 s = new Evaluate_Division_399();
        Evaluate_Division_399.Solution solution = s.new Solution();

        String[][] e = {{"a", "b"}, {"b", "c"}}, q = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] values = {2.0, 3.0};

        // 初始化 List<List<Integer>> 結構
        List<List<String>> equations = new ArrayList<>();

        // 將輸入值轉換為 List<List<String>>
        for (String[] arr : e) {
            List<String> room = new ArrayList<>();
            for (String num : arr) room.add(num);
            equations.add(room);
        }
        List<List<String>> queries = new ArrayList<>();
        for (String[] arr : q) {
            List<String> room = new ArrayList<>();
            for (String num : arr) room.add(num);
            queries.add(room);
        }

        double[] result = solution.calcEquation(equations, values, queries);

        System.out.println("result: " + result);
    }

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            // build graph with equations from pair A to B
            Map<String, Map<String, Double>> graph = new HashMap<>();

            // use values to represent the distance between node to node
            for (int i = 0; i < equations.size(); i++) {
                List<String> nodes = equations.get(i);
                String start = nodes.get(0);
                String end = nodes.get(1);
                double value = values[i];

                // Ensure both nodes exist in the graph
                graph.putIfAbsent(start, new HashMap<>());
                graph.putIfAbsent(end, new HashMap<>());

                // Add the forward and reverse edges
                graph.get(start).put(end, value);
                graph.get(end).put(start, 1.0 / value);
            }

            // find the node and product the path
            double[] result = new double[queries.size()];

            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                String start = query.get(0);
                String end = query.get(1);
                result[i] = calcEquation_dfs(graph, start, end, new HashSet<String>());
            }
            return result;
        }

        private double calcEquation_dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
            // Boundary case: if start or end is not in the graph
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                return -1.0;
            }

            // if start == end
            if (start.equals(end)) {
                return 1.0;
            }

            visited.add(start);

            Map<String, Double> neighbors = graph.get(start);
            for (String neighbor : neighbors.keySet()) {
                if (!visited.contains(neighbor)) {
                    double procudt = neighbors.get(neighbor);
                    double result = calcEquation_dfs(graph, neighbor, end, visited);
                    if (result != -1.0) {
                        return procudt * result;
                    }
                }
            }
            visited.remove(start);

            return -1.0;
        }
    }
}
