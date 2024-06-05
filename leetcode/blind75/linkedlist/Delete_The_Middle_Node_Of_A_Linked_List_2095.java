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

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));


        ListNode result = solution.deleteMiddle(head);
        System.out.println(result);
    }


    class Solution {
        /**
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
//            if(mid == 0) return null;
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
         * test2
         * 解法:
         * 使用 fast and slowpointer
         */
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode fast;
            fast = head.next.next;
            ListNode slow = head;


            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
