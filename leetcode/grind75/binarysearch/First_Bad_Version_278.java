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
        int n = 5, bad = 4;
        int result = solution.firstBadVersion(n);
        System.out.println("reuslt:" + result);
    }

    public class Solution {
        /**
         * Runtime: 25 ms, Beats 64.64%
         * 使用二分法去找出答案
         */
//        public int firstBadVersion(int n) {
//            int count = 0;
//            int start = 1, end = n, midLast = 0;
//            while (start <= end) {
//                count++;
//                int mid = start + (end - start) / 2;
//                if (isBadVersion(mid)) {
//                    midLast = mid;
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//            System.out.println(count);
//            return midLast;
//        }
        private boolean isBadVersion(int mid) {
            return mid >= 4;
        }

        /**
         * Runtime: 20 ms, Beats 99.25%
         * 一樣使用二分法，可是在操作過程中不太一樣
         * 如果今天 isBadVersion 回傳 true，且我們要往前找，所以一定是介於 start <= bad <= mid
         * 再往下一層呼叫的時候，mid 不用 + 1 ，因為有可能 mid 就是解
         * 最後當 start end 收斂的時候就是解
         */
        public int firstBadVersion(int n) {

            return binarySearch(1, n);
        }

        public int binarySearch(int start, int end) {
            if (start == end) {
                return start;
            }
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                return binarySearch(start, mid);
            } else {
                return binarySearch(mid + 1, end);
            }
        }
    }
}
