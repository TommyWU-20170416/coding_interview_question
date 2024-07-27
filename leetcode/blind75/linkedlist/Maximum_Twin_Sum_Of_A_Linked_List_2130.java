package linkedlist;
/**
 * 2130.https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/22 14:58:21
 * @since JDK8.0
 */
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

        /**
         * Runtime: 3 ms, Beats 100.00%
         * 這題使用 slow fast pointers 去找到中間的位置，並且搭配 reverse list 去做計算
         * <pre>
         * {@code
         * 1    2    3    4    5    6
         *      |    |
         *    slow   |
         *          fast
         * 做完第一次 while 迴圈: slow 跟 fast 就往後跳
         * head 變成 2    1    2    3    4    5    6
         * 1    2    3    4    5    6
         *           |         |
         *         slow        |
         *                    fast
         * }
         * 做完第二次 while 迴圈: slow 跟 fast 就往後跳
         * head 變成 3    2    1    2    3    4    5    6
         * 1    2    3    4    5    6
         *                |             |
         *              slow            |
         *                            fast(null)
         *
         * 接著開始做計算，直到 slow 變成 null
         * head 變成 3    2    1    2    3    4    5    6
         * slow 變成 4    5    6
         * }
         * </pre>
         */
        public int pairSum(ListNode head) {
            ListNode slow = head.next, fast = head.next.next;
            int sum = 0;
            // 創建 reverse list 以及找到中間位置
            while (fast != null) {
                ListNode slowTmp = slow.next;
                slow.next = head;
                head = slow;
                slow = slowTmp;
                fast = fast.next.next;
            }

            while (slow != null) {
                if ((slow.val + head.val) > sum) sum = slow.val + head.val;
                slow = slow.next;
                head = head.next;
            }

            return sum;
        }
    }
}
