package binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 113.https://leetcode.com/problems/path-sum-ii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 20:51:41
 * @since JDK8.0
 */
public class Path_Sum_II_113 {
    public static void main(String[] args) {
        Path_Sum_II_113 s = new Path_Sum_II_113();
        Path_Sum_II_113.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(4), null);
        int targetSum = 8;

        List<List<Integer>> result = solution.pathSum(t1, targetSum);
        System.out.println(result);
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) return new ArrayList<>();
            return pathSum_help(root, targetSum, new ArrayList<>(), new ArrayList<>());
        }

        private List<List<Integer>> pathSum_help(TreeNode node, int targetSum, List<Integer> list, List<List<Integer>> result) {
            if (node == null) return null;
            list.add(node.val);
            int remain = targetSum - node.val;
            if (node.left == null && node.right == null) {
                if (remain == 0) {
                    result.add(new ArrayList<>(list));
                }
            } else {
                pathSum_help(node.left, remain, list, result);
                pathSum_help(node.right, remain, list, result);
            }
            list.remove(list.size() - 1);
            return result;
        }
    }
}
