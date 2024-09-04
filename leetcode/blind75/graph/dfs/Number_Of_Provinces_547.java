package graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 547.https://leetcode.com/problems/number-of-provinces/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/06 11:05:56
 * @since JDK8.0
 */
public class Number_Of_Provinces_547 {
    public static void main(String[] args) {
        Number_Of_Provinces_547 s = new Number_Of_Provinces_547();
        Number_Of_Provinces_547.Solution solution = s.new Solution();

//        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] isConnected = {{1, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        int[][] isConnected = {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
        int result = solution.findCircleNum(isConnected);

        System.out.println("result: " + result);
    }

    /**
     * Runtime: 1 ms, Beats 91.23%
     * 使用 DFS + visited[] 去紀錄走過的地方
     */
    class Solution {
        /**
         * test1
         * 情境一 return 3  情境二 return 2   情境三 return 1    情境四 return 1
         * - A                A              A                A
         * -                 /              /                / \
         * B  C             B  C           B - C            B - C
         */
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

    /**
     * 使用 Union Find方法解決
     */
//    class Solution {
//        public int findCircleNum(int[][] isConnected) {
//            int n = isConnected.length;
//            UnionFind uf = new UnionFind(n);
//
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    if (isConnected[i][j] == 1) {
//                        uf.union(i, j);
//                    }
//                }
//            }
//
//            return uf.getCount();
//        }
//    }
//
//    class UnionFind {
//        private int[] parent; // 紀錄每個節點的父節點
//        private int[] rank; // 記錄每個節點的秩（高度），有效的扁平化樹的高度，rank 小的要合併到 rank 大的，這樣整體樹的 rank 才會維持
//        private int count; // 記錄連通分量的數量
//
//        public UnionFind(int n) {
//            parent = new int[n];
//            rank = new int[n];
//            count = n;
//            for (int i = 0; i < n; i++) {
//                parent[i] = i; // 初始化，自己就是自己的根結點
//                rank[i] = 0;
//            }
//        }
//
//        public int find(int p) {
//            if (parent[p] != p) {
//                parent[p] = find(parent[p]);  // 路徑壓縮
//            }
//            return parent[p];
//        }
//
//        public void union(int p, int q) {
//            int rootP = find(p);
//            int rootQ = find(q);
//            if (rootP != rootQ) {
//                if (rank[rootP] > rank[rootQ]) {
//                    parent[rootQ] = rootP;
//                } else if (rank[rootP] < rank[rootQ]) {
//                    parent[rootP] = rootQ;
//                } else {
//                    parent[rootQ] = rootP;
//                    rank[rootP]++;
//                }
//                count--;
//            }
//        }
//
//        public int getCount() {
//            return count;
//        }
//    }
}
