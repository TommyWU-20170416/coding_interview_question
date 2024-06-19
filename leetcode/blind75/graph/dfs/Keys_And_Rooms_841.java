package graph.dfs;

import binarytree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841.https://leetcode.com/problems/keys-and-rooms/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/14 15:38:45
 * @since JDK8.0
 */
public class Keys_And_Rooms_841 {
    public static void main(String[] args) {
        Keys_And_Rooms_841 s = new Keys_And_Rooms_841();
        Keys_And_Rooms_841.Solution solution = s.new Solution();

        int[][] inputArray = {{1, 3}, {}, {}, {1, 3}};
//        int[][] inputArray = {{1, 3}, {1, 4}, {2, 3, 4, 1}, {}, {4, 3, 2}};
        // 初始化 List<List<Integer>> 結構
        List<List<Integer>> rooms = new ArrayList<>();

        // 將輸入值轉換為 List<List<Integer>>
        for (int[] arr : inputArray) {
            List<Integer> room = new ArrayList<>();
            for (int num : arr) room.add(num);
            rooms.add(room);
        }

        boolean result = solution.canVisitAllRooms(rooms);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 DFS，set 紀錄 訪問過的房間也就是 key
         * 如果沒有訪問過就加入 set
         */
//        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//            Set<Integer> visited = new HashSet();
//            visited.add(0);
//            canVisitAllRooms_recursion(rooms, 0, visited);
//            return rooms.size() == visited.size();
//        }
//
//        private void canVisitAllRooms_recursion(List<List<Integer>> rooms, int roomIndex, Set<Integer> visited) {
//            for (int key : rooms.get(roomIndex)) {
//                if (!visited.contains(key)) {
//                    visited.add(key);
//                    canVisitAllRooms_recursion(rooms, key, visited);
//                }
//            }
//        }

        /**
         * test2
         * 解法:
         * 使用 count 當作有進去計算的次數，最後返回跟長度比較
         * visited 由 set 改成 array 會更快
         */
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            return rooms.size() == dfs(0, new boolean[rooms.size()], rooms);
        }

        public int dfs(int start, boolean[] visited, List<List<Integer>> rooms) {
            visited[start] = true;
            int count = 1;
            for (Integer key : rooms.get(start)) {
                if (visited[key]) continue;
                count += dfs(key, visited, rooms);
            }
            return count;
        }
    }
}
