package binarytree.dfs;

/**
 * 112.https://leetcode.com/problems/path-sum/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 20:10:32
 * @since JDK8.0
 */
public class Path_Sum_112 {
    public static void main(String[] args) {
        Path_Sum_112 s = new Path_Sum_112();
        Path_Sum_112.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(6), null);
        int targetSum = 8;

        boolean result = solution.hasPathSum(t1, targetSum);
        System.out.println(result);
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return pathSum(root, targetSum);
        }

        private boolean pathSum(TreeNode node, int currentSum) {
            if (node == null) return false;

            int remain = currentSum - node.val;
            if (node.left == null && node.right == null) {
                return remain == 0;
            }

            boolean left = pathSum(node.left, remain);
            boolean right = pathSum(node.right, remain);

            return left || right;
        }
    }
}
