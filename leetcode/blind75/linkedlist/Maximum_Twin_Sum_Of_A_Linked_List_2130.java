package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Twin_Sum_Of_A_Linked_List_2130 {
    public static void main(String[] args) {
        Maximum_Twin_Sum_Of_A_Linked_List_2130 s = new Maximum_Twin_Sum_Of_A_Linked_List_2130();
        Maximum_Twin_Sum_Of_A_Linked_List_2130.Solution solution = s.new Solution();

//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2));

        int result = solution.pairSum(head);
        System.out.println(result);
    }

    class Solution {
        /**
         * Runtime: 10 ms, Beats 33.91% O(n + n/2)
         * 把 ListNode 內的資料放到 array
         * 然後再加總
         *
         * 即便 array 做操作很好，但需要額外的空間去操作
         */
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

        /**
         * Runtime: 5 ms, Beats 69.14% O(n + n/2)
         * <p>
         * 先做出 reverseListNode
         * 接著在過程中記錄 len
         * 最後在把 first last 比對 len / 2 次
         */
//        public int pairSum(ListNode head) {
//            ListNode first = head;
//            ListNode last = head;
//            ListNode tmp = new ListNode(last.val);
//            int count = 1;
//            // create reverse
//            while (last.next != null) {
//                count++;
//                last = last.next;
//                ListNode now = new ListNode(last.val);
//                now.next = tmp;
//                tmp = now;
//            }
//            last = tmp;
//            int maxSum = 0, round = count / 2;
//            while (round-- > 0) {
//                if ((first.val + last.val) > maxSum) {
//                    maxSum = first.val + last.val;
//                }
//                first = first.next;
//                last = last.next;
//            }
//            return maxSum;
//        }
        public int pairSum(ListNode head) {
            ListNode mid = head.next;
            ListNode tail = head.next.next;
            ListNode n;
            int max = 0;

            while (tail != null) {
                n = mid.next;
                mid.next = head;
                head = mid;
                mid = n;
                tail = tail.next.next;
            }

            while (mid != null) {
                max = Math.max(max, head.val + mid.val);
                head = head.next;
                mid = mid.next;
            }

            return max;
        }
    }
}
