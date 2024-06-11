package binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 236.https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/06/11 16:06:04
 * @since JDK8.0
 */
public class Lowest_Common_Ancestor_Of_A_Binary_Tree_236 {
    public static void main(String[] args) {
        Lowest_Common_Ancestor_Of_A_Binary_Tree_236 s = new Lowest_Common_Ancestor_Of_A_Binary_Tree_236();
        Lowest_Common_Ancestor_Of_A_Binary_Tree_236.Solution solution = s.new Solution();


        TreeNode t5 = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode t1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode t = new TreeNode(3, t5, t1);

        TreeNode p = new TreeNode(5), q = new TreeNode(1);

        TreeNode result = solution.lowestCommonAncestor(t, t.left.right, t.left);
        System.out.println(result.val);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 記錄根節點到 p 以及 q 的路徑
         * 找到後會有兩個陣列紀錄資訊
         * 比對這兩個陣列第一個分歧點之前的 node 就是 LCA
         * <p>
         * -----3
         * ---/   \
         * --5     1
         * -/ \   / \
         * 6  2  0  8
         * --/ \
         * -7  4
         * <p>
         * 假設 p = 5, q = 4
         * p = 5, arrayP = [3, 5]
         * q = 4, arrayQ = [3, 5, 2, 4]
         * 5 就是LCA
         */
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            List<TreeNode> listP = new ArrayList<>(), listQ = new ArrayList<>();
//            findPath(root, p, listP);
//            findPath(root, q, listQ);
//
//            TreeNode result = findLCA(listP, listQ);
//            return result;
//        }
//
//        private TreeNode findLCA(List<TreeNode> listP, List<TreeNode> listQ) {
//            int length = Math.min(listP.size(), listQ.size());
//            for (int i = 0; i < length; i++) {
//                if (listP.get(i).val != listQ.get(i).val) {
//                    return listP.get(i - 1);
//                }
//            }
//            return listP.get(length - 1);
//        }
//
//        private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> list) {
//            /**
//             * Q:不知道什麼時候才是要讓 TreeNode 加入到 list
//             * A:就是都加，阿如果最後發現不是就移除
//             */
//            if (root == null)
//                return false;
//            list.add(root);
//
//            if (root.val == target.val)
//                return true;
//
//            if (findPath(root.left, target, list))
//                return true;
//
//            if (findPath(root.right, target, list))
//                return true;
//
//            list.remove(list.size() - 1);
//            return false;
//        }

        /**
         * test2
         * 解法:
         * 此題目會有三種情境
         * 1. p 或 q 分別存在於 root 的左節點或右節點
         * 2. p 或 q 都存在於 root 的左節點
         *      如果都在左邊，就看誰先被找到，找到的那一個就是 LCA
         * 3. p 或 q 都存在於 root 的右節點
         *      如果都在右邊，就看誰先被找到，找到的那一個就是 LCA
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return find(root, p, q);
        }

        private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;

            TreeNode left = find(root.left, p, q);
            TreeNode right = find(root.right, p, q);

            if (left != null && right != null) return root;

            if (left != null) return left;

            if (right != null) return right;

            return null;
        }
    }
}
