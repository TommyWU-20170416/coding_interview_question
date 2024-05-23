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

        /**
         * ----5
         * -1    6
         * X X 8 X 7
         */
        TreeNode node5 = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(8), new TreeNode(7)));


        boolean result = solution.isValidBST(root);
        boolean result5 = solution.isValidBST(node5);
        System.out.println();
    }
}

class Validate_Binary_Search_Tree_98_Solution {

    /** test1 */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return false;
//        return isValidBST_Checker(root);
//    }
//
//    private boolean isValidBST_Checker(TreeNode node) {
//        if (node == null) return true;
//        boolean result = true;
//
//        // find the left  node max < root.val
//        if (node.left != null) {
//            TreeNode left_node_max = getMax(node.left);
//            if (left_node_max.val >= node.val) return false;
//        }
//        // find the right node min < root.val
//        if (node.right != null) {
//            TreeNode right_node_min = getMin(node.right);
//            if (right_node_min.val <= node.val) return false;
//        }
//
//        // check every layer
//        boolean result_left = isValidBST_Checker(node.left);
//        if (result_left == false) result = false;
//        boolean result_right = isValidBST_Checker(node.right);
//        if (result_right == false) result = false;
//
//        return result;
//    }
//
//    private TreeNode getMin(TreeNode node) {
//        if (node == null) return null;
//        while (true) {
//            if (node.left == null) break;
//            node = node.left;
//        }
//        return node;
//    }
//
//    private TreeNode getMax(TreeNode node) {
//        if (node == null) return null;
//        while (true) {
//            if (node.right == null) break;
//            node = node.right;
//        }
//        return node;
//    }

    /**
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