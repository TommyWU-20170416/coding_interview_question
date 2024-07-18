package binarysearch;

/**
 * 278.https://leetcode.com/problems/first-bad-version/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/18 21:17:15
 * @since JDK8.0
 */
public class First_Bad_Version_278 {
    public static void main(String[] args) {
        First_Bad_Version_278 ss = new First_Bad_Version_278();
        First_Bad_Version_278.Solution solution = ss.new Solution();
//        int[] nums = {-1, 0, 3, 5, 9, 12};
//        int target = 9;
//        int n = 5, bad = 4;
        int n = 100, bad = 4;
        int result = solution.firstBadVersion(n);
        System.out.println("reuslt:" + result);
    }

    public class Solution {
        /**
         * Runtime: 25 ms, Beats 64.64%
         * 使用二分法去找出答案
         */
        public int firstBadVersion(int n) {
            int count = 0;
            int start = 1, end = n, midLast = 0;
            while (start <= end) {
                count++;
                int mid = start + (end - start) / 2;
                if (isBadVersion(mid)) {
                    midLast = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(count);
            return midLast;
        }

        private boolean isBadVersion(int mid) {
            return mid >= 4;
        }
    }
}
