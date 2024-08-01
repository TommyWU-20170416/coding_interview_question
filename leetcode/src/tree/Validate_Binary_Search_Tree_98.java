package tree;

/**
 * 98.https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/22 16:09:07
 * @since JDK8.0
 */
public class Validate_Binary_Search_Tree_98 {
    public static void main(String[] args) {
        Validate_Binary_Search_Tree_98_Solution solution = new Validate_Binary_Search_Tree_98_Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, node1, node3);
        boolean result = solution.isValidBST(root);

        /**
         * ----5
         * -1    6
         * X X 8 X 7
         */
        TreeNode node5 = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(8), new TreeNode(7)));
        boolean result5 = solution.isValidBST(node5);

        System.out.println();
    }
}


/**
 * Runtime: 0 ms, Beats 100.00%
 * test2
 * 使用 recursive 調整每一次的 min, max
 * ----5
 * -1    6
 * X X 8 X 7
 * 第一次找 5 是否介於 -9223372036854775808 (-2^63) ~ 9223372036854775807 (2^63 - 1)
 * 第二次找 1 是否介於 -9223372036854775808         ~ 5
 * 第三次找 6 是否介於                    5         ~ 9223372036854775807 (2^63 - 1)
 * 第四次找 8 是否介於                    5         ~ 6
 * 發現不是，就返回 false
 */
class Validate_Binary_Search_Tree_98_Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

    private boolean helper(TreeNode root, long min, long max) {
        if (root != null) System.out.println(root.val + " 是否介於 " + min + " ~ " + max);
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}