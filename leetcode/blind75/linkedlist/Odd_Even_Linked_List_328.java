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
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.oddEvenList(head);
        System.out.println(result);
    }

    class Solution {
        /**
         * Runtime: 0 ms, Beats 100.00%
         * <p>
         * 1 -> 2 -> 3 -> 4 -> 5
         * 記憶體位置 707 -> 708 -> 709 -> 710 -> 711
         * oddHead = oddTmp   = 1(707) 的位置 707 -> 708 -> 709 -> 710 -> 711
         * evenHead = evenTmp = 2(708) 的位置     -> 708 -> 709 -> 710 -> 711
         *
         * <pre>
         * {@code
         * // 操作 odd.next = even.next
         * //       odd(目前位置)
         * //        |     even(目前位置)
         * //        |      |
         * // 操作前 707 -> 708 -> 709 -> 710 -> 711
         * // 操作後 707 -> 709 -> 710 -> 711
         * // 注意此時只是修改指向的位置 708 其實還在只是不再 練表內了
         *
         * // 操作 evenTmp.next = oddTmp.next;
         * //       even(目前位置)
         * //        |     odd(目前位置)
         * //        |      |
         * // 操作前 708 -> 709 -> 710 -> 711
         * // 操作後 708 -> 710 -> 711
         * // 注意此時只是修改指向的位置 709 其實還在只是不再 練表內了
         * }
         * </pre>
         * <p>
         * 跳脫條件
         * oddTmp.next = evenTmp.next; 使得跳脫條件要檢查 evenTmp 位置
         * 如果是偶數個，因為偶數會先跑到最後，所以也要檢查 evenTmp.next         *
         */
        public ListNode oddEvenList(ListNode head) {
            if (head == null     || head.next == null) return head;
            ListNode oddTmp = head, evenTmp = head.next;
            ListNode oddHead = oddTmp, evenHead = evenTmp;
            while (evenTmp != null && evenTmp.next != null) {
                oddTmp.next = evenTmp.next;
                oddTmp = oddTmp.next;
                evenTmp.next = oddTmp.next;
                evenTmp = evenTmp.next;
            }
            oddTmp.next = evenHead;
            return oddHead;
        }
//        public ListNode oddEvenList(ListNode head) {
//            if (head == null) return null;
//            else if (head.next == null || head.next.next == null) return head;
//
//            ListNode odd = new ListNode(head.val), even = new ListNode(head.next.val);
//            ListNode oddTmp = odd, evenTmp = even;
//            head = head.next.next;
//            while (head != null) {
//                oddTmp.next = new ListNode(head.val);
//                oddTmp = oddTmp.next;
//                head = head.next;
//                if(head == null) break;
//                evenTmp.next = new ListNode(head.val);
//                evenTmp = evenTmp.next;
//                head = head.next;
//            }
//            oddTmp.next = even;
//            return odd;
//        }
    }
}
