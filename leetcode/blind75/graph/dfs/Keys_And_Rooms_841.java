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

        int[][] inputArray = {{1}, {}, {3}, {1, 3}}; // false
//        int[][] inputArray = {{1, 3}, {}, {}, {1, 3}}; // false
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

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 使用 dfs 當進入房間就是 拜訪過
     * 進去房間後拿到鑰匙，再根據鑰匙去房間找下一把鑰匙
     */
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];
            canVisitAllRooms_dfs(rooms, visited, 0);

            for (boolean visit : visited) {
                if (!visit)
                    return false;
            }
            return true;
        }

        public void canVisitAllRooms_dfs(List<List<Integer>> rooms, boolean[] visited, int roomIndex) {
            if (visited[roomIndex])
                return;
            visited[roomIndex] = true;
            List<Integer> keys = rooms.get(roomIndex);
            for (int key : keys) {
                if (!visited[key])
                    canVisitAllRooms_dfs(rooms, visited, key);
            }
        }
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 因為 visited 還要計算一次，簡化這操作，在 dfs 內判斷 visit 次數
     * count 當作有進去計算的次數，最後返回跟長度比較
     */
//    class Solution {
//        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//            return rooms.size() == dfs(0, new boolean[rooms.size()], rooms);
//        }
//
//        public int dfs(int start, boolean[] visited, List<List<Integer>> rooms) {
//            visited[start] = true;
//            int count = 1;
//            for (Integer key : rooms.get(start)) {
//                if (visited[key]) continue;
//                count += dfs(key, visited, rooms);
//            }
//            return count;
//        }
//    }
}
