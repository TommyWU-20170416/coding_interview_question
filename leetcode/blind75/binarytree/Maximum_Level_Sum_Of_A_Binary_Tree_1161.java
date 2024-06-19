package binarytree;

import binarytree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1161.https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/06/12 12:11:09
 * @since JDK8.0
 */
public class Maximum_Level_Sum_Of_A_Binary_Tree_1161 {
    public static void main(String[] args) {
        Maximum_Level_Sum_Of_A_Binary_Tree_1161 s = new Maximum_Level_Sum_Of_A_Binary_Tree_1161();
        Maximum_Level_Sum_Of_A_Binary_Tree_1161.Solution solution = s.new Solution();

        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 7  X
        //    / \
        //   8   X
        // return [1, 3, 7, 8]
//        TreeNode t1 = new TreeNode(1);
//        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), null));
//        t1.right = new TreeNode(3, new TreeNode(7), null);

        TreeNode t1 = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));

        int result = solution.maxLevelSum(t1);
        System.out.println(result);
    }

    class Solution {
        public int maxLevelSum(TreeNode root) {
            List<Integer> levelSum = new ArrayList();
            maxLevelSum_helper(root, levelSum, 0);

            return findMax(levelSum);
        }

        private int findMax(List<Integer> levelSum) {
            int maxLevel = 0;
            for (int i = 1; i < levelSum.size(); i++) {
                if (levelSum.get(i) > levelSum.get(maxLevel)) {
                    maxLevel = i;
                }
            }
            return maxLevel + 1;
        }

        private void maxLevelSum_helper(TreeNode node, List<Integer> levelSum, int depth) {
            if (node == null)
                return;

            if (depth == levelSum.size()) {
                levelSum.add(node.val);
            } else {
                levelSum.set(depth, levelSum.get(depth) + node.val);
            }

            maxLevelSum_helper(node.left, levelSum, depth + 1);
            maxLevelSum_helper(node.right, levelSum, depth + 1);
        }
    }
}
