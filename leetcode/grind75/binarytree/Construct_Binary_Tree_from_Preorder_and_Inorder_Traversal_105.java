package binarytree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 ss = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105.Solution solution = ss.new Solution();

//        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 10, 8, 7}, inorder = {10, 9, 8, 3, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        System.out.println(result);
    }

    /**
     * Runtime: 1 ms, Beats 94.82%。O(n +
     * Map 儲存 Inorder 索引，查找根節點位置時能達到 O(1)
     * 解法:
     * 1. Preorder 的第一個都會是該 root，使用這個 root 去 Inorder 找左右分別會對應，左節點跟右節點
     * 2. 使用 preStart, preEnd, inStart, inEnd 去限定要找的範圍
     * 3. 最後重複此步驟直到建構完所有 node
     * <p>
     * 詳細說明: preorder = {3, 9, 20, 15, 7}, inorder  = {9, 3, 15, 20, 7}
     * <ul>
     *      <ol>
     *          <h3>(3) 找 root </h3>
     *          <li>
     *              preStart = 0, preEnd = 4, inStart = 0, inEnd = 4
     *          </li>
     *              找到 preorder[0] => root(3)，對應到 inorder(3)出現在 [1]位置，因此 leftNode 就是 9 <br />
     *
     *              <h3>(9) 開始建構左節點</h3>
     *              <li>
     *                  <u>開始建構左節點</u>
     *                  preStart = 0 + 1, preEnd = preStart + 1, inStart = 0, inEnd = 1 - 1
     *              </li>
     *              preStart: 因為要找下一個 root 所以 preStart 要 + 1 <br />
     *              preEnd  : preStart + leftTreeSize <br />
     *              inStart : 不動 <br />
     *              inEnd   : inorderIndex - 1 這樣才知道 leftNode 在 inorder 的哪個範圍 <br />
     *
     *              <h3>(9) 下去沒東西，且 start 超過 end 所以 return null</h3>
     *              (9) 會返回並且存在 root.left 而 root 就是 (3)
     *
     *          <h3>回到 (3) 繼續往右邊建構</h3>
     *          <li>
     *              preStart = 0 + 1 + 1, preEnd = 4, inStart = 0, inEnd = 4
     *          </li>
     *          preStart: 因為要找下一個 root 且要超過 leftNode 所以會是 preStart + leftTreeSize + 1 <br />
     *          preEnd  : preorder.length - 1 <br />
     *          inStart : inRootIndex + 1 也是為了 超過 leftNode <br />
     *          inEnd   : inorder.length - 1 <br />
     *
     *      </ol>
     * </ul>
     */
//    class Solution {
//        private Map<Integer, Integer> inorderMap = new HashMap<>();
//
//        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            for (int i = 0; i < inorder.length; i++) {
//                inorderMap.put(inorder[i], i);
//            }
//            return buildTree_dfs(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
//        }
//
//        private TreeNode buildTree_dfs(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
//            // 基本情況：當做到 leaf node 會發生 end 比 start 小，因此要跳過
//            if (preStart > preEnd || inStart > inEnd) {
//                return null;
//            }
//
//            // 根節點是 preorder 的第一個元素
//            int rootVal = preorder[preStart];
//            TreeNode root = new TreeNode(rootVal);
//
//            // 在 inorder 中找到根節點的位置
//            int inRootIndex = inorderMap.get(rootVal);
//            // 左子樹的節點數量
//            int leftTreeSize = inRootIndex - inStart;
//
//            // 遞歸構建左子樹
//            root.left = buildTree_dfs(preorder, preStart + 1, preStart + leftTreeSize, inStart, inRootIndex - 1);
//            // 遞歸構建右子樹
//            root.right = buildTree_dfs(preorder, preStart + leftTreeSize + 1, preEnd, inRootIndex + 1, inEnd);
//
//            return root;
//        }
//    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * Inorder 的當前元素等於 stop 時，表示到達了當前子樹的邊界，應該返回並結束遞歸。
     * 當 preorder = 20, inorder = 15, preorder 可以繼續往下看，因為對 inorder 都還在其左節點
     * 當 preorder = 15, inorder = 15, preorder 跟 inorder 一樣了，表示不會再有左邊的東西，所以要返回 null
     *
     * 以下的寫法難在要理解 stop 什麼時候會用到
     */
    class Solution {
        private int i = 0; // 用於追踪 Inorder 的位置
        private int p = 0; // 用於追踪 Preorder 的位置

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, Integer.MIN_VALUE);
        }

        private TreeNode build(int[] preorder, int[] inorder, int stop) {
            System.out.println("preorder: " + p + ", inorder:" + i + ", stop:" + stop);
            if (p >= preorder.length) {
                System.out.println("超過 preorder 囉");
                return null; // 當前置序列超出範圍時，返回 null
            }
            if (inorder[i] == stop) {
                System.out.println("preorder = inorder");
                ++i;
                // 當中序序列達到停止條件時，移動指針並返回 null
                return null;
            }
            TreeNode node = new TreeNode(preorder[p++]); // 根據當前 preorder 創建節點
            node.left = build(preorder, inorder, node.val); // 構建左子樹，停止條件為當前節點值: 做到 inorder 為自己的時候代表左邊沒有了
            node.right = build(preorder, inorder, stop); // 構建右子樹，停止條件為傳入的停止值: 做到 inorder 是上一層的 node 代表
            return node;
        }
    }

}
