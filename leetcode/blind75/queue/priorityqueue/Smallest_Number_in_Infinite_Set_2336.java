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
 * Runtime: 8 ms, Beats 100.00%
 * 當初使化時，q = [], location = 1;
 * pop, return 1, q = [], location = 2;
 * pop, return 2, q = [], location = 3;
 * add(1), 1 < 3, 且不在 q 內, q = [1]
 * add(4), 4 > 3, q = [1]
 * pop, return 1 q = [], location = 3,
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