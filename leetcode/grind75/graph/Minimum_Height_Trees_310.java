package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 310.https://leetcode.com/problems/minimum-height-trees/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/07 15:37:57
 * @since JDK8.0
 */
public class Minimum_Height_Trees_310 {
    public static void main(String[] args) {
        Minimum_Height_Trees_310 ss = new Minimum_Height_Trees_310();
        Minimum_Height_Trees_310.Solution solution = ss.new Solution();
//        int n = 4;
//        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        System.out.print(result);
    }

    /**
     * Runtime: 7 ms, Beats 99.77%
     * 使用修剪葉子節點策略 - 可參考 https://home.gamer.com.tw/artwork.php?sn=5478747
     */
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            int[] counts = new int[n]; // 每個節點的度數
            int[] links = new int[n]; // 節點與所有鄰居 XOR 結果
            for (int[] edge : edges) {
                int edge0 = edge[0], edge1 = edge[1];
                System.out.println("edge0:" + edge0 + ",edge1:" + edge1);
                System.out.print("links[edge0] ^= edge1: " + links[edge0] + " ^= " + edge1 + " = ");
                links[edge0] ^= edge1;
                counts[edge0]++;
                System.out.println(links[edge0]);
                System.out.print("links[edge1] ^= edge0: " + links[edge1] + " ^= " + edge0 + " = ");
                links[edge1] ^= edge0;
                counts[edge1]++;
                System.out.println(links[edge1]);
            }

            // 把 葉節點加入倒 queue
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (counts[i] == 1)
                    q.add(i);
            }
            // 透過 XOR自反性 把 count = 1 排除掉，count = 1 代表他是葉節點
            // 排掉的過程中若發現自己還是 葉節點就再加入 queue
            int level = 1;
            int[] dists = new int[n];
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int tmp = q.poll(); // count: [1, 3, 1, 1] 第一個是 tmp = 0
                    int neighbor = links[tmp];
                    links[neighbor] ^= tmp; // links[tmp] = 鄰居，links[鄰居] = 1 做 XOR 就是從 1 中排除 tmp 也就是排除 0
                    counts[neighbor]--; // 排除後次數也要扣掉
                    if (counts[neighbor] == 1) {
                        dists[neighbor] = Math.max(level, dists[neighbor]);
                        q.add(neighbor);
                    }
                }
                level++;
            }

            // 葉節點修剪完後，找出最大的並返回，最大的可能有多組
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(dists[i], max);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (dists[i] == max)
                    res.add(i);
            }
            return res;
        }
    }
}
