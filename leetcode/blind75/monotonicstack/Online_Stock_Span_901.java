package monotonicstack;

import java.util.*;

/**
 * 901.https://leetcode.com/problems/online-stock-span/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/04 13:20:23
 * @since JDK8.0
 */
public class Online_Stock_Span_901 {
    public static void main(String[] args) {
        // ["StockSpanner"  ,"next" ,"next" ,"next" ,"next" ,"next" ,"next" ,"next"]
        // [[]              ,[100]  ,[80]   ,[60]   ,[70]   ,[60]   ,[75]   ,[85]]
        // null             , 1     , 1     , 1     , 2     ,1      , 4     , 6
        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(100);
        int param_2 = obj.next(80);
        int param_3 = obj.next(60);
        int param_4 = obj.next(70);
        int param_5 = obj.next(60);
        int param_6 = obj.next(75);
        int param_7 = obj.next(85);

        System.out.println();
    }

}

/**
 * 使用 list 去紀錄
 * 每一次要尋找的時候就去找
 */
//class StockSpanner {
//    private List<Integer> list;
//
//    public StockSpanner() {
//        this.list = new ArrayList<>();
//    }
//
//    public int next(int price) {
//        list.add(price);
//        int count = 0;
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (price >= list.get(i))
//                count++;
//            else break;
//        }
//
//        return count;
//    }
//}

/**
 * 使用 stack 的方式
 * 讓 stack 內的都只保留比 price 還大的
 * price: [100]
 * - 儲存 (100, 1)
 * - 當前 stack: (100, 1)
 * <p>
 * price: [80]
 * - 儲存 (80, 1)
 * - 當前 stack: (100, 1), (80, 1)
 * <p>
 * price: [60]
 * - 儲存 (60, 1)
 * - 當前 stack: (100, 1), (80, 1), (60, 1)
 * <p>
 * price: [70]
 * - 發現 70 > 60，把 60 pop出來, 1 + 1 = 2
 * - 儲存 (70, 2)
 * - 當前 stack: (100, 1), (80, 1), (70, 2)
 * <p>
 * price: [60]
 * - 儲存 (60 ,1)
 * - 當前 stack: (100, 1), (80, 1), (70, 2), (60, 1)
 * <p>
 * price: [75]
 * - 發現 75 > 60，把 60 pop出來, 1 + 1 = 2
 * - 當前 stack: (100, 1), (80, 1), (70, 2)
 * - 發現 75 > 70，把 70 pop出來, 2 + 2 = 4
 * - 當前 stack: (100, 1), (80, 1)
 * - 發現 75 < 80 儲存 (75, 4)
 * - 當前 stack: (100, 1), (80, 1), (75, 4)
 * <p>
 * price: [85]]
 * - 發現 85 > 75，把 75 pop出來, 1 + 4 = 5
 * - 當前 stack: (100, 1), (80, 1)
 * - 發現 85 > 80，把 80 pop出來, 5 + 1 = 6
 * - 當前 stack: (100, 1)
 * - 發現 85 < 100 儲存 (85, 6)
 * - 當前 stack: (100, 1), (85, 6)
 */
class StockSpanner {
    //    Stack<int[]> st;
//
//    public StockSpanner() {
//        st = new Stack<>();
//    }
//
//    public int next(int price) {
//        int ans = 1;
//        while (st.size() > 0 && st.peek()[0] <= price) {
//            ans = ans + st.pop()[1];
//        }
//        st.push(new int[]{price, ans});
//        return ans;
//    }
    private Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            ans += st.pop()[1];
        }
        st.push(new int[]{price, ans});

        return ans;
    }
}