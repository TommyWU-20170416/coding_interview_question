package binarytree.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 437.https://leetcode.com/problems/path-sum-iii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 17:44:01
 * @since JDK8.0
 *
 * 這是 dfs + prefixSum 的組合技
 */
public class Path_Sum_III_437 {
    public static void main(String[] args) {
        Path_Sum_III_437 s = new Path_Sum_III_437();
        Path_Sum_III_437.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(4), null);
        int targetSum = 7;

        int result = solution.pathSum(t1, targetSum);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用雙 dfs 的方式去找資料
         * 第一層是 pathSum_help
         * 第二層是 pathSum
         *
         * 而且是先找完 pathSum_help(root, targetSum) 然後才再去找 root.left 跟 root.right
         * 可能會覺得這樣會少層數，因為只去看 root.left 跟 root.right，但實際上他又是一個地回，所以不用擔心
         */
//        public int pathSum(TreeNode root, int targetSum) {
//            if (root == null) return 0;
//            int count = pathSum_help(root, targetSum);
//            count += pathSum(root.left, targetSum);
//            count += pathSum(root.right, targetSum);
//            return count;
//        }
//
//        private int pathSum_help(TreeNode node, long targetSum) {
//            if (node == null) return 0;
//            int count = 0;
//            if (targetSum == node.val)
//                count++;
//
//            count += pathSum_help(node.left, targetSum - node.val);
//            count += pathSum_help(node.right, targetSum - node.val);
//
//            return count;
//        }

        /**
         * test2
         * 解法:
         * 像這種要紀錄 前墜的和，就適合 prefixSum 搭配 hashmap 去紀錄
         */
        public int pathSum(TreeNode root, int targetSum) {
            Map<Integer, Integer> prefixSumCount = new HashMap<>();
            prefixSumCount.put(0, 1); // 初始情況總和 0 出現一次
            return pathSum_helper(root, 0, targetSum, prefixSumCount);
        }

        private int pathSum_helper(TreeNode node, int currentSum, int targetSum, Map<Integer, Integer> prefixSumCount) {
            if (node == null) return 0;

            currentSum += node.val;
            // 這邊是去找當前的 currentSum 跟 targetSum 的差異，使否有出現在 map 中
            // 就已這題來講
            // 當計算到 1 + 2 + 5 = 8， 8 - 7 = 1
            // 這邊的 1 就有在 map 裡面找到，而 1 就是從 root 的 1 來的
            // 意思就是 當把 8 減去 root 的 1 就是 targetSum 了
            // 使用這樣紀錄之前的 sum 去找到合適的
            int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

            // 更新前綴和
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

            count += pathSum_helper(node.left, currentSum, targetSum, prefixSumCount);
            count += pathSum_helper(node.right, currentSum, targetSum, prefixSumCount);

            // 每次算完返回上一層，都要扣掉自己
            prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
            return count;
        }

    }
}