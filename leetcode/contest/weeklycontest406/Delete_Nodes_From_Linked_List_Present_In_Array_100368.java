package weeklycontest406;

import java.util.HashSet;
import java.util.Set;

/**
 * 100368.https://leetcode.com/contest/weekly-contest-406/problems/delete-nodes-from-linked-list-present-in-array/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/14 11:14:33
 * @since JDK8.0
 */
public class Delete_Nodes_From_Linked_List_Present_In_Array_100368 {
    public static void main(String[] args) {
        Delete_Nodes_From_Linked_List_Present_In_Array_100368 ss = new Delete_Nodes_From_Linked_List_Present_In_Array_100368();
        Delete_Nodes_From_Linked_List_Present_In_Array_100368.Solution solution = ss.new Solution();
        int[] nums = {1};
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))))));
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))));
        ListNode result = solution.modifiedList(nums, node1);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * 先把所有的 nums 放進去 set 這樣之後比較好找
         * 在進到每一層的 node 去判斷，若 set.contain(node.val) 就把 node = node.next
         * 要注意的是要另外建立 tmp 去指到 head，然後讓 tmp 做處理，最後回傳 head 就好
         * 當下我只有針對 head 做，這樣在往下指的時候就沒辦法往回
         */
        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            head = modifiedList_helper(set, head);

            return head;
        }

        private ListNode modifiedList_helper(Set<Integer> sets, ListNode node) {
            ListNode result = null; // no 1
            ListNode tmp = null;
            while (node != null) {
                if (!sets.contains(node.val)) {
                    if (result == null) {
                        result = new ListNode(node.val);
                        tmp = result;
                    } else {
                        ListNode next = new ListNode(node.val);
                        tmp.next = next;
                        tmp = tmp.next;
                    }
                }
                if (node.next == null) break;
                node = node.next;
            }
            return result;
        }
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}

