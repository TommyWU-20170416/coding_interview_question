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

        /**
         * ------ 1
         * --- 2    3
         * - 4  5  6
         */
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(6), null);
        int targetSum = 8;

        boolean result = solution.hasPathSum(t1, targetSum);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 將 targetSum 帶入參數，並且會慢慢扣掉，當 扣掉的值 == 0 且在 leaf 節點
     *
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return pathSum(root, targetSum);
        }

        private boolean pathSum(TreeNode node, int currentSum) {
            int remain = currentSum - node.val;
            if (node.left == null && node.right == null) {
                return remain == 0;
            }

            boolean left = (node.left != null) ? pathSum(node.left, remain) : false;
            boolean right = (node.right != null) ? pathSum(node.right, remain) : false;

            return left || right;
        }
    }
}
