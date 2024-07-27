package binarytree;

import linkedlist.ListNode;
import tree.TreeNode;

/**
 * 226.https://leetcode.com/problems/invert-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/27 09:53:29
 * @since JDK8.0
 */
public class Invert_Binary_Tree_226 {
    public static void main(String[] args) {
        Invert_Binary_Tree_226 ss = new Invert_Binary_Tree_226();
        Invert_Binary_Tree_226.Solution solution = ss.new Solution();

        /**
         * 滿 binary tree
         * -----4
         * --2     7
         * -4 7   6 9
         */
//        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(7));
//        TreeNode node7 = new TreeNode(7, new TreeNode(6), new TreeNode(9));
//        TreeNode root = new TreeNode(4, node2, node7);

        /**
         * 有缺陷的 binary tree
         * ----1
         * --2
         */
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        TreeNode result = solution.invertTree(root);
        System.out.println(result);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 使用 dfs 找出 left & right 並使用 postorder
         * 因為使用 postorder 表示 left 跟 right 都已經看過回到 上一層
         * 這題要考慮 不完整 binary tree，不管是交換前還是交換後
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            invertTree_dfs(root);
            return root;
        }

        private void invertTree_dfs(TreeNode node) {
            if (node == null) return;
            invertTree_dfs(node.left);
            invertTree_dfs(node.right);

            if (node.left == null && node.right == null) {
                return;
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}
