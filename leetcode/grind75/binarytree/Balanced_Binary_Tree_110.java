package binarytree;

import tree.TreeNode;

/**
 * 110.https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/27 10:48:29
 * @since JDK8.0
 */
public class Balanced_Binary_Tree_110 {
    public static void main(String[] args) {
        Balanced_Binary_Tree_110 ss = new Balanced_Binary_Tree_110();
        Balanced_Binary_Tree_110.Solution solution = ss.new Solution();

        /**
         * 滿 binary tree
         * -----1
         * --2
         * -4 5
         */
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode root = new TreeNode(1, node2, null);

        /**
         * 有缺陷的 binary tree
         * ----1
         * --2
         */
//        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        boolean result = solution.isBalanced(root);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 這題跟 Maximum_Depth_Of_Binary_Tree_104 都是利用計算該 level 高度去獲取答案
     * 高度差在 1 以內的就是 height-balanced
     * 在葉節點都是 null 的時候去檢查是否跟 max 一樣或是比較小
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return isBalanced_dfs(root) != -1;
        }

        private int isBalanced_dfs(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = isBalanced_dfs(node.left);
            int rightHeight = isBalanced_dfs(node.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
