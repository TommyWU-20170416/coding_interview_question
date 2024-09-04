package binarysearchtree;

import binarytree.dfs.TreeNode;

/**
 * 700.https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/12 15:31:20
 * @since JDK8.0
 */
public class Search_In_A_Binary_Search_Tree_700 {
    public static void main(String[] args) {
        Search_In_A_Binary_Search_Tree_700 s = new Search_In_A_Binary_Search_Tree_700();
        Search_In_A_Binary_Search_Tree_700.Solution solution = s.new Solution();

        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3
        TreeNode t = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        int val = 1;
        TreeNode result = solution.searchBST(t, val);

        System.out.println(result);


    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 解法:
         * BST 優點是左小右大
         * 可以比較當前的數值去決定要左邊還是右邊
         * 這樣會更快，也減少判斷
         */
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val)
                return root;

            if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }
}
