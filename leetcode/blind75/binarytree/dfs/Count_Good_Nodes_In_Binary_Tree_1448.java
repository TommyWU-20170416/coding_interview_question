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

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(6), null);

        int result = solution.goodNodes(t1);
        System.out.println(result);
    }

    class Solution {
        public int goodNodes(TreeNode node) {
            if (node == null) return 0;
            return goodNodes_find(node, node.val);
        }

        /**
         * test1
         * 解法:
         * 使用 DFS 在進去子節點之前先記錄最大值，並且比對是否比自己小
         * 每一次子節點出來後 更新 count 值
         */
//        private int goodNodes_find(TreeNode node, int maxVal) {
//            if (node == null) return 0;
//            int count = 0;
//            if (node.val >= maxVal) {
//                count = 1;
//                maxVal = node.val;
//            }
//            count += goodNodes_find(node.left, maxVal);
//            count += goodNodes_find(node.right, maxVal);
//            return count;
//        }

        /**
         * test2
         * 解法:
         * 因為 test1 作法每一次都會多算 最後一個子節點的 null 判斷，所以提早作業
         */
        private int goodNodes_find(TreeNode node, int maxVal) {
            int count = 0;
            if (node.val >= maxVal) {
                count = 1;
                maxVal = node.val;
            }
            if (node.left != null) count += goodNodes_find(node.left, maxVal);
            if (node.right != null) count += goodNodes_find(node.right, maxVal);
            return count;
        }
    }
}
