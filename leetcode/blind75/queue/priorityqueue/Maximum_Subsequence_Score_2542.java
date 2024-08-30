package queue.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542.https://leetcode.com/problems/maximum-subsequence-score/description/?
 *
 * @author AaronWU
 * @created 創建時間：2024/06/19 15:35:04
 * @since JDK8.0
 * <p>
 * 2024/06/20
 * 這題目的解答 感覺有問題
 * 因為 queue 是先加上 在 poll，這樣不就有可能把自己給 poll 掉
 * 如果把自己 poll 掉，這樣乘上 nums2 最小值就不準
 * 可以把 k = 1 去看看
 * <p>
 * 看其他人的說法是這樣 https://leetcode.com/problems/maximum-subsequence-score/solutions/3082106/java-c-python-priority-queue/?envType=study-plan-v2&envId=leetcode-75
 * nums1 = [5,4,3,2,1]
 * nums2 = [5,4,3,2,1]
 * k = 3
 * During the 4th iteration, the possible sum values are 5,4,3,2 and the multiplication value is 2.
 * If we pop the value 2, the sum values are 5,4,3 which is accounted for in the previous iteration
 * where the multiplication value is 3 which would always be a greater answer.
 * Thus the calculated res from the 4th iteration would never be the final answer.
 * 大概意思就是即便移除了不正確的數值，可是總體相加也不會是最大的答案
 */
public class Maximum_Subsequence_Score_2542 {

    public static void main(String[] args) {
        Maximum_Subsequence_Score_2542 s = new Maximum_Subsequence_Score_2542();
        Maximum_Subsequence_Score_2542.Solution solution = s.new Solution();
//        int[] nums1 = {100, 3, 3, 2}, nums2 = {2, 1, 3, 4};
//        int k = 2; // Output: 206
        int[] nums1 = {10000, 1, 1000, 1}, nums2 = {1, 2, 3, 4};
        int k = 2; // Output:
        /**
         * 找出 nums1 & nums2 在相同的 index 中找最大值
         * There are four possible situations
         *
         * We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
         * We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
         * We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
         * We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
         * Therefore, we return the max score, which is 12.
         */
        long result = solution.maxScore(nums1, nums2, k);
        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 把 nums2 當作條件，因為乘法找到最大值會是比較有可能的
         * 並創建 pairs 排序
         * 可以找到 nums2 = 4, 3, 2, 1
         * 對應到   nums1 = 2, 3, 1, 3
         * 再依序使用 k 去添加到 queue 計算
         */
//        public long maxScore(int[] nums1, int[] nums2, int k) {
//            int n = nums1.length;
//
//            // nums1 = {1,    3,     3,     2}
//            // nums2 = {2,    1,     3,     4};
//            // pairs = [1,2], [3,1], [3,3], [2,4]
//            int[][] pairs = new int[n][2];
//            for (int i = 0; i < n; i++) {
//                pairs[i][0] = nums1[i];
//                pairs[i][1] = nums2[i];
//            }
//
//            // 按 nums2 降序排序
//            // 使用 pair 下去比較，也就是拿 [1, 2] 跟 [3, 1] 比較
//            // a = [1, 2], b = [3, 1];
//            // a[1] = 2  , b[1] = 1
//            // 說白點就是比較 每一對 pair 的第二個元素大小，並且由大排到小
//            // pairs = [2,4], [3,3], [1,2], [3,1]
//            Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
//
//            // 最小堆来维护 nums1 的前 k 个最大的和
//            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
//            long sum = 0;
//            long maxScore = 0;
//
//            for (int i = 0; i < n; i++) {
//                int currNum1 = pairs[i][0];
//                int currNum2 = pairs[i][1];
//                minHeap.add(currNum1);
//                sum += currNum1;
//                if (minHeap.size() > k) {
//                    sum -= minHeap.poll();
//                }
//                if (minHeap.size() == k) {
//                    maxScore = Math.max(maxScore, sum * currNum2);
//                }
//            }
//            return maxScore;
//        }

        /**
         * Runtime: 37 ms, Beats 99.37%
         * 使用類似 hash 把 nums1 跟 nums2 組合起來，然後由小排到大
         * 找前 K 大的算 score 並把 nums1 放到 queue
         * 繼續往下找比 queue.peek() 大的，再去做計算
         */
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = 100001, len = nums1.length;
            long[] arr = new long[len]; // 使用一個常數，因為最大的值是 10^5 所以 + 1 變成值數，下去算
            for (int i = 0; i < len; i++) {
                arr[i] = (long) nums2[i] * n + nums1[i];
            }
            Arrays.sort(arr); // [110001, 200003, 301003, 400005] 這樣排序 主要依照 nums2 的值，但也有可能 nums1 加上去會比較大
            long sum = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 因為已經對 nums2 排序過，所以這邊是放 nums1 是不是有更大的，後面的 for 會說明
            // 找前 K 大的相加並放到 queue
            for (int i = len - 1; i >= len - k; i--) {
                long num = arr[i] % n;
                sum += num;
                pq.offer(num);
            }
            long result = sum * (arr[len - k] / n);//  res = (1000 + 1) * 3 = 3003

            // 已這個條件來看 [110001, 200003, 301003, 400005] 簡化成 [(1, 10000), (2, 1), (3, 1000), (4, 1)]
            // 由於上面 res 已經算過前 K 大的，所以接下來就從 第 1 位開始看( 0-indexed )，此時 pq 內存放的是 (1, 1000)
            // 第一位 1 沒有比 pq.peek() 大，所以不用看
            // 第零位 10000 比 pq.peek() 大，代表說也許第零位 加上 第二或三位會大於之前的 res
            // 把 1 拿出來，把 10000 放進去，得到更大的答案
            for (int i = len - k - 1; i >= 0; i--) {
                long num = arr[i] % n;
                if (num > pq.peek()) {
                    sum += num;
                    pq.offer(num);
                    sum -= pq.poll();
                    result = Math.max(sum * (arr[i] / n), result);
                }
            }
            return result;
        }
    }
}
