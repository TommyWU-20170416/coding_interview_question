package binarysearchtree;

import binarytree.dfs.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 230.https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/31 17:52:04
 * @since JDK8.0
 */
public class Kth_Smallest_Element_in_a_BST_230 {
    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_BST_230 s = new Kth_Smallest_Element_in_a_BST_230();
        Kth_Smallest_Element_in_a_BST_230.Solution solution = s.new Solution();

        /**
         * ------- 5
         * ---- 3    6
         * -- 2  4
         * - 1
         */
        TreeNode t2 = new TreeNode(2, new TreeNode(1), null);
        TreeNode t3 = new TreeNode(3, t2, new TreeNode(4));
        TreeNode root = new TreeNode(5, t3, new TreeNode(6));

        int result = solution.kthSmallest(root, 6);
        System.out.println(result);
    }

    /**
     * Runtime: 2 ms, Beats 10.43%
     * 把所有 node 跑一遍放進去 PriorityQueue 善用他的由小到大排序
     * 挑出第 k - 1 的 val(因為 k 是 1-index)
     */
//    class Solution {
//        public int kthSmallest(TreeNode root, int k) {
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            kthSmallest_dfs(root, pq);
//            int size = pq.size();
//            for (int i = 0; i < size; i++) {
//                if (i == k - 1) {
//                    return pq.peek();
//                }
//                pq.poll();
//            }
//            return 0;
//        }
//
//        private void kthSmallest_dfs(TreeNode node, PriorityQueue<Integer> pq) {
//            if(node == null) return;
//            pq.add(node.val);
//            kthSmallest_dfs(node.left, pq);
//            kthSmallest_dfs(node.right, pq);
//        }
//    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 使用 Deque 的 addFirst(push) 特性
     * 因為 BST 所以 left 一路往下並且 push dequq
     * 接著當到底的時候 取 first 出來，然後去看是否為 k - 1 個
     * 如果不是就開始往右找
     * <p>
     * 第一次 dq: 5
     * 第二次 dq: 3 5
     * 第三次 dq: 2 3 5
     * 第四次 dq: 1 2 3 5
     * 左邊沒有了，開始 pop 看是否為第 k - 1 個。如果 k = 6
     * <p>
     * pop: 1 不是第 5 個，去看 1 的 right
     * 1 的 right 沒東西，dq 還有東西
     * pop: 2 不是第 5 個，去看 2 的 right
     * 2 的 right 沒東西，dq 還有東西
     * pop: 3 不是第 5 個，去看 3 的 right
     * <p>
     * 3 的 right 有 4 把 4 放進去，在往下沒有了   dq: 4 5
     * pop: 4 不是第 5 個，去看 4 的 right
     * 4 的 right 沒東西，dq 還有東西            dq: 5
     * pop: 5 不是第 5 個，去看 5 的 right
     * <p>
     * 5 的 right 有 6 把 6 放進去，在往下沒有了 dq: 6
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
//            int count = 0;
//            TreeNode curr = root;
//            Deque<TreeNode> dq = new ArrayDeque<>();
//
//            while (curr != null || !dq.isEmpty()) {
//                while (curr != null) {
//                    dq.push(curr); // push 是 addFirst 因為一直 left 所以大的會往後退
//                    curr = curr.left;
//                }
//
//                curr = dq.pop();
//                if (count++ == k - 1) return curr.val;
//
//                curr = curr.right;
//            }
//            return -1;
            Deque<TreeNode> dq = new ArrayDeque<>();
            TreeNode curr = root;
            int count = 0;

            while (curr != null || !dq.isEmpty()) {
                while (curr != null) {
                    dq.push(curr);
                    curr = curr.left;
                }
                curr = dq.pop();
                if (count++ == k - 1) return curr.val;

                curr = curr.right;
            }
            return -1;
        }
    }
}
