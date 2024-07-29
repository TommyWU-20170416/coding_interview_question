package binarytree.dfs;

/**
 * 1448.https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 17:44:57
 * @since JDK8.0
 */
public class Count_Good_Nodes_In_Binary_Tree_1448 {
    public static void main(String[] args) {
        Count_Good_Nodes_In_Binary_Tree_1448 s = new Count_Good_Nodes_In_Binary_Tree_1448();
        Count_Good_Nodes_In_Binary_Tree_1448.Solution solution = s.new Solution();

        /**
         * ----- 1
         * ---2    3
         * -4  5  6
         */
//        TreeNode t1 = new TreeNode(1);
//        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//        t1.right = new TreeNode(3, new TreeNode(6), null);

        /**
         * ------- 2
         * ------    4
         * -----  10    8
         * ----       4
         */
        TreeNode t1 = new TreeNode(2, null, new TreeNode(4, new TreeNode(10), new TreeNode(8, new TreeNode(4), null)));

        int result = solution.goodNodes(t1);
        System.out.println(result);
    }

    /**
     * test1
     * 解法:
     * 使用 DFS 在進去子節點之前先記錄最大值，並且比對是否比自己小
     * 每一次子節點比對後，如果 >= 上一次的 max 就 count++ 而且要更新 maxVal
     * 主要目的是讓後面知道要多大才可以滿足條件
     * <p>
     * 若沒有更新 maxVal 在案例 2 就會出錯
     */
//    class Solution {
//        public int goodNodes(TreeNode node) {
//            if (node == null) return 0;
//            return goodNodes_dfs(node, node.val);
//        }
//
//        private int goodNodes_dfs(TreeNode node, int maxVal) {
//            if (node == null) return 0;
//            int count = 0;
//            if (node.val >= maxVal) {
//                count++;
//                maxVal = node.val;
//            }
//            int leftCount = goodNodes_dfs(node.left, maxVal);
//            count += leftCount;
//
//            int rightCount = goodNodes_dfs(node.right, maxVal);
//            count += rightCount;
//
//            return count;
//        }
//    }


    /**
     * Runtime: 1 ms, Beats 100.00%
     * test2
     * 解法:
     * 因為 test1 作法每一次都會多算 最後一個子節點的 null 判斷，所以提早作業
     */
    class Solution {
        public int goodNodes(TreeNode node) {
            if (node == null) return 0;
            return goodNodes_dfs(node, node.val);
        }

        private int goodNodes_dfs(TreeNode node, int maxVal) {
            int count = 0;
            if (node.val >= maxVal) {
                count = 1;
                maxVal = node.val;
            }
            if (node.left != null) count += goodNodes_dfs(node.left, maxVal);
            if (node.right != null) count += goodNodes_dfs(node.right, maxVal);
            return count;
        }
    }
}
