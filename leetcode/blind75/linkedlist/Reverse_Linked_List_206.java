package linkedlist;

/**
 * 206.https://leetcode.com/problems/reverse-linked-list/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/03 16:05:05
 * @since JDK8.0
 */
public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        Reverse_Linked_List_206 s = new Reverse_Linked_List_206();
        Reverse_Linked_List_206.Solution solution = s.new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1);

        ListNode result = solution.reverseList(head);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 一個個建立並在放回到起首位置
         */
        public ListNode reverseList(ListNode head) {
            if(head == null) return null;
            ListNode tmp = new ListNode(head.val);
            while (head != null && head.next != null) {
                ListNode now = new ListNode(head.next.val);
                head = head.next;
                now.next = tmp;
                tmp = now;
            }
            return tmp;
        }
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) return head;
//
//            ListNode left = head;
//            ListNode right = head.next;
//            left.next = null;
//
//            while (right != null) {
//                ListNode tmp = right.next;
//                right.next = left;
//                left = right;
//                right = tmp;
//            }
//            return left;
//        }
    }
}
