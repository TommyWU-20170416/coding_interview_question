package hashmapandset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equal_Row_and_Column_Pairs_2352 {
    public static void main(String[] args) {
        Equal_Row_and_Column_Pairs_2352 s = new Equal_Row_and_Column_Pairs_2352();
        Equal_Row_and_Column_Pairs_2352.Solution solution = s.new Solution();

        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
//        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        int result = solution.equalPairs(grid);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 暴力解
         * 到每一個位置就看 row 跟 col 是否值都一樣的
         */
//        public int equalPairs(int[][] grid) {
//            int count = 0;
//            int[] row = new int[grid.length];
//            int[] col = new int[grid.length];
//            // 練習印出 二階的值
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    row = grid[i]; // can get row
//                    boolean isAllSame = true;
//                    for (int k = 0; k < grid[i].length; k++) {
//                        col[k] = grid[k][j];
//                        if (row[k] != col[k]) isAllSame = false;
//
//                    }
//                    if (isAllSame) count++;
//                }
//            }
//            return count;
//        }

        /**
         * test2
         * 解法:
         * 把每一個 row 看成一組， 每一個 col 看成一組，而且是比較順序的
         * 所以只要整組一起比較就好
         */
//        public int equalPairs(int[][] grid) {
//            int n = grid.length;
//            int count = 0;
//            Map<List<Integer>, Integer> map = new HashMap<>();
//
//            for (int row = 0; row < n; row++) {
//                List<Integer> rowList = new ArrayList<>();
//                for (int col = 0; col < n; col++) {
//                    rowList.add(grid[row][col]);
//                }
//                map.put(rowList, map.getOrDefault(rowList, 0) + 1);
//            }
//
//            for (int row = 0; row < n; row++) {
//                List<Integer> colList = new ArrayList<>();
//                for (int col = 0; col < n; col++) {
//                    colList.add(grid[col][row]);
//                }
//                count += map.getOrDefault(colList, 0);
//            }
//            return count;
//        }

        /**
         * test3
         * 解法:
         * 1. 把每一組都算出一個 hash
         * 2. 在用 hash 去找是否有重複的
         * 7 是質數，可以有效降低重複，但也不可保證一定不會衝突
         */
        public int getRowHash(int[] grid) {
            int result = 0;
            for (int i : grid) {
                result = i + 7 * result;
            }
            return result;
        }

        public int getColumnHash(int[][] grid, int column) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                result = grid[i][column] + 7 * result;
            }
            return result;
        }

        public int equalPairs(int[][] grid) {
            int n = grid.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            int pairs = 0;
            for (int[] i : grid) {
                int hash = getRowHash(i);
                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int hash = getColumnHash(grid, i);
                if (map.containsKey(hash)) pairs += map.get(hash);
            }
            return pairs;
        }
    }
}
