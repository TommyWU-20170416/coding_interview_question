package fastandslowpointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.https://leetcode.com/problems/linked-list-cycle/
 *
 * @author AaronWU
 * @version 創建時間：2021年6月6日 上午10:53:11
 * @since JDK8.0
 *        這題會給 head 這裡面已經做好有 circle 的序列，所以當next一直下去就會無限loop
 *        Input: head = [3,2,0,-4], pos = 1
 *        Output: true
 *
 *        Input: head = [1], pos = -1
 *        Output: false
 *
 *        Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class Linked_List_Cycle_141 {
    private static ListNode head1 = new ListNode(1);
    private static ListNode head2 = new ListNode(2, head1);
    private static ListNode head = new ListNode(1, head2);

    public static void main(String[] args) {
        Linked_List_Cycle_141 test = new Linked_List_Cycle_141();
        System.out.println("hasCycle_Brute:" + test.hasCycle_FastAndSlowPointer(head));
        System.out.println("hasCycle_FastAndSlowPointer:" + test.hasCycle_FastAndSlowPointer(head));
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 42.8 MB
     * time:O(n) space:O(1)
     * 一樣用 Fast and Slow
     * 當如果今天有circle，就會發現slow跟fast一定會有相遇的一天。
     * 當如果今天無circle，fast走到底就會null，那麼就知道沒有circle。
     *
     * @param head
     * @return
     */
    public boolean hasCycle_FastAndSlowPointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

//
//    /**
//     * Runtime: 8 ms
//     * Memory Usage: 44.6 MB
//     * time:O(n) space:O(n)空間要多存n個紀錄，所以為n
//     *
//     * Brute Force紀錄每一個走過的值，找到走過的就是 return true
//     *
//     * @param head
//     * @return
//     */
//    public boolean hasCycle_Brute(ListNode head) {
////		List<Integer> list = new LinkedList<Integer>();
////		原本想說把 抓到的node的val存起來，藉此比對，但會發現一個問題就是這樣的node就不可以重複
//        Set<ListNode> set = new HashSet<ListNode>();
//        while (head != null) {
//            if (set.contains(head))
//                return true;
//
//            set.add(head);
//            // System.out.println(head.val);
//            head = head.next;
//            // System.out.println(head.val);
//        }
//        return false;
//
//    }
}

