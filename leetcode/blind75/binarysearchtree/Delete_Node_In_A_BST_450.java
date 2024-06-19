package binarysearchtree;

import binarytree.dfs.TreeNode;

/**
 * 450.https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/12 15:54:33
 * @since JDK8.0
 */
public class Delete_Node_In_A_BST_450 {
    public static void main(String[] args) {
        Delete_Node_In_A_BST_450 s = new Delete_Node_In_A_BST_450();
        Delete_Node_In_A_BST_450.Solution solution = s.new Solution();

        //      5
        //    /   \
        //   2     7
        //  / \    /
        // 1   3  6
        //      \
        //       4
//        TreeNode t = new TreeNode(5);
//        t.left = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
//        t.right = new TreeNode(7, new TreeNode(6), null);
//        int val = 2; // delete with children
//        int val = 3; // delete without left
//        int val = 7; // delete without right
//        int val = 1; // delete without children

        TreeNode t = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        int val = 5;

        TreeNode result = solution.deleteNode(t, val);

        System.out.println(result);
    }

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (key == root.val) {
                // delete with children
                // 找到右側最小(A)
                // 把最小(A)更新到 root
                // 再跑一次 deleteNode 只不過這次是刪掉最小(A)
                if (root.left != null && root.right != null) {
                    TreeNode rightMin = findRightMin(root.right);
                    root.val = rightMin.val;
                    root.right = deleteNode(root.right, rightMin.val);
                }
                // delete without left
                else if (root.left == null && root.right != null) {
                    root = root.right;
                }
                // delete without right
                else if (root.left != null && root.right == null) {
                    root = root.left;
                }
                // delete without children
                else if (root.left == null && root.right == null) {
                    root = null;
                }
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        private TreeNode findRightMin(TreeNode node) {
            if (node.left == null) return node;
            return findRightMin(node.left);
        }
    }
}
