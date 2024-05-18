package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * @author AaronWU
 * @version 創建時間：2021年7月4日 下午4:05:43
 * @since JDK8.0
 */
public class Binary_Tree_Preorder_Traversal_144 {
    /* root = [1,null,2,3] res = [1,2,3] */
    public static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

    public static void main(String[] args) {
        Binary_Tree_Preorder_Traversal_144 test = new Binary_Tree_Preorder_Traversal_144();
        List<Integer> res = test.preorderTraversal(root);
        printList(res);
    }

    private static void printList(List<Integer> list) {
        System.out.print("[ ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    /**
     *
     *
     * Runtime :0 ms, faster than 100.00%
     * Memory Usage :  37.4 MB, less than 42.25%
     *
     * @param root
     * @return
     */
//	public List<Integer> preorderTraversal(TreeNode root) {
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		List<Integer> res = new ArrayList<Integer>();
//		TreeNode curr = root;
//		while(null != curr || !stack.isEmpty()) {
//			while(null != curr) {
//				res.add(curr.val);
//				stack.push(curr);
//				curr = curr.left;
//			}
//			curr = stack.pop().right;
//		}
//		return res;
//	}

    /**
     * 利用遞迴的方式實作，但加上if的差異減少進入遞迴，因為每進一次遞迴都是空間跟時間。
     * <p>
     * Runtime : 0 ms, faster than 100.00%
     * Memory Usage : 37.5 MB, less than 31.17%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res = preorder(root, res);
        return res;
    }

    private List<Integer> preorder(TreeNode root, List<Integer> res) {
        if (null == root) return res;
        res.add(root.val);
        if (null != root.left) preorder(root.left, res);
        if (null != root.right) preorder(root.right, res);
        return res;
    }
}