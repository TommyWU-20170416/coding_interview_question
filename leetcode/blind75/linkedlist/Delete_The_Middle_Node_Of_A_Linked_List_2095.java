package linkedlist;

import java.util.List;

/**
 * 2095.https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/03 11:21:54
 * @since JDK8.0
 */

public class Delete_The_Middle_Node_Of_A_Linked_List_2095 {
    public static void main(String[] args) {
        Delete_The_Middle_Node_Of_A_Linked_List_2095 s = new Delete_The_Middle_Node_Of_A_Linked_List_2095();
        Delete_The_Middle_Node_Of_A_Linked_List_2095.Solution solution = s.new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))); // 偶數

        ListNode result = solution.deleteMiddle(head);
        System.out.println(result);
    }


    class Solution {
        /**
         * Runtime: 4 ms, Beats 19.63%
         * test1
         * 解法:
         * 先算出 mid 的位置
         * 再去裡面把 中間踢掉
         */
//        public ListNode deleteMiddle(ListNode head) {
//            int size = 0;
//            ListNode tmp = new ListNode();
//            tmp = head;
//            while (tmp != null) {
//                size++;
//                tmp = tmp.next;
//            }
//            int mid = size / 2;
//            if (mid == 0) return null;
//            size = 1;
//            tmp = head;
//            while (size != mid) {
//                tmp = tmp.next;
//                size++;
//            }
//            tmp.next = tmp.next.next;
//
//            return head;
//        }

        /**
         * Runtime: 3 ms, Beats 99.66%
         * test2
         * 解法:
         * 使用 fast and slowpointer
         * 但有點技巧上的變化
         * 這題是為了找到刪除點，也就是 n / 2 但實際上希望是停在 n / 2 的前一個
         * 也因此在初始化的時候 fast 多指定 head.next.next，等於他先去看下一次會不會遇到
         * 1, 2, 3, 4, 5, 6, 7。 4 是要被刪除的點
         * <pre>
         * {@code
         * 初始化前                初始化後
         * fast:1 > 3 > 5 > 7    3 > 5 > 7
         * slow:1 > 2 > 3 > 4    1 > 2 > 3
         * 按照以往這樣走，無法停在前面，所以把 fast = head.next.next
         * }
         * </pre>
         */
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode fast = head.next.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
