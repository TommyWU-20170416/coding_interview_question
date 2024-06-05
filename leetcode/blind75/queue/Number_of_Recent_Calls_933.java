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
     * test1
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
     * test2
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
        // start 超過 end 會發散，因為 request 的 end 後面都是 0 ，相減後也不會 < 3000
        // start <= end 也會錯誤，若 start = end 會讓 start 前進到準備要放值的下一個位置，這樣當 end - start = 0就不對了
        //      意思就是當 end = 2，因為 start 可以做到 2 ，然後 條件成立(start <= end)，因此 start++ 也就跑到下一個位置 3 去了
        while (start <= end && t - request[start] > 3000) {
            start++;
        }

        request[end++] = t;

        return end - start;
    }
}