package linkedlist;

/**
 * @author AaronWU
 * @version 創建時間：2021年6月5日 下午10:09:20
 * @since JDK8.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
