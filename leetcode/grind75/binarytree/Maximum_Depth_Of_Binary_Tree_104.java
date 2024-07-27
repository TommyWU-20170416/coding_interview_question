package binarytree;

import tree.TreeNode;

/**
 * 104.https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/27 12:44:57
 * @since JDK8.0
 */
public class Maximum_Depth_Of_Binary_Tree_104 {
    public static void main(String[] args) {
        Maximum_Depth_Of_Binary_Tree_104 ss = new Maximum_Depth_Of_Binary_Tree_104();
        Maximum_Depth_Of_Binary_Tree_104.Solution solution = ss.new Solution();

        /**
         * 滿 binary tree
         * -----1
         * ---2
         * -4  5
         * ---6
         */
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6, new TreeNode(7), new TreeNode(8)), null));
        TreeNode root = new TreeNode(1, node2, null);

        /**
         * 有缺陷的 binary tree
         * ----1
         * --2
         */
//        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        int result = solution.maxDepth(root);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 每一層都會回傳該 level，因此只要每一層都去找左右 max 就可以知道最後的 node 數
     */
    class Solution {
        /**
         * 這題
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return maxDepth_dfs(root);
        }

        private int maxDepth_dfs(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = maxDepth_dfs(node.left);
            int rightHeight = maxDepth_dfs(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
