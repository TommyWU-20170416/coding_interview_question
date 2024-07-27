package binarytree;

import tree.TreeNode;

/**
 * 543.https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/27 11:43:15
 * @since JDK8.0
 */
public class Diameter_of_Binary_Tree_543 {
    public static void main(String[] args) {
        Diameter_of_Binary_Tree_543 ss = new Diameter_of_Binary_Tree_543();
        Diameter_of_Binary_Tree_543.Solution solution = ss.new Solution();

        /**
         * 滿 binary tree
         * -----1
         * --2
         * -4 5
         */
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        TreeNode root = new TreeNode(1, node2, null);

        /**
         * 有缺陷的 binary tree
         * ----1
         * --2
         */
//        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result);
    }


    /**
     * Runtime: 0 ms, Beats 100.00%
     * 這題跟 Maximum_Depth_Of_Binary_Tree_104 都是利用計算該 level 高度去獲取答案
     * 這題可以先把 小區域內的 Diameter 算出來，再跟 maxDiameter 相比
     * Ex:
     * ------1
     * ----2
     * --4  5
     * ----6  7
     * 計算 (5) 的時候，不管是走 6 或 7 都是 1 步，maxDiameter(0, 1 + 1) 也就是 2， (5)>(6)>(7) or (7)>(6)>(5) 都是 2 步
     * 計算 (4) 的時候，因為本身是葉節點，所以 return 1 給 (2)，此時 (2) 會有 leftHeight = 1, rightHeight = 2, maxDiameter(2, 1 + 2) = 3
     */
    class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            int max = diameterOfBinaryTree_dfs(root);
            return maxDiameter;
        }

        private int diameterOfBinaryTree_dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = diameterOfBinaryTree_dfs(node.left);
            int rightHeight = diameterOfBinaryTree_dfs(node.right);

            maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

            // 返回當前節點的高度
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
