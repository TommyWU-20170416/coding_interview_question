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
        int[] nums1 = {5, 3, 3, 2}, nums2 = {2, 1, 3, 4};
        int k = 1;

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
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;

            // nums1 = {1,    3,     3,     2}
            // nums2 = {2,    1,     3,     4};
            // pairs = [1,2], [3,1], [3,3], [2,4]
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                pairs[i][0] = nums1[i];
                pairs[i][1] = nums2[i];
            }

            // 按 nums2 降序排序
            // 使用 pair 下去比較，也就是拿 [1, 2] 跟 [3, 1] 比較
            // a = [1, 2], b = [3, 1];
            // a[1] = 2  , b[1] = 1
            // 說白點就是比較 每一對 pair 的第二個元素大小，並且由大排到小
            Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

            // 最小堆来维护 nums1 的前 k 个最大的和
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
            long sum = 0;
            long maxScore = 0;

            for (int i = 0; i < n; i++) {
                int currNum1 = pairs[i][0];
                int currNum2 = pairs[i][1];
                minHeap.add(currNum1);
                sum += currNum1;
                if (minHeap.size() > k) {
                    sum -= minHeap.poll();
                }
                if (minHeap.size() == k) {
                    maxScore = Math.max(maxScore, sum * currNum2);
                }
            }
            return maxScore;
        }
    }
}
