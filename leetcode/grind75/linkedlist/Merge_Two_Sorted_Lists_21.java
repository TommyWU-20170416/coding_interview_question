package linkedlist;

/**
 * 21.https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/20 16:52:56
 * @since JDK8.0
 */
public class Merge_Two_Sorted_Lists_21 {
    public static void main(String[] args) {
        Merge_Two_Sorted_Lists_21 ss = new Merge_Two_Sorted_Lists_21();
        Merge_Two_Sorted_Lists_21.Solution solution = ss.new Solution();

        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
//        ListNode list1 = new ListNode();
//        ListNode list2 = new ListNode();

        ListNode result = solution.mergeTwoLists(list1, list2);
        System.out.println(result);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * 想法是使用 result，每一次比較就new ListNode(val) 再放進去 result 內
         * <p>
         * 前三行判斷其實後面也有做，前三行剛開始是想要解決有任一一個為 null 的情況
         * 但後面 while 判斷有任一 null 就跳脫，且若為空 result(0) .next = null
         * 因此也會正確判斷回 null
         * <p>
         * 可以參照下方的簡寫，跟最後的答案很像，差異在我都會 new ListNode
         */
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            if (list1 == null && list2 == null) return null;
//            else if (list1 == null && list2 != null) return list2;
//            else if (list1 != null && list2 == null) return list1;
//
//            ListNode result = new ListNode(), tmp = result;
//            while (list1 != null && list2 != null) {
//                int val1 = list1.val, val2 = list2.val;
//                if (val1 == val2) {
//                    tmp.next = new ListNode(val1);
//                    tmp = tmp.next;
//                    tmp.next = new ListNode(val1);
//                    tmp = tmp.next;
//                    list1 = list1.next;
//                    list2 = list2.next;
//                } else if (val1 < val2) {
//                    tmp.next = new ListNode(val1);
//                    tmp = tmp.next;
//                    list1 = list1.next;
//                } else {
//                    tmp.next = new ListNode(val2);
//                    tmp = tmp.next;
//                    list2 = list2.next;
//                }
//            }
//            tmp.next = (list1 == null) ? list2 : list1;
//
//            return result.next;

        // 可以簡寫成這樣
//            ListNode result = new ListNode(), tmp = result;
//            while (list1 != null && list2 != null) {
//                if (list1.val <= list2.val) {
//                    tmp.next = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else {
//                    tmp.next = new ListNode(list2.val);
//                    list2 = list2.next;
//                }
//                tmp = tmp.next;
//            }
//            tmp.next = (list1 == null) ? list2 : list1;
//
//            return result.next;
//        }

        /**
         * Runtime: 0 ms, Beats 100.00%
         * 一樣的效率
         * 從 new ListNode 改成 指向 list1 或 list2
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = new ListNode(), tmp = result;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    tmp.next = list1;
                    list1 = list1.next;
                } else {
                    tmp.next = list2;
                    list2 = list2.next;
                }
                tmp = tmp.next;
            }
            tmp.next = (list1 == null) ? list2 : list1;

            return result.next;
        }
    }
}
