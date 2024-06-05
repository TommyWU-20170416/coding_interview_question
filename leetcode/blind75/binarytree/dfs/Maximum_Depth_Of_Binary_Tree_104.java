package binarytree.dfs;

/**
 * 104.https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 15:23:36
 * @since JDK8.0
 */
public class Maximum_Depth_Of_Binary_Tree_104 {
    public static void main(String[] args) {
        Maximum_Depth_Of_Binary_Tree_104 s = new Maximum_Depth_Of_Binary_Tree_104();
        Maximum_Depth_Of_Binary_Tree_104.Solution solution = s.new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        t1.right = new TreeNode(3, new TreeNode(6), null);

        int result = solution.maxDepth(t1);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 使用 DFS 去找到最左邊的深度跟最右邊的深度，並且求最大值
         */
        /**
         * 實際步驟說明
         * ------1
         * --2------3
         * 4   5  6  null
         * maxDepth => m()
         *
         * <ul>第一步</ul>
         * <li>m(1) 會去找到 m(2), m(3) ，因為找左右</li>
         *
         * <ul>第二步</ul>
         * <li>m(2) 會去找 m(4) m(5)</li>
         *
         * <ul>第三步</ul>
         * <li>m(4) 往左下找，找到 null 且往右下找也是 null，所以返回 0 </li>
         * <li>此時 leftDepth 跟 rightDepth 都是 0 ，做 Max(0,0) + 1 = 1 這邊的 1 實際上也就是加上當前的層數</li>
         * <li>m(5) 一樣推法</li>
         *
         * <ul>第四步</ul>
         * <li>收到 m(4) 跟 m(5) 返回後，此時 leftDepth 跟 rightDepth 都是 1，Max(1,1) + 1 = 2</li>
         *
         * <ul>第五步</ul>
         * <li>m(3) 會去找 m(6) m(null)</li>
         *
         * <ul>第六步</ul>
         * <li>m(6)左下跟右下都是 null ，所以返回後比較 max(0, 0) + 1 = 1</li>
         *
         * <ul>第七步</ul>
         * <li>m(3) 收到 m(6) 跟 m(null) 返回做比較 max(1, 0) + 1 = 2</li>
         * <li></li>
         *
         * <ul>第八步</ul>
         * <li>m(1) 收到 m(2) 跟 m(3) 返回比較 max(2, 1) + 1 = 3</li>
         * <li>找到最深的是 3</li>
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
