package monotonicstack;

import java.util.Stack;

public class MonotonicStack {
    private Stack<Integer> stack;

    public MonotonicStack() {
        stack = new Stack<>();
    }

    /**
     * 如果 stack 裡面的值，比接下來的還大，我就把裡面的 pop 出來
     * 插入順序 3 1 2
     * 先放 3
     * 放 1 前，比對 3 > 1，把 3 拿出來，1 放進去
     * 放 2 前，比對 1 < 2，插入 2
     *
     * 保證 stack 都是有小 到 大，單調遞增
     */
    public void push(int x) {
        while (!stack.isEmpty() && stack.peek() > x) {
            stack.pop();
        }
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MonotonicStack ms = new MonotonicStack();
        ms.push(3);
        ms.push(1);
        ms.push(2);
        System.out.println(ms.peek()); // 應該輸出 2
        ms.pop();
        System.out.println(ms.peek()); // 應該輸出 1
    }
}
