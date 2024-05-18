package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94.https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @author AaronWU
 * @version 創建時間：2021年7月3日 下午5:28:51
 * @since JDK8.0
 */
public class Binary_Tree_Inorder_Traversal_94 {
    /* root = [1,null,2,3] */
    public static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

    public static void main(String[] args) {
        Binary_Tree_Inorder_Traversal_94 test = new Binary_Tree_Inorder_Traversal_94();
        List<Integer> list = test.inorderTraversal(root);
        printList(list);
    }

    private static void printList(List<Integer> list) {
        System.out.print("[ ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    /**
     * Runtime :0 ms, faster than 100.00%
     * Memory Usage : 37.1 MB, less than 72.27%
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (null != curr || !stack.isEmpty()) {
            while (null != curr) { /* 如果不等於空，就繼續左邊下去，直到找到為止 */
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 使用迭代方式，先取到左邊之後，再取中間，最後再取右邊，較為簡單
     * Runtime :0 ms, faster than 100.00%
     * Memory Usage : 37.4 MB, less than 42.08%
     *
     * @param root
     * @return
     */
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		inorder(res, root);
//		return res;
//	}
//
//	private void inorder(List<Integer> res, TreeNode root) {
//		if (null == root)
//			return;
//		inorder(res, root.left);
//		res.add(root.val);
//		inorder(res, root.right);
//	}
}
