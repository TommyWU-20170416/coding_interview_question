package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Twin_Sum_Of_A_Linked_List_2130 {
    public static void main(String[] args) {
        Maximum_Twin_Sum_Of_A_Linked_List_2130 s = new Maximum_Twin_Sum_Of_A_Linked_List_2130();
        Maximum_Twin_Sum_Of_A_Linked_List_2130.Solution solution = s.new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));


        int result = solution.pairSum(head);
        System.out.println(result);
    }

    class Solution {
//        public int pairSum(ListNode head) {
//            List<Integer> list = new ArrayList<>();
//            while (head != null) {
//                list.add(head.val);
//                head = head.next;
//            }
//            int len = list.size();
//            int max = 0;
//            for (int i = 0; i < len / 2; i++) {
//                max = Math.max(max, list.get(i) + list.get(len - 1 - i));
//            }
//            return max;
//        }

        public int pairSum(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            int maxVal = 0;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 跑完之後 slow 得到 4 5 6、fast 得到 null
            ListNode nextNode, prev = null;
            while (slow != null) {
                nextNode = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nextNode;
            }
            // 跑完之後 prev 得到 6 5 4
            // 這邊跟 head       1 2 3 一起跑
            while (prev != null) {
                maxVal = Math.max(maxVal, head.val + prev.val);
                prev = prev.next;
                head = head.next;
            }

            return maxVal;
        }
    }
}
