package binarysearchtree;

import binarytree.dfs.TreeNode;

/**
 * 235.https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/31 16:38:02
 * @since JDK8.0
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
    public static void main(String[] args) {
        Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 s = new Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235();
        Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235.Solution solution = s.new Solution();


        TreeNode t5 = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode t1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode t = new TreeNode(3, t5, t1);

        TreeNode p = t5, q = t5.right;

        TreeNode result = solution.lowestCommonAncestor(t, p, q);
        System.out.println(result.val);
    }


    class Solution {
        /**
         * Runtime: 6 ms, Beats 30.12%
         * 使用跟 236 一樣的解法
         */
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            if (root == null) return null;
//            if (root == p || root == q) {
//                return root;
//            }
//            TreeNode left = lowestCommonAncestor(root.left, p, q);
//            TreeNode right = lowestCommonAncestor(root.right, p, q);
//            if (left != null && right != null) {
//                return root;
//            } else if (left == null) {
//                return right;
//            } else {
//                return left;
//            }
//        }

        /**
         * Runtime: 5 ms, Beats 100.00%
         * 前提是 binary search tree 左小右大
         * 如果是這樣 p < root < q 代表在左右，直接 return root
         * 如果是這樣 p < q < root 或是 root < p < q 那就繼續找，直到找到為止
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            return root;
        }
    }
}
