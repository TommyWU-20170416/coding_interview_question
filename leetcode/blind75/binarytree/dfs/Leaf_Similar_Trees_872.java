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

//        TreeNode t1 = new TreeNode(1);
//        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//        t1.right = new TreeNode(3, new TreeNode(6), null);

        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(200));

        boolean result = solution.leafSimilar(t1, t1);
        System.out.println(result);
    }

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            // dfs to search the final leave
            recordLeaves(root1, list1);
            recordLeaves(root2, list2);

            // compare list1 and list2
            if (list1.size() != list2.size()) return false;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).equals(list2.get(i))) return false;
            }
            return true;
        }

        private void recordLeaves(TreeNode node, List<Integer> list) {
            if (node == null) return;
            recordLeaves(node.left, list);
            recordLeaves(node.right, list);
            if (node.left == null && node.right == null) list.add(node.val);
        }
    }
}
