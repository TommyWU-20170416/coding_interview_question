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
         * Runtime: 0 ms, Beats 100.00%
         * test1
         * 解法:
         * 一個個建立並在放回到起首位置
         * 這樣寫 空間複雜度會是 O(N)，因為每一個點都要額外 new 出來
         */
//        public ListNode reverseList(ListNode head) {
//            if (head == null)
//                return null;
//            ListNode result = new ListNode(head.val);
//            head = head.next;
//            while (head != null) {
//                ListNode tmp = new ListNode(head.val);
//                tmp.next = result;
//                result = tmp;
//                head = head.next;
//            }
//            return result;
//        }

        /**
         * Runtime: 0 ms, Beats 100.00%
         * 這樣寫空間複雜度變成 O(1)
         * 因為只是改變指標的指向
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode temp = head;
            while(temp!= null){
                ListNode front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }
            return prev;
        }
    }
}
