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

        /**
         * ------ 1
         * ---- /
         * ----2     3
         * --  \
         * -- 4 5   6
         * ---  /
         * -   7 8
         */
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8)));
        t1.right = new TreeNode(3, new TreeNode(6), null);

        int result = solution.longestZigZag(t1);
        System.out.println(result);
    }


    /**
     * Runtime: 4 ms, Beats 96.71%。不知道為什麼下面的比較快，但 boolean 我覺得比較好董，而且 boolean = 1 bit, char = 1 byte
     * 使用 true false 去決定左或右
     * 若重新走過就要將 length 歸零.
     * 重新走另一條新的會從 1 開始是因為，跳到下一次 function 後 node 就已經是下一個了，所以先給 1
     */
    class Solution {
        private int maxLen = 0;

        public int longestZigZag(TreeNode root) {
            if (root.left != null) longestZigZag_dfs(root, true, 0);
            if (root.right != null) longestZigZag_dfs(root, false, 0);
            return maxLen;
        }

        public void longestZigZag_dfs(TreeNode node, boolean isLeft, int sumLen) {
            maxLen = Math.max(sumLen, maxLen);
            if (isLeft) {
                if (node.left != null) longestZigZag_dfs(node.left, false, sumLen + 1);
                if (node.right != null) longestZigZag_dfs(node.right, true, 1);
            } else {
                if (node.right != null) longestZigZag_dfs(node.right, true, sumLen + 1);
                if (node.left != null) longestZigZag_dfs(node.left, false, 1);
            }
        }
    }

    /**
     * test2
     * Runtime: 3 ms, Beats 99.44%
     * 解法:
     * 簡化寫法，也減少最後一層的判斷
     */
//    class Solution {
//        int maxLength = 0;
//
//        public int longestZigZag(TreeNode root) {
//            if (root == null) return 0;
//
//            if (root.left != null) longestZigZag_helper(root.left, 'L', 1);
//            if (root.right != null) longestZigZag_helper(root.right, 'R', 1);
//            return maxLength;
//        }
//
//        private void longestZigZag_helper(TreeNode node, char goLeft, int count) {
//            maxLength = Math.max(maxLength, count);
//            if (goLeft == 'L') {
//                if (node.left != null) {
//                    longestZigZag_helper(node.left, 'L', 1);
//                }
//                if (node.right != null) {
//                    longestZigZag_helper(node.right, 'R', ++count);
//                }
//            } else {
//                if (node.right != null) {
//                    longestZigZag_helper(node.right, 'R', 1);
//                }
//                if (node.left != null) {
//                    longestZigZag_helper(node.left, 'L', ++count);
//                }
//            }
//        }
//    }
}
