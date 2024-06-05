package binarytree.dfs;

/**
 * 437.https://leetcode.com/problems/path-sum-iii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 17:44:01
 * @since JDK8.0
 */
public class Path_Sum_III_437 {
    public static void main(String[] args) {
        Path_Sum_III_437 s = new Path_Sum_III_437();
        Path_Sum_III_437.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(3, new TreeNode(4), new TreeNode(2)));
        t1.right = new TreeNode(3, new TreeNode(4), null);
        int targetSum = 7;

        int result = solution.pathSum(t1, targetSum);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用雙 dfs 的方式去找資料
         * 第一層是 pathSum_help
         * 第二層是 pathSum
         *
         * 而且是先找完 pathSum_help(root, targetSum) 然後才再去找 root.left 跟 root.right
         * 可能會覺得這樣會少層數，因為只去看 root.left 跟 root.right，但實際上他又是一個地回，所以不用擔心
         */
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            int count = pathSum_help(root, targetSum);
            count += pathSum(root.left, targetSum);
            count += pathSum(root.right, targetSum);
            return count;
        }

        private int pathSum_help(TreeNode node, long targetSum) {
            if (node == null) return 0;
            int count = 0;
            if (targetSum == node.val)
                count++;

            count += pathSum_help(node.left, targetSum - node.val);
            count += pathSum_help(node.right, targetSum - node.val);

            return count;
        }

        /**
         * test2
         * 解法:
         * 像這種要紀錄 前墜的和，就適合 prefixSum 搭配 hashmap 去紀錄
         */
    }
}
