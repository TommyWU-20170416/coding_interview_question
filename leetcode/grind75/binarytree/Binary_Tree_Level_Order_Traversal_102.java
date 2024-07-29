package binarytree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102.https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/27 13:16:03
 * @since JDK8.0
 */
public class Binary_Tree_Level_Order_Traversal_102 {
    public static void main(String[] args) {
        Binary_Tree_Level_Order_Traversal_102 ss = new Binary_Tree_Level_Order_Traversal_102();
        Binary_Tree_Level_Order_Traversal_102.Solution solution = ss.new Solution();

        /**
         * 滿 binary tree
         * ----1
         * -- 2
         * - 4  5
         * -   6 7
         */
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        TreeNode root = new TreeNode(1, node2, null); // Output: [[1],[2],[4,5]]


        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     */
//    class Solution {
//        private List<List<Integer>> result = new ArrayList<>();
//
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            if (root == null) return result;
//            levelOrder_dfs(root, 0);
//            return result;
//        }
//
//        private void levelOrder_dfs(TreeNode node, int level) {
//            if (node == null) return;
//            if (result.size() == 0 || result.size() <= level) {
//                List<Integer> list = new ArrayList<>();
//                list.add(node.val);
//                result.add(list);
//            } else {
//                result.get(level).add(node.val);
//            }
//            levelOrder_dfs(node.left, level + 1);
//            levelOrder_dfs(node.right, level + 1);
//        }
//    }

    /**
     * 換寫法: 把 list 寫進去 dfs(list) 內，但 dfs 還是 void
     * 實測
     * 這樣寫空間沒有比較少，相對的可能還會比較多，因為等於每次 dfs 都要多帶一個
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return new ArrayList<>();
            levelOrder_dfs(root, 0, result);
            return result;
        }

        private void levelOrder_dfs(TreeNode node, int level, List<List<Integer>> result) {
            if (node == null) return;
            if (result.size() == level) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                result.add(list);
            } else {
                result.get(level).add(node.val);
            }
            levelOrder_dfs(node.left, level + 1, result);
            levelOrder_dfs(node.right, level + 1, result);
        }
    }
}
