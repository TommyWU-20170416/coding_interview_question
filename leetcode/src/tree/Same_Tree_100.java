package tree;

/**
 * 100.https://leetcode.com/problems/same-tree/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/20 15:09:33
 * @since JDK8.0
 */
public class Same_Tree_100 {
    public static void main(String[] args) {
        // 兩層 tree
//        TreeNode tree2 = new TreeNode(2);
//        TreeNode tree3 = new TreeNode(3);
//        TreeNode tree4 = new TreeNode(4);
//        TreeNode tree5 = new TreeNode(5);

//        TreeNode p = new TreeNode(1, tree2, tree3);
//        TreeNode q = new TreeNode(1, tree4, tree3);
//        TreeNode q = new TreeNode(1, tree2, tree3); // isSameTree: true
//        TreeNode q = new TreeNode(1, tree4, tree5); // isSameTree: false

        // 三層 tree
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        TreeNode tree2p = new TreeNode(2, tree4, tree5);
        TreeNode tree2q = new TreeNode(2, tree5, tree5);
        TreeNode tree3 = new TreeNode(3);

        TreeNode p = new TreeNode(1, tree2p, tree3);
        TreeNode q = new TreeNode(1, tree2q, tree3);

        Solution s = new Solution();
        System.out.println("isSameTree: " + s.isSameTree(p, q));
    }
}

class Solution {

    /**
     * test1
     */
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        /** 當有任意 null 處理，判斷是否已經到最後的節點 */
//        if (p == null && q == null) return true;
//        if (p == null && q != null) return false;
//        if (p != null && q == null) return false;
//        System.out.println("現在檢查 p: " + p.val + ", q: " + q.val);
//
//        /** init reuslt */
//        boolean result = true;
//
//        if (p.val != q.val) {
//            result = false;
//        } else {
//            boolean result_left = isSameTree(p.left, q.left);
//            if (result_left == false) result = false;
//            /** 有 false 再更新，否則會被 result_right 蓋掉 */
//            boolean result_right = isSameTree(p.right, q.right);
//            if (result_right == false) result = false;
//        }
//        return result;
//    }

    /**
     * test2
     * <ul> 修改原因 </ul>
     * 為了讓發現第一個不一樣就馬上 retuen，改寫內容
     * 如果 node 都是 null 代表一樣
     * 如果有一個 node 是 null 代表不一樣
     * 如果左右 val 不一樣就返回，一樣就繼續往下看左右
     * <p>
     * 最後要兩個都是 true 才 return true
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}