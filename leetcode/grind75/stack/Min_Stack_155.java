package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 155.https://leetcode.com/problems/min-stack/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/05 17:11:42
 * @since JDK8.0
 */
public class Min_Stack_155 {
    public static void main(String[] args) {
//        MinStack obj = new MinStack();
//        obj.push(-1);
//        obj.push(-2);
//        obj.push(-3);
//        obj.push(-2);
//        int param_1 = obj.getMin();
//        obj.pop();
//        int param_3 = obj.top();
//        int param_4 = obj.getMin();

        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        int param_1 = obj.getMin();
        obj.pop();
        int param_2 = obj.getMin();
        obj.pop();
        int param_3 = obj.getMin();
    }
}

/**
 * 這樣的實踐都是 O(1)
 * Runtime: 6ms, Beats 11.13%
 */
//class MinStack {
//
//    Stack<Integer> stack;
//    Stack<Integer> minStack;
//
//    public MinStack() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int val) {
//        stack.push(val);
//        if (minStack.isEmpty() || minStack.peek() >= val) {
//            minStack.push(val);
//        }
//    }
//
//    public void pop() {
//        if (stack.pop().equals(minStack.peek())) {
//            minStack.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}

/**
 * 利用 node 在每個節點上記錄最小值
 *
 * 相比 stack 有一點比較好的是每個節點只會儲存兩整 int 一個 next
 * 但是 stack & minStack 有可能是一樣多的，等於兩倍空間
 *
 * pop 的時候會比較快， stack 的 pop 還需要去做比對
 *
 * Runtime: 3 ms, Beats 100.00%
 */
class MinStack {
    Node head;

    public MinStack() {
    }

    public void push(int val) {
        Node tmp = new Node(val);
        if (head == null) {
            head = tmp;
            head.minVal = val;
        } else {
            tmp.minVal = Math.min(val, head.minVal);
            tmp.next = head;
            head = tmp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }
}

class Node {
    int val;
    Node next;
    int minVal;

    Node(int x) {
        val = x;
        next = null;
        minVal = Integer.MAX_VALUE;
    }
};