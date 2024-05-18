package fastandslowpointer;

/**
 * 143.https://leetcode.com/problems/reorder-list/
 *
 * @author AaronWU
 * @version 創建時間：2021年6月8日 下午10:53:53
 * @since JDK8.0
 */
public class Reorder_List_143 {
    private static ListNode head5 = new ListNode(5);
    private static ListNode head4 = new ListNode(4, head5);
    private static ListNode head3 = new ListNode(3, head4);
    private static ListNode head2 = new ListNode(2, head3);
    private static ListNode head = new ListNode(1, head2);

    public static void main(String[] args) {
        Reorder_List_143 test = new Reorder_List_143();
        test.reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode preMid = slow;
        ListNode cur = slow.next;// cur is mid
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preMid.next;
            preMid.next = next;
        }

        ListNode p1 = head;
        ListNode p2 = preMid.next;

        while (p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
