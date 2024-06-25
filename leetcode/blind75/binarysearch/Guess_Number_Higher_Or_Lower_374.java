package binarysearch;


/**
 * 374.https://leetcode.com/problems/guess-number-higher-or-lower/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/20 16:33:18
 * @since JDK8.0
 */
public class Guess_Number_Higher_Or_Lower_374 {
    public static void main(String[] args) {


        Guess_Number_Higher_Or_Lower_374 s = new Guess_Number_Higher_Or_Lower_374();
        Guess_Number_Higher_Or_Lower_374.Solution solution = s.new Solution();

//        long reuslt = solution.guessNumber(10);
        int reuslt = solution.guessNumber(2126753390);
        System.out.println("result:" + reuslt);

    }


    class Solution {
        private int picked = 1702766719;

        public int guess(int num) {
            if (num > picked) {
                return -1;
            } else if (num < picked) {
                return 1;
            }
            return 0;
        }


        //        public int guessNumber(int n) {
//            long start = 0;
//            long end = n;
//
//            while (start <= end) {
//                long mid = (start + end) / 2;
//                long guessResult = guess((int)mid);
//
//                if (guessResult > 0) {
//                    start = mid + 1;
//                } else if (guessResult < 0) {
//                    end = mid - 1;
//                } else {
//                    return (int)mid;
//                }
//            }
//            return -1;
//        }

        /**
         * test2
         * 解法:
         * 把原本的 (start + end) /2 改成 start + (end - start) / 2
         * 可以避免逸位
         */
        public int guessNumber(int n) {
            int start = 0;
            int end = n;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int guessResult = guess(mid);

                if (guessResult > 0) {
                    start = mid + 1;
                } else if (guessResult < 0) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
