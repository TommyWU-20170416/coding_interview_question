package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 501.https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/29 14:34:45
 * @since JDK8.0
 */
public class Find_Mode_in_Binary_Search_Tree_501 {
    public static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));

    public static void main(String[] args) {
        Find_Mode_in_Binary_Search_Tree_501 s = new Find_Mode_in_Binary_Search_Tree_501();
        Find_Mode_in_Binary_Search_Tree_501.Solution solution = s.new Solution();

        int[] result = solution.findMode(root);
        for (int i : result) {
            System.out.print(i);
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();
        TreeNode prev = null;
        int count = 0, countMax = 0;

        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];

            findMode_helper(root);

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }

        private void findMode_helper(TreeNode node) {
            if (node == null) return;
            findMode_helper(node.left);
            // check mode number
            if (prev == null) {
                // the minimum number
                prev = node;
                count = 1;
            } else {
                if (node.val == prev.val) {
                    count++;
                } else if (node.val != prev.val) {
                    prev = node;
                    count = 1;
                }
            }
            if (count > countMax) {
                countMax = count;
                list.clear();
                list.add(prev.val);
            } else if (count == countMax) {
                list.add(prev.val);
            }

            findMode_helper(node.right);
        }
    }
}
