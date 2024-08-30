package queue.priorityqueue;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * 2336.https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/06/19 14:40:51
 * @since JDK8.0
 */
public class Smallest_Number_in_Infinite_Set_2336 {

    public static void main(String[] args) {
        Smallest_Number_in_Infinite_Set_2336 s = new Smallest_Number_in_Infinite_Set_2336();

        // ["SmallestInfiniteSet", "addBack(2)", "popSmallest", "popSmallest", "popSmallest", "addBack(1)",
        // "popSmallest", "popSmallest", "popSmallest"]
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
        int a = obj.popSmallest();
        obj.addBack(2);
        a = obj.popSmallest();
        a = obj.popSmallest();
        a = obj.popSmallest();
        obj.addBack(1);
        a = obj.popSmallest();
        a = obj.popSmallest();
        a = obj.popSmallest();
    }
}

/**
 * test1
 * 解法:
 * 先把 1-1000放進去 queue內
 * 再依序取出要的資料
 * 或是用 contains 去檢查是否存在 O(n)
 */
//class SmallestInfiniteSet {
//
//    PriorityQueue<Integer> q = new PriorityQueue<>(1001);
//
//    public SmallestInfiniteSet() {
//        for (int i = 1; i <= 1000; i++) {
//            q.add(i);
//        }
//    }
//
//    public int popSmallest() {
//        int smallestNum = q.poll();
//        return smallestNum;
//    }
//
//
//    public void addBack(int num) {
//        if (!q.contains(num))
//            q.add(num);
//    }
//}

/**
 * test2
 * 解法:
 * 優化 addBack 的 contains
 * 因為每一次 contains 都是 O(n)
 * 所以建立一個數location，去表示當前做到哪裡
 * 有點像是紀錄 pop 做了幾次就返回多少
 * <p>
 * 當初使化時，q = [], location = 1;
 * pop, q = [], location = 2;
 * pop, q = [], location = 3;
 * add(1), 1 < 3, 且不在 q 內, q = [1]
 * add(4), 1 < 4, 且不再 q 內, q = [1, 4]
 * pop, q = [4], location = 3, return 1
 * <p>
 * 簡單說就是，location 會記錄當前做到最小的值是多少
 * 若有比他小的要增加就增加，比他大的不用管，因為都只會返回最小值
 */
class SmallestInfiniteSet {

    PriorityQueue<Integer> q;
    int location;

    public SmallestInfiniteSet() {
        q = new PriorityQueue<>();
        location = 1;
    }

    public int popSmallest() {
        if (q.isEmpty()) {
            return location++;
        }
        return q.poll();
    }


    public void addBack(int num) {
        if (num < location && !q.contains(num)) {
            q.add(num);
        }
    }
}