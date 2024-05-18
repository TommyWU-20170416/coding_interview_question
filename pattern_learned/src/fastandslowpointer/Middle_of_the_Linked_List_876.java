package fastandslowpointer;

/**
 * 876.https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author AaronWU
 * @version 創建時間：2021年6月5日 下午10:01:42
 * @since JDK8.0
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3. (The judge's serialization of this node
 * is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and
 * ans.next.next.next = NULL.
 */
public class Middle_of_the_Linked_List_876 {

    public static void main(String[] args) {

        ListNode listnode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        Middle_of_the_Linked_List_876 test = new Middle_of_the_Linked_List_876();
        ListNode res = test.middleNode(listnode);
        test.middleNode2(listnode);
        System.out.println(res);
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 38.5 MB
     * time:O(n+m) space:O(1)
     * <p>
     * LeetCode 認為這樣跑比較快，可能因為最後 return 只要回傳度定吧，不用多判斷
     * <p>
     * 這題的 while 當 ListNode head 是奇數個，那麼當 fast 已經到最後的時候他的 next 就是 null，就代表他已經到底了
     * fast != null ==> 當偶數的時候，fast本身空的時間，就是到底了
     * fast.next != null ==> 當奇數的時候，fast.next 會是 null 就知道到底了
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 這樣寫可以少跑一次，因為 fast.next.next 先判斷了
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            System.out.println("enter middleNode2");
            slow = slow.next;
            fast = fast.next.next;
        }
        return (null == fast.next) ? slow : slow.next;
    }

}
