package binarytree;

import binarytree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199.https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/12 11:30:31
 * @since JDK8.0
 */
public class Binary_Tree_Right_Side_View_199 {
    public static void main(String[] args) {
        Binary_Tree_Right_Side_View_199 s = new Binary_Tree_Right_Side_View_199();
        Binary_Tree_Right_Side_View_199.Solution solution = s.new Solution();

        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 7  X
        //    / \
        //   8   X
        // return [1, 3, 7, 8]
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), null));
        t1.right = new TreeNode(3, new TreeNode(7), null);

        List<Integer> result = solution.rightSideView(t1);
        System.out.println(result);
    }
    /**
     * Runtime: 1 ms, Beats 66.95%
     * 只要我跟你同 level 就更新，因為是最右邊的，所以先走 left 再走 right 最後就會是最右邊的
     */
//    class Solution {
//        private List<Integer> result = new ArrayList<>();
//
//        public List<Integer> rightSideView(TreeNode root) {
//            if (root == null) return new ArrayList<>();
//            rightSideView_dfs(root, 0);
//            return result;
//        }
//
//        private void rightSideView_dfs(TreeNode node, int level) {
//            if (node == null) return;
//            if (result.size() == 0 || result.size() <= level) {
//                result.add(node.val);
//            } else {
//                result.remove(level);
//                result.add(level, node.val);
//            }
//            rightSideView_dfs(node.left, level + 1);
//            rightSideView_dfs(node.right, level + 1);
//        }
//    }

    /**
     * Runtime0msBeats100.00%
     * 解法:
     * 這題就是DFS + preorder
     * 從 right 開始，先看到先記錄，若沒有則繼續往左找
     * 厲害的是用 list.size() 判斷是否為第一次進這一層
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            rightSideView_helper(root, result, 0);
            return result;
        }

        private void rightSideView_helper(TreeNode node, List<Integer> result, int level) {
            if (node == null)
                return;

            if (level == result.size()) {
                result.add(node.val);
            }

            rightSideView_helper(node.right, result, level + 1);
            rightSideView_helper(node.left, result, level + 1);
        }
    }
}
