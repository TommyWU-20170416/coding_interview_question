package fastandslowpointer;

/**
 * 142.https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * @author AaronWU
 * @version 創建時間：2021年6月6日 上午11:51:53
 * @since JDK8.0
 */
public class Linked_List_Cycle_II_142 {

    public static void main(String[] args) {
        Linked_List_Cycle_II_142 test = new Linked_List_Cycle_II_142();
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 38.9 MB
     * time:O(n) space:O(1)
     * <p>
     * 當找到一樣的時候，代表有進入循環，並讓fast回歸到head，當兩者再度next就會找到起始的循環點
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
