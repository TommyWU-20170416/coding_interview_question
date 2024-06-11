package binarytree.dfs;

/**
 * 1372.https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/06 16:53:29
 * @since JDK8.0
 */
public class Longest_ZigZag_Path_In_A_Binary_Tree_1372 {
    public static void main(String[] args) {
        Longest_ZigZag_Path_In_A_Binary_Tree_1372 s = new Longest_ZigZag_Path_In_A_Binary_Tree_1372();
        Longest_ZigZag_Path_In_A_Binary_Tree_1372.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8)));
        t1.right = new TreeNode(3, new TreeNode(6), null);

        int result = solution.longestZigZag(t1);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 true false 去決定左或右
         * 若重新走過就要將 length 歸零
         */
//        public int longestZigZag(TreeNode root) {
//            if (root == null) return 0;
//            int[] maxLength = new int[1];
//            longestZigZag_helper(root, true, 0, maxLength);
//            longestZigZag_helper(root, false, 0, maxLength);
//
//            return maxLength[0];
//        }
//
//        private void longestZigZag_helper(TreeNode node, boolean isLeft, int length, int[] maxLength) {
//            if (node == null) return;
//
//            maxLength[0] = Math.max(maxLength[0], length);
//
//            if (isLeft) {
//                longestZigZag_helper(node.left, false, length + 1, maxLength);
//                longestZigZag_helper(node.right, true, 1, maxLength);
//            } else {
//                longestZigZag_helper(node.right, true, length + 1, maxLength);
//                longestZigZag_helper(node.left, false, 1, maxLength);
//            }
//        }

        /**
         * test2
         * 解法:
         * 簡化寫法，也減少最後一層的判斷
         */
        int maxLength = 0;

        public int longestZigZag(TreeNode root) {
            if (root == null) return 0;

            if (root.left != null) longestZigZag_helper(root.left, 'L', 1);
            if (root.right != null) longestZigZag_helper(root.right, 'R', 1);
            return maxLength;
        }

        private void longestZigZag_helper(TreeNode node, char goLeft, int count) {
            maxLength = Math.max(maxLength, count);
            if (goLeft == 'L') {
                if (node.left != null) {
                    longestZigZag_helper(node.left, 'L', 1);
                }
                if (node.right != null) {
                    longestZigZag_helper(node.right, 'R', ++count);
                }
            } else {
                if (node.right != null) {
                    longestZigZag_helper(node.right, 'R', 1);
                }
                if (node.left != null) {
                    longestZigZag_helper(node.left, 'L', ++count);
                }
            }
        }
    }
}
