package tree;

/**
 *
 * @author AaronWU
 * @version 創建時間：2021年7月3日 下午5:20:34
 * @since JDK8.0
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
