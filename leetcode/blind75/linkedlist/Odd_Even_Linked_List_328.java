package linkedlist;

/**
 * 328.https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/03 16:05:18
 * @since JDK8.0
 */
public class Odd_Even_Linked_List_328 {
    public static void main(String[] args) {
        Odd_Even_Linked_List_328 s = new Odd_Even_Linked_List_328();
        Odd_Even_Linked_List_328.Solution solution = s.new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode result = solution.oddEvenList(head);
        System.out.println(result);
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode odd = head, even = head.next;
            ListNode oddHead = odd, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return oddHead;
        }
    }
}
