package queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * 933.https://leetcode.com/problems/number-of-recent-calls/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/03 10:53:56
 * @since JDK8.0
 */
public class Number_of_Recent_Calls_933 {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
//        int t1 = 1, t100 = 100, t3001 = 3001, t3002 = 3002;
//        System.out.println(obj.ping(t1));
//        System.out.println(obj.ping(t100));
//        System.out.println(obj.ping(t3001));
//        System.out.println(obj.ping(t3002));


        int t642 = 642, t1849 = 1849, t4921 = 4921, t5936 = 5936, t5957 = 5957;
        System.out.println(obj.ping(t642));
        System.out.println(obj.ping(t1849));
        System.out.println(obj.ping(t4921));
        System.out.println(obj.ping(t5936));
        System.out.println(obj.ping(t5957));
    }


}

class RecentCounter {

    /**
     * Runtime: 2326 ms, Beats 5.01%
     * 解法:
     * 使用 queue 去紀錄內部
     */
//    private Queue<Integer> requests;
//
//    public RecentCounter() {
//        this.requests = new ArrayDeque<>();
//    }
//
//    public int ping(int t) {
//        this.requests.add(t);
//
//        int count = 0;
//        Iterator<Integer> iterator = this.requests.iterator();
//        while (iterator.hasNext()) {
//            int time = iterator.next();
//            if (time >= (t - 3000) && time <= t) {
//                count++;
//            }
//        }
//
//        return count;
//    }

    /**
     * Runtime: 17 ms, Beats 99.86%
     * 使用陣列紀錄
     */
    private int[] request = new int[10000];
    private int start;
    private int end;

    public RecentCounter() {
        this.start = 0;
        this.end = 0;
    }

    public int ping(int t) {
        // 這個 while 會找出 start ~ end 範圍是 3000 的
        // 如果不添加 start < end 有可能 start 一直都找不到比 t - 3000 大的
        // 如果 request 內有 642, 1849 此時 t = 4921，如果不添加 start < end
        // t - 3000 = 1921，start就會一直 ++ 直到超過 1921，但這樣就會 indexOutOfBound
        while (start < end && t - 3000 > request[start]) {
            start++;
        }

        request[end++] = t;

        return end - start;
    }
}