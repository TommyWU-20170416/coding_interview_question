package hashmapandset;

import java.util.*;

public class Unique_Number_Of_Occurrences_1207 {
    public static void main(String[] args) {
        Unique_Number_Of_Occurrences_1207 s = new Unique_Number_Of_Occurrences_1207();
        Unique_Number_Of_Occurrences_1207.Solution solution = s.new Solution();

//        int[] arr = {1, 2, 2, 1, 1, 3}; // return  true
        int[] arr = {1, 2, 2, 1, 1, 3, 0, 0, 0}; // return  true

        boolean result = solution.uniqueOccurrences(arr);
        System.out.println(result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 先遍歷一遍所有的值出現的次數，儲存到 map: [1,3] ，1出現3次
         * 接著再次遍歷一遍，檢查當前出現的次數是否有出現在 set 中，如果有，在 set add 的時候會 return false
         */
//        public boolean uniqueOccurrences(int[] arr) {
//            Map<Integer, Integer> map = new HashMap<>();
//            Set<Integer> set = new HashSet<>();
//            for (int i : arr) {
//                map.put(i, map.getOrDefault(i, 0) + 1);
//            }
//            for (int value : map.values()) {
//                if (!set.add(value)) {
//                    return false;
//                }
//            }
//
//            return true;
//        }

        /**
         * test2
         * 解法:
         * 依據題目給的範圍進行初始化，有效降低空間使用
         * 1 <= arr.length <= 1000
         * -1000 <= arr[i] <= 1000
         * 且查詢陣列會比查詢 set 或 map 還快
         */
        public boolean uniqueOccurrences(int[] arr) {
            int[] numberOfOccurrences = new int[2001];
            boolean[] used = new boolean[1001];

            for (int i : arr) {
                numberOfOccurrences[1000 + i]++; // [0 到 -999] 為  numberOfOccurrences[-1000 到 -1]，1000 開始為 0，
                // i =-1000, numberOfOccurrences[1000 + (-1000)]會加一次
                // 意思就是 numberOfOccurrences 是一個用把 arr 出現過的 value 當作是 index 紀錄出現過的次數
            }

            for (int i : arr) {
                int count = numberOfOccurrences[1000 + i];
                numberOfOccurrences[1000 + i] = 0; // 做過的就不用看
                if (count > 0) {
                    // 以 [1, 2, 2, 2, 3, 3, 3] 為例子
                    // 1 出現過 1 次、2 出現過 3 次、3 出現過 3 次

                    // 當 i = 1，numberOfOccurrences[1000 + 1] = 1
                    // 1 > 0，used[1] = true;

                    // 當 i = 2，numberOfOccurrences[1000 + 2] = 3
                    // 3 > 0，used[3] = true;

                    // 當 i = 1，numberOfOccurrences[1000 + 3] = 3
                    // 3 > 0，發現 used[3] = true; 代表已經重複次數了，則返回 false
                    if (used[count]) return false;
                    else used[count] = true;
                }
            }
            return true;
        }
    }
}
