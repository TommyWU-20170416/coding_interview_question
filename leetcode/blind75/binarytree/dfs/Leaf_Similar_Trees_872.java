package binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 872.https://leetcode.com/problems/leaf-similar-trees/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 17:44:34
 * @since JDK8.0
 */
public class Leaf_Similar_Trees_872 {
    public static void main(String[] args) {
        Leaf_Similar_Trees_872 s = new Leaf_Similar_Trees_872();
        Leaf_Similar_Trees_872.Solution solution = s.new Solution();

        TreeNode node5L = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode node1L = new TreeNode(1, new TreeNode(9), new TreeNode(8));
        TreeNode root1 = new TreeNode(3, node5L, node1L);

        /**
         * -------3
         * ----5     1
         * --6  2  9  8
         * ----7 4
         *
         *
         * -------3
         * ----5     1
         * --6  7  4  2
         * ----------9 8
         */
        TreeNode node5R = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        TreeNode node1R = new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8)));
        TreeNode root2 = new TreeNode(3, node5R, node1R);

        boolean result = solution.leafSimilar(root1, root2);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     */
//    class Solution {
//        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//            List<Integer> list1 = new ArrayList<>();
//            List<Integer> list2 = new ArrayList<>();
//
//            // dfs to search the final leave
//            recordLeaves(root1, list1);
//            recordLeaves(root2, list2);
//
//            // compare list1 and list2
//            if (list1.size() != list2.size()) return false;
//            return list1.equals(list2);
//        }
//
//        private void recordLeaves(TreeNode node, List<Integer> list) {
//            if (node == null) return;
//            recordLeaves(node.left, list);
//            recordLeaves(node.right, list);
//            if (node.left == null && node.right == null) list.add(node.val);
//        }
//    }
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = leafStructure(root1, new ArrayList<Integer>());
            List<Integer> list2 = leafStructure(root2, new ArrayList<Integer>());

            return list1.equals(list2);
        }

        private List<Integer> leafStructure(TreeNode node, List<Integer> list) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }

            if (node.left != null) {
                leafStructure(node.left, list);
            }

            if (node.right != null) {
                leafStructure(node.right, list);
            }

            return list;
        }
    }
}
