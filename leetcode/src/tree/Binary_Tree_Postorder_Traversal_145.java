package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @author AaronWU
 * @version 創建時間：2021年7月4日 下午5:08:10
 * @since JDK8.0
 */
public class Binary_Tree_Postorder_Traversal_145 {
    /* root = [1,null,2,3] */
    public static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

    public static void main(String[] args) {
        Binary_Tree_Postorder_Traversal_145 test = new Binary_Tree_Postorder_Traversal_145();
        printList(test.postorderTraversal(root));
    }

    private static void printList(List<Integer> list) {
        System.out.print("[ ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res = postorder(root, res);
        return res;

    }

    private List<Integer> postorder(TreeNode root, List<Integer> res) {
        if (null == root) return res;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);

        return res;
    }
}
